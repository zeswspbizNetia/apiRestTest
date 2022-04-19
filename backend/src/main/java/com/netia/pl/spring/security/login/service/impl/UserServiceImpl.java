package com.netia.pl.spring.security.login.service.impl;

import com.netia.pl.spring.security.login.models.EnumRole;
import com.netia.pl.spring.security.login.models.Role;
import com.netia.pl.spring.security.login.models.User;
import com.netia.pl.spring.security.login.payload.dto.UserInfoDto;
import com.netia.pl.spring.security.login.payload.dts.UserInfoDts;
import com.netia.pl.spring.security.login.repository.RoleRepository;
import com.netia.pl.spring.security.login.repository.UserRepository;
import com.netia.pl.spring.security.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<UserInfoDts> getAllUsers() {

		List<User> usersList = userRepository.findAll();
		List<UserInfoDts> userInfoDtsList = new ArrayList<>();
		usersList.forEach(user-> {
			UserInfoDts userInfoDts = getUserInfoDts(user);
			userInfoDtsList.add(userInfoDts);
		});
		return userInfoDtsList;
	}

	private UserInfoDts getUserInfoDts(User user) {
		UserInfoDts userInfoDts = new UserInfoDts();
		userInfoDts.setUsername(user.getUsername());
		userInfoDts.setEmail(user.getEmail());
		userInfoDts.setId(user.getId());
		userInfoDts.setRoles(user.getRoles().stream().map(s->s.getName().name()).collect(Collectors.toList()));
		return userInfoDts;
	}

	@Override
	public UserInfoDts getUserId(Long userId) {
		User user = userRepository.getById(userId);
		return getUserInfoDts(user);

	}

	@Override
	public UserInfoDts updateUser(Long userId, UserInfoDto userInfoDto) {
		User user = userRepository.getById(userId);
		user.setUsername(userInfoDto.getUsername());
		user.setEmail(userInfoDto.getEmail());
		user.setRoles(Collections.singleton(roleRepository
				.findByName(EnumRole.valueOf(userInfoDto.getRole()))
				.orElseThrow(() -> new EntityExistsException())));

		return getUserInfoDts(user);
	}

	@Override
	public void deleteUser(Long userId) {
		User user = userRepository.getById(userId);
		if(user.getRoles().stream().anyMatch(r->r.getName().name().equals(EnumRole.ROLE_ADMIN))){
			throw new EntityExistsException();
		};
		userRepository.delete(user);
	}
}
