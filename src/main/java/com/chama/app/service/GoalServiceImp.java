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
import java.util.Optional;

@Service
public class GoalServiceImp implements GoalService {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public MessageResponse setGoal(GoalDTO goalDTO) {
        Optional<Goal> goal = goalRepository.findByName(goalDTO.getName());
        if(goal.isPresent()){
            return new MessageResponse("Goal with the this name already exist", false);
        }
        Goal newGoal = new Goal(
                goalDTO.getName(),
                goalDTO.getFrequency(),
                goalDTO.getTargetAmount()
        );
        goalRepository.save(newGoal);
        return new MessageResponse("Goal has been set successfully: "+newGoal.getName(), true);
    }
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
