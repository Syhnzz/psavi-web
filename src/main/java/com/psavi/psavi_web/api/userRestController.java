package com.psavi.psavi_web.api;

import com.psavi.core.entity.User;
import com.psavi.core.service.user.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class userRestController {

    @Autowired
    private userService userService;

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return (List<User>) userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getById(id);
    }
}
