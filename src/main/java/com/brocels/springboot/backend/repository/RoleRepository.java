package com.brocels.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brocels.springboot.backend.model.ERole;
import com.brocels.springboot.backend.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(ERole name);
}
