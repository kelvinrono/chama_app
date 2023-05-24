package com.chama.app.controllers;

import com.chama.app.dto.UserDTO;
import com.chama.app.responses.MessageResponse;
import com.chama.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("add-savings/{id}")
    public ResponseEntity<MessageResponse> addSavings(@PathVariable int id, @RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.addSavings(id, userDTO)) ;
    }

}
