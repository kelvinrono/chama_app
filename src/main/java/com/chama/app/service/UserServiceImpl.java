package com.chama.app.service;

import com.chama.app.dto.GoalDTO;
import com.chama.app.dto.UserDTO;
import com.chama.app.models.Goal;
import com.chama.app.models.User;
import com.chama.app.repository.GoalRepository;
import com.chama.app.repository.UserRepository;
import com.chama.app.responses.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private GoalRepository goalRepository;


    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }





}
