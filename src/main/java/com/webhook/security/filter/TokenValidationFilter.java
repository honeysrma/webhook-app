package com.webhook.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.webhook.common.service.DateUtility;
import com.webhook.common.service.UtilityService;
import com.webhook.constants.AppConstants;
import com.webhook.constants.UtilConstant;
import com.webhook.dto.APIResponseDto.APIResponseBuilder;
import com.webhook.dto.OAuthTokenDto;
import com.webhook.dto.UserDto;
import com.webhook.exceptions.NotFoundException;
import com.webhook.security.service.AuthTokenService;
import com.webhook.service.UserService;
import com.webhook.service.impl.CallTriggerServiceImpl;

@Service
public class TokenValidationFilter extends OncePerRequestFilter {

	private static final Logger logger = LoggerFactory.getLogger(TokenValidationFilter.class);
	
	private final AuthTokenService authTokenService;
	private final UserService userService;
	private final UtilityService utilityService;
	

	public TokenValidationFilter(AuthTokenService authTokenService, UserService userService, UtilityService utilityService) {
		this.authTokenService = authTokenService;
		this.userService = userService;
		this.utilityService = utilityService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		logger.info("Request URI ---> {}", request.getRequestURI());
		if(utilityService.getSkipAPIList().stream().filter(e->request.getRequestURI().contains(e)).count()>0) {
			filterChain.doFilter(request, response);
			return;
		}
		
		String tokenHeader = request.getHeader(UtilConstant.AUTHORIZATION);
		try {
			 if (tokenHeader != null && tokenHeader.startsWith(UtilConstant.BEARER+UtilConstant.SPACE)) {
		            String token = tokenHeader.substring(7); // Remove "Bearer " prefix
		            if (authTokenService.isTokenValid(token)) {
		            	OAuthTokenDto authTokenDto  = authTokenService.findTokenDtoByToken(token);
		            	if(authTokenDto.getExpiryTime().compareTo(DateUtility.getSystemCurrentDateTime())<1 ) {
		            		throw new NotFoundException("Expired Token!");
		            	}
		                // Check if the user exists in the database
		                UserDto user = userService.findDtoByUserId(authTokenDto.getUserId());
		                if (user != null) {
		                    // Create the authentication object and set it in the SecurityContext
		                //    Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, null);
		                 //   SecurityContextHolder.getContext().setAuthentication(authentication);
		                }else {
		                	throw new NotFoundException("Invalid Token!");
		                }
		                filterChain.doFilter(request, response);
		            }else {
		            	throw new NotFoundException("Invalid Token!");
		            }
		        } else {
		        	throw new NotFoundException("Invalid Token!");
		        }
		} catch (Exception e) {
			logger.error("Exception {}", e.getMessage(), e);
			APIResponseBuilder builder = new APIResponseBuilder();
			builder.withStatusCode(HttpServletResponse.SC_BAD_REQUEST).withMessage(e.getMessage());
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			response.getWriter().write(utilityService.convertDtoToJson(builder.build()));
		}
	}
}
