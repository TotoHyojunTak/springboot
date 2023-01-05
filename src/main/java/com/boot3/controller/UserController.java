package com.boot3.controller;

import com.boot3.data.dto.request.UserReqDTO;
import com.boot3.data.dto.request.UserSaveReqDTO;
import com.boot3.data.dto.response.UserDTO;
import com.boot3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public List<UserDTO> getUserList(){
        return userService.getUserList();
    }

    @GetMapping("/user/{userId}")
    public UserDTO getUserInfo(@PathVariable String userId){
        UserReqDTO dto = new UserReqDTO();
        dto.setUserId(userId);

        return userService.getUserInfo(dto);
    }

    @PostMapping("/user")
    public String saveUserInfo(@RequestBody UserSaveReqDTO dto){

        userService.saveUserInfo(dto);

        return "save-userinfo";
    }
}
