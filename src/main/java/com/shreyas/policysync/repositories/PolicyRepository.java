package com.shreyas.policysync.repositories;

import com.shreyas.policysync.entities.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Long>{
}
