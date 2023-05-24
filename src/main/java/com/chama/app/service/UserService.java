package com.chama.app.service;

import com.chama.app.dto.UserDTO;
import com.chama.app.responses.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    MessageResponse addSavings(int id, UserDTO userDTO);
}
