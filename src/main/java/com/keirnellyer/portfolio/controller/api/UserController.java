package com.keirnellyer.portfolio.controller.api;

import com.keirnellyer.portfolio.entity.User;
import com.keirnellyer.portfolio.service.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseBody
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }
}
