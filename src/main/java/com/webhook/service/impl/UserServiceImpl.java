package com.webhook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webhook.dto.UserDto;
import com.webhook.entity.UserEntity;
import com.webhook.mapper.UserMapper;
import com.webhook.repositories.UserEntityRepository;
import com.webhook.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserEntityRepository userEntityRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserEntity findEntitydByUserId(Long userId) {
		return userEntityRepository.findById(userId).orElse(null);
	}
	
	@Override
	public UserDto findDtoByUserId(Long userId) {
		UserEntity entity = findEntitydByUserId(userId);
		return userMapper.EntityToDto(entity);
	}

}
