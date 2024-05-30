package com.students.lms.mapper;

import com.students.lms.dto.UserDto;
import com.students.lms.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());

        // split a name
        String[] name = user.getName().split(" ");
        userDto.setFirstName(name[0]);
        userDto.setLastName(name[1]);

        if(user.getId() != null) {
            userDto.setId(user.getId());
        }
        userDto.setBooks(user.getBooks());
        userDto.setRoles(user.getRoles());
        return userDto;
    }

    public static User mapToUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());

        user.setBooks(userDto.getBooks());


        if(userDto.getId() != null) {
            user.setId(userDto.getId());
        }

        user.setRoles(userDto.getRoles());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
