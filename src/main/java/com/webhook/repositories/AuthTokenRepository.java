package com.webhook.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webhook.entity.OAuthTokenEntity;

@Repository
public interface AuthTokenRepository extends JpaRepository<OAuthTokenEntity, Long> {

	@Query("FROM OAuthTokenEntity where token=:token and user_id is not null")
	OAuthTokenEntity findByTokenEntity(String token);
	
	@Query(value = "select * from trns_oauth_tokens tot where tot.user_id IN (select mu.id_mst_users from mst_users mu where mu.mobile_number IN (select mc.phone_number from mst_coach mc where mc.id_mst_coach=:coachId))", nativeQuery = true)
	List<OAuthTokenEntity> findByCoachIdAuthTokenEntity(Long coachId);	
	
}
