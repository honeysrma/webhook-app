package com.webhook.mapper.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.webhook.dto.IVRPayloadRequestDto;
import com.webhook.entity.IVRPayloadEntity;
import com.webhook.mapper.IVRPayloadMapper;

@Service
public class IVRPayloadMapperImpl implements IVRPayloadMapper {

	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public IVRPayloadEntity dtoToEntity(IVRPayloadRequestDto dto) {
		IVRPayloadEntity ivrPayloadEntity = modelMapper.map(dto, IVRPayloadEntity.class);
		return ivrPayloadEntity;
	}

	@Override
	public IVRPayloadRequestDto EntityToDto(IVRPayloadEntity entity) {
		IVRPayloadRequestDto ivrPayloadRequestDto = modelMapper.map(entity, IVRPayloadRequestDto.class);
		return ivrPayloadRequestDto;
	}

}
