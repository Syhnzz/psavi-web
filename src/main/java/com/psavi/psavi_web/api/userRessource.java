package com.psavi.psavi_web.api;

import com.psavi.core.entity.User;
import com.psavi.core.service.serviceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userRessource {

    @Autowired
    private serviceInterface<User, String> userService;

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }
}
