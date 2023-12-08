package dev.ananda.poc.service;

import dev.ananda.poc.dto.UserDto;

import java.util.List;

public interface UserService {
  String addUser(String name, String email);

  public List<UserDto> getAllUsers();
}
