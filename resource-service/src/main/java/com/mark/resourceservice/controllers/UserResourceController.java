package com.mark.resourceservice.controllers;

import com.mark.resourceservice.dtos.UserDetailsDTO;
import com.mark.resourceservice.feignService.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResourceController {

    @Autowired
    private UserServiceFeign userServiceFeign;

    @PostMapping("/saveUpdate")
    public UserDetailsDTO saveUpdate(@RequestBody UserDetailsDTO inputUser){
        return userServiceFeign.saveUpdate(inputUser);
    }

    @GetMapping("/getById/{id}")
    public UserDetailsDTO getUserById(@PathVariable Long id){
        return userServiceFeign.getUserById(id);
    }

    @GetMapping("/getByName/{name}")
    public List<UserDetailsDTO> getUserByName(@PathVariable String name){
        return userServiceFeign.getUserByName(name);
    }


}
