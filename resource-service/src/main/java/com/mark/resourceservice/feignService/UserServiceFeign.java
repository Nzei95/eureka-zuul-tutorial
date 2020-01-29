package com.mark.resourceservice.feignService;

import com.mark.resourceservice.dtos.UserDetailsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserServiceFeign {

    @PostMapping(value = "/api/saveUpdate")
    UserDetailsDTO saveUpdate(@RequestBody UserDetailsDTO inputUser);

    @GetMapping(value = "/api/apiById/{id}")
    UserDetailsDTO getUserById(@PathVariable Long id);

    @GetMapping(value = "/api/getByName/{name}")
    List<UserDetailsDTO> getUserByName(@PathVariable String name);
}
