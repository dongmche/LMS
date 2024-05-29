package com.students.student_managment_system.mapper;

import com.students.student_managment_system.dto.UserDto;
import com.students.student_managment_system.entity.Book;
import com.students.student_managment_system.entity.User;

import java.util.Set;
import java.util.stream.Collectors;

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
//        userDto.getBooks().addAll(user.getBooks());
        return userDto;
    }

    public static User mapToUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());

        user.setBooks(userDto.getBooks());
//        user.getBooks().addAll(userDto.getBooks());

        if(userDto.getId() != null) {
            user.setId(userDto.getId());
        }

        // should encrypt password
        user.setPassword(userDto.getPassword());
        return user;
    }
}
