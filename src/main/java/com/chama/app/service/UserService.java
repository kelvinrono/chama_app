package com.chama.app.service;

import com.chama.app.dto.GoalDTO;
import com.chama.app.dto.UserDTO;
import com.chama.app.models.User;
import com.chama.app.responses.MessageResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();


}
