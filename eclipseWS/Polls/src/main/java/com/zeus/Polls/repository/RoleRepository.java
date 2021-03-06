package com.zeus.Polls.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zeus.Polls.model.Role;
import com.zeus.Polls.model.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(RoleName roleName);
}
