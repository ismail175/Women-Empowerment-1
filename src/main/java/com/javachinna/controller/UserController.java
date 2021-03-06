package com.javachinna.controller;

import com.javachinna.model.Profession;
import com.javachinna.model.User;
import com.javachinna.service.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.javachinna.config.CurrentUser;
import com.javachinna.dto.LocalUser;
import com.javachinna.util.GeneralUtils;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserServiceImpl userService;


	@RequestMapping(value="/users", method = RequestMethod.GET)
	public List<User> listUser(){
		return userService.findAll();
	}

	@RequestMapping(value = "/users/{email}", method = RequestMethod.GET)
	public User getOne(@PathVariable(value = "email") String email) {
		//return modelMapper.map(userService.findById(id),UserDto.class);
		return userService.findUserByEmail (email);
	}

	@ApiOperation(value = "nbrUserByProfession")
	@GetMapping("/getNombrsCandidacy/{professeion}")
	@ResponseBody
	public List<Object> nbrUserByProfession(@PathVariable(name = "professeion") Profession professeion)
	{
		return userService.nbrUserByProfession (professeion);
	}
}