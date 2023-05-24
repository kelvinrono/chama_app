package com.chama.app.service;

import com.chama.app.dto.UserDTO;
import com.chama.app.models.User;
import com.chama.app.repository.UserRepository;
import com.chama.app.responses.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private  UserRepository userRepository;

    @Override
    public MessageResponse addSavings(int id, UserDTO userDTO) {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            return new MessageResponse("User does not exist!", false);
        }
        int savings = userDTO.getSavings();
        int existingAmount = user.get().getSavings();
        int totalAmount = savings+existingAmount;
        user.get().setSavings(totalAmount);
        userRepository.save(user.get());
        return new MessageResponse("You have successfully saved "+savings, true);
    }

}
