package com.webhook.security.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@WebFilter("/*") // Apply the filter to all URLs
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomHeaderFilter implements Filter {

	
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String originHeader = "*";
//        originHeader += "https://testpartner.mhealth.ai;";
//        originHeader += "https://additional.example.com;";
//        originHeader += "https://testpartner.mhealth.ai;";
//        originHeader += "https://partner.mhealth.ai;";
//        originHeader += "https://www.mhealth.ai;";
//        originHeader += "https://mhealth.ai;";
//        originHeader += "https://testapi.mhealth.ai;";
//        originHeader += "https://testapi.mhealth.ai:8081;";
//        originHeader += "https://w21.mhealth.ai;";
//        originHeader += "https://walkathon21.com;";
//        originHeader += "https://www.nutriexpert.io;";
//        originHeader += "http://testapi.mhealth.ai:8086;";
//        originHeader += "http://testapi.mhealth.ai;";
        
        // Add the desired headers to the response
        httpResponse.setHeader("Access-Control-Allow-Origin", originHeader);
        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        httpResponse.setHeader("Access-Control-Allow-Headers", "*");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("X-Frame-Options", "DENY");
        
        // Continue the filter chain
        chain.doFilter(request, httpResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic if needed
    }

    @Override
    public void destroy() {
        // Cleanup logic if needed
    }
}
