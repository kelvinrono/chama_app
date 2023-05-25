package com.chama.app.controllers;

import com.chama.app.dto.GoalDTO;
import com.chama.app.dto.UserDTO;
import com.chama.app.models.User;
import com.chama.app.responses.MessageResponse;
import com.chama.app.service.GoalService;
import com.chama.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private GoalService goalService;

    @PostMapping("add-savings/{id}")
    public ResponseEntity<MessageResponse> addSavings(@PathVariable int id, @RequestBody UserDTO userDTO){
        return ResponseEntity.ok(goalService.addSavings(id, userDTO)) ;
    }

    @GetMapping("all-users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("create-goal")
    public ResponseEntity<MessageResponse> createGoal(@RequestBody GoalDTO goalDTO){
        return ResponseEntity.ok(goalService.setGoal(goalDTO));
    }

}
