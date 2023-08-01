package com.webhook.mapper.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.webhook.constants.UtilConstant;
import com.webhook.dto.CoachConnectDTO;
import com.webhook.entity.CoachConnectEntity;
import com.webhook.mapper.CoachConnectMapper;

@Service
public class CoachConnectMapperImpl implements CoachConnectMapper {

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public CoachConnectEntity dtoToEntity(CoachConnectDTO dto) {
		CoachConnectEntity entity = modelMapper.map(dto, CoachConnectEntity.class);
		return entity;
	}

	@Override
	public CoachConnectDTO EntityToDto(CoachConnectEntity entity) {
		CoachConnectDTO dto = modelMapper.map(entity, CoachConnectDTO.class);
		dto.setCustomerName(entity.getUser().getFirstName()+UtilConstant.SPACE+entity.getUser().getLastName());
		return dto;
	}

}
