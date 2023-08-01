package com.webhook.mapper.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.webhook.dto.OAuthTokenDto;
import com.webhook.entity.OAuthTokenEntity;
import com.webhook.exceptions.NotFoundException;
import com.webhook.mapper.OAuthTokenMapper;

@Service
public class OAuthTokenMapperImpl implements OAuthTokenMapper {

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public OAuthTokenEntity dtoToEntity(OAuthTokenDto dto) {
		OAuthTokenEntity entity = modelMapper.map(dto, OAuthTokenEntity.class);
		return entity;
	}

	@Override
	public OAuthTokenDto EntityToDto(OAuthTokenEntity entity)throws NotFoundException {
		OAuthTokenDto dto = modelMapper.map(entity, OAuthTokenDto.class);
		return dto;
	}
}
