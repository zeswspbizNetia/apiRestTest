package com.netia.pl.spring.security.login.controllers;

import com.netia.pl.spring.security.login.models.EnumRole;
import com.netia.pl.spring.security.login.payload.dto.UserInfoDto;
import com.netia.pl.spring.security.login.payload.dts.UserInfoDts;
import com.netia.pl.spring.security.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/all")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<UserInfoDts> allAccess() {
		return userService.getAllUsers();
	}

	@GetMapping("/roles")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<EnumRole> getAllRoles() {
		return Arrays.asList(EnumRole.values());
	}

	@GetMapping("{userId}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public UserInfoDts getUser(@PathVariable Long userId) {
		return userService.getUserId(userId);
	}

	@PatchMapping("{userId}")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public UserInfoDts updateUser(@PathVariable Long userId, @RequestBody UserInfoDto userInfoDto) {
		return userService.updateUser(userId, userInfoDto);
	}

	@DeleteMapping("{userId}")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable Long userId) {
		 userService.deleteUser(userId);
	}


}
