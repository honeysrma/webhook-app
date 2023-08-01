package com.webhook.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webhook.constants.UtilConstant;
import com.webhook.dto.OAuthTokenDto;
import com.webhook.entity.OAuthTokenEntity;
import com.webhook.exceptions.NotFoundException;
import com.webhook.mapper.OAuthTokenMapper;
import com.webhook.repositories.AuthTokenRepository;
import com.webhook.security.service.AuthTokenService;

import io.jsonwebtoken.lang.Collections;

@Service
public class AuthTokenServiceImpl implements AuthTokenService {

	@Autowired
	private AuthTokenRepository authTokenRepository;

	@Autowired
	private OAuthTokenMapper oAuthTokenMapper;

	@Override
	public OAuthTokenEntity findEntityByToken(String token) {
		OAuthTokenEntity entity = authTokenRepository.findByTokenEntity(token);
		return entity;
	}

	@Override
	public boolean isTokenValid(String token) {
		OAuthTokenEntity authToken = findEntityByToken(token);
		return authToken != null;
	}

	@Override
	public OAuthTokenDto findTokenDtoByToken(String token) {
		OAuthTokenEntity entity = findEntityByToken(token);
		return oAuthTokenMapper.EntityToDto(entity);
	}
	
	@Override
	public OAuthTokenEntity findEntityByCoachId(Long coachId) {
		OAuthTokenEntity entity = null;
		List<OAuthTokenEntity> list = authTokenRepository.findByCoachIdAuthTokenEntity(coachId);
		if (!Collections.isEmpty(list))
			entity= list.stream().findFirst().get();
		else
			throw new NotFoundException(UtilConstant.DATA_NOT_FOUND+ ": coachId -"+ coachId);
		return entity;
	}
	
	@Override
	public OAuthTokenDto findDtoByCoachId(Long coachId) throws NotFoundException {
		OAuthTokenEntity entity = findEntityByCoachId(coachId);
		return oAuthTokenMapper.EntityToDto(entity);
	}
	
}
