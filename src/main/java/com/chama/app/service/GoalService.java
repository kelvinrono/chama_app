package com.chama.app.service;

import com.chama.app.dto.GoalDTO;
import com.chama.app.dto.UserDTO;
import com.chama.app.responses.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public interface GoalService {
    MessageResponse setGoal(GoalDTO goalDTO);
    MessageResponse addSavings(int id, UserDTO userDTO);
}
