package com.webhook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webhook.entity.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
	
	@Query("FROM UserEntity where mobileNumber=:mobileNumber")
	UserEntity findByMobileNumber(String mobileNumber);
}
