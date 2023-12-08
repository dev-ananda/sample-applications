package dev.ananda.poc.service.impl;

import dev.ananda.poc.dto.UserDto;
import dev.ananda.poc.mysql.entity.User;
import dev.ananda.poc.repository.UserRepository;
import dev.ananda.poc.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  @Autowired private UserRepository userRepository;

  @Override
  public String addUser(String name, String email) {
    User n = new User();
    n.setName(name);
    n.setEmail(email);
    userRepository.save(n);

    return "success";
  }

  @Override
  public List<UserDto> getAllUsers() {
    Iterable<User> userIterable = userRepository.findAll();

    List<UserDto> userList = new ArrayList<>();
    for (User user : userIterable) {
      UserDto userDto = new UserDto();
      BeanUtils.copyProperties(user, userDto);
      userList.add(userDto);
    }

    return userList;
  }
}
