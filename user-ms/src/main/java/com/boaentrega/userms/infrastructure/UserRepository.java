package com.boaentrega.userms.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boaentrega.userms.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
