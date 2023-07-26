package com.webhook.mapper;


import com.webhook.dto.IVRPayloadRequestDto;
import com.webhook.entity.IVRPayloadEntity;

public interface IVRPayloadMapper {
	
	IVRPayloadEntity dtoToEntity(IVRPayloadRequestDto dto);
	IVRPayloadRequestDto EntityToDto(IVRPayloadEntity entity);
	
}
