package com.webhook.service;

import com.webhook.dto.UserDto;
import com.webhook.entity.UserEntity;

public interface UserService {

	UserEntity findEntitydByUserId(Long userId);

	UserDto findDtoByUserId(Long userId);

}
