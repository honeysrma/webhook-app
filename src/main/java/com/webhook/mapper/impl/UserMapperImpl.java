package com.webhook.mapper.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.webhook.dto.UserDto;
import com.webhook.entity.UserEntity;
import com.webhook.mapper.UserMapper;

@Service
public class UserMapperImpl implements UserMapper {
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public UserEntity dtoToEntity(UserDto dto) {
		UserEntity entity = modelMapper.map(dto, UserEntity.class);
		return entity;
	}
	
	@Override
	public UserDto EntityToDto(UserEntity entity) {
		UserDto dto = modelMapper.map(entity, UserDto.class);
		return dto;
	}

}
