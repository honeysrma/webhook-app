package com.webhook.mapper;

import com.webhook.dto.OAuthTokenDto;
import com.webhook.entity.OAuthTokenEntity;

public interface OAuthTokenMapper {

	OAuthTokenEntity dtoToEntity(OAuthTokenDto dto);

	OAuthTokenDto EntityToDto(OAuthTokenEntity entity);
	
	

}
