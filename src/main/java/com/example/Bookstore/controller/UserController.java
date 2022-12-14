package com.example.Bookstore.controller;

import com.example.Bookstore.model.User;
import com.example.Bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        if (userRepository.findByUsername(user.getUsername()) != null) {
            bindingResult.rejectValue("username", "err.username", "Username already exists");
            return "register";
        }

        if (userRepository.findByEmail(user.getEmail()) != null) {
            bindingResult.rejectValue("email", "err.email", "Email already exists");
            return "register";
        }

        String password = user.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPassword = encoder.encode(password);

        user.setPassword(encryptedPassword);
        user.setRole("USER");

        userRepository.save(user);

        return "redirect:/login";
    }

}
