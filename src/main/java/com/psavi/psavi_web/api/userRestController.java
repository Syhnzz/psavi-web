package com.psavi.psavi_web.api;

import com.psavi.core.entity.User;
import com.psavi.core.service.user.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

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

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/current")
    public User getCurrentUser(Principal principal) {
        System.out.println("Current user: " + principal.getName());
        return userService.getByEmail(principal.getName());
    }

}
