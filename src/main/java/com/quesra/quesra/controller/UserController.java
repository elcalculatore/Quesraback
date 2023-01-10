package com.quesra.quesra.controller;

import com.quesra.quesra.domain.User;
import com.quesra.quesra.dto.ConnectDto;
import com.quesra.quesra.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public User saveUser(@RequestBody User user)
    {
      return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return  userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") long id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") long id , @RequestBody User user){
        return userService.updateUser(id, user);
    }
    @PostMapping("connection")
    public User connect(@RequestBody ConnectDto user){
        return userService.connectUser(user);
    }

    @DeleteMapping("/{id}")
    public List<User> deleteuser(@PathVariable("id") long id) {
        userService.delete(id);
        return userService.getAllUsers();
    }

    /* @PutMapping("join-space")
    public ResponseEntity<User> joinSpace(@RequestParam Long spaceId, @RequestParam Long userId) throws Exception {
        if (spaceId == null) {
            throw new Exception("Space Id must be not null");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userService.joinUser(spaceId,userId));
    }*/
}

