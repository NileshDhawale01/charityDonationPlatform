package com.cdp.charity.repositoryes;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdp.charity.entityes.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo, Integer>{

	Optional<UserInfo> findByName(String name);
}
