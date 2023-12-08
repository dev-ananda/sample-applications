package dev.ananda.poc.controller;

import dev.ananda.poc.dto.UserDto;
import dev.ananda.poc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

  @Autowired private UserService userService;

  @PostMapping
  public String addNewUser(@RequestParam String name, @RequestParam String email) {
    return userService.addUser(name, email);
  }

  @GetMapping(path = "/all")
  public List<UserDto> getAllUsers() {
    return userService.getAllUsers();
  }
}
