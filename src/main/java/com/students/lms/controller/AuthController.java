package com.students.lms.controller;

import com.students.lms.dto.ReportDto;
import com.students.lms.service.UserService;
import com.students.lms.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    // handler method to handle login request
    @GetMapping("/login")
    public String login(){
        return "login";
    }


    // handler method to handle user registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String registerUser(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model) {
        UserDto exitingUser = userService.findUserByEmail(userDto.getEmail());

        if (exitingUser != null){
            result.rejectValue("email", null, "email already used");
        }
        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }
        userService.createUser(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model){
        List<UserDto> users = userService.findAllUser();
        model.addAttribute("users", users);

        return "users";
    }



    @GetMapping("/users/{id}/edit")
    public String editUserGetRoute(@PathVariable long id, Model model){
        UserDto  userDto = userService.findById(id);
        model.addAttribute("user", userDto);
        return "edit_user";
    }

    @PostMapping("/users/{id}/edit")
    public String editUserPostRoute(@Valid @ModelAttribute("user") UserDto userDto,
                                    BindingResult result,
                                    Model model){
        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "redirect:/users/"+ userDto.getId() + "/edit?error";
        }

        return "redirect:/users/"+ userDto.getId() + "/edit?success";
    }



    @GetMapping("/current-user")
    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                return "authenticate";

            } else {
                return "authenticate";
            }
        }
        return "authenticate";

    }



}
