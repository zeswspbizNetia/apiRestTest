package com.netia.pl.spring.security.login.service;

import com.netia.pl.spring.security.login.payload.dto.UserInfoDto;
import com.netia.pl.spring.security.login.payload.dts.UserInfoDts;

import java.util.List;

public interface UserService {
	List<UserInfoDts> getAllUsers();

	UserInfoDts getUserId(Long userId);

	UserInfoDts updateUser(Long userId, UserInfoDto userInfoDto);

	void deleteUser(Long userId);
}
