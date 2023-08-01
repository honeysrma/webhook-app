package com.webhook.mapper;

import com.webhook.dto.UserDto;
import com.webhook.entity.UserEntity;

public interface UserMapper {

	UserEntity dtoToEntity(UserDto dto);

	UserDto EntityToDto(UserEntity entity);

}
