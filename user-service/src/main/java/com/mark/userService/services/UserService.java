package com.mark.userService.services;

import com.mark.userService.dtos.UserDetailsDTO;
import com.mark.userService.entities.UserDetails;
import com.mark.userService.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;

    /**
     * Save the user and return the saved user details
     * @param inputUser
     * @return
     */
    @Transactional
    public UserDetailsDTO saveUpdate(UserDetailsDTO inputUser){
        try{
            UserDetails userDetails = new UserDetails();
            userDetails.setName(inputUser.getName());
            userDetails.setAge(Integer.parseInt(inputUser.getAge()));
            return getUserDetailsDTO(repository.save(userDetails));
        }catch (Exception e){
            LOGGER.warn("/*************** Exception in UserService -> saveUpdate(); " + e);
        }
        return null;
    }

    /**
     * Returns the user details based on id
     * @param id
     * @return
     */
    public UserDetailsDTO getById(Long id){
        return getUserDetailsDTO(repository.getOne(id));
    }

    /**
     * Returrns the user details list based on the name
     * @param name
     * @return
     */
    public List<UserDetailsDTO> getByName(String name){
        List<UserDetails> userDetailsList = repository.findUserByName(name);
        if(CollectionUtils.isEmpty(userDetailsList)){
            return null;
        }return userDetailsList.stream().map(this::getUserDetailsDTO).collect(Collectors.toList());
    }

    public UserDetailsDTO getUserDetailsDTO(UserDetails userDetails){
        return new UserDetailsDTO(
                userDetails.getId().toString(),
                userDetails.getName(),
                userDetails.getAge().toString()
        );
    }

}
