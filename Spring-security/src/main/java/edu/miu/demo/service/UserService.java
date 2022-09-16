package edu.miu.demo.service;


import edu.miu.demo.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto create(UserDto userDto);

    UserDto findById(int id);

    void delete(int id);
}
