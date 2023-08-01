package com.webhook.mapper;

import com.webhook.dto.CoachConnectDTO;
import com.webhook.entity.CoachConnectEntity;

public interface CoachConnectMapper {

	CoachConnectEntity dtoToEntity(CoachConnectDTO dto);

	CoachConnectDTO EntityToDto(CoachConnectEntity entity);

}
