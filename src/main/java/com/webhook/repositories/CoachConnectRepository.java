package com.webhook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webhook.entity.CoachConnectEntity;

public interface CoachConnectRepository  extends JpaRepository<CoachConnectEntity, Long> {

	@Query(value = "select * FROM trns_coach_connect where id_mst_coach=:coachId and is_active=:isActive and cast(scheduled_connect_time as date) >= cast(now() as date)", nativeQuery = true)
	List<CoachConnectEntity> findAllByCoachIdAndIsActive(Integer coachId, Integer isActive);
	
	List<CoachConnectEntity> findAllBymobileNumberCoach(Long mobileNumberCoach);
	
}
