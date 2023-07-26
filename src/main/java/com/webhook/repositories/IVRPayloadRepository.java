package com.webhook.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webhook.entity.IVRPayloadEntity;

@Repository
public interface IVRPayloadRepository extends JpaRepository<IVRPayloadEntity, Integer> {
   
}
