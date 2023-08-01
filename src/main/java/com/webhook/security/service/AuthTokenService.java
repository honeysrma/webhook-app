package com.webhook.security.service;

import com.webhook.dto.OAuthTokenDto;
import com.webhook.entity.OAuthTokenEntity;

public interface AuthTokenService {

	boolean isTokenValid(String token);

	OAuthTokenEntity findEntityByToken(String token);

	OAuthTokenDto findTokenDtoByToken(String token);

	OAuthTokenDto findDtoByCoachId(Long coachId);

	OAuthTokenEntity findEntityByCoachId(Long coachId);

}
