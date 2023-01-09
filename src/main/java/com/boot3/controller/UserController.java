package com.boot3.controller;

import com.boot3.data.dto.request.UserRecordReqDTO;
import com.boot3.data.dto.request.UserReqDTO;
import com.boot3.data.dto.request.UserSaveReqDTO;
import com.boot3.data.dto.response.UserDTO;
import com.boot3.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name="[JPA] User Controller", description="JPA로 Controller 구현하기")
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    @Operation(description = "사용자 리스트 조회하기")
    public List<UserDTO> getUserList(){
        return userService.getUserList();
    }

    @GetMapping("/user/{userId}")
    @Operation(description = "특정 사용자 조회하기")
    public UserDTO getUserInfo(@PathVariable String userId){
        //UserReqDTO dto = new UserReqDTO();
        UserRecordReqDTO dto = new UserRecordReqDTO(userId);

        return userService.getUserInfo(dto);
    }

    @PostMapping("/user")
    @Operation(description = "사용자 정보 저장하기")
    public String saveUserInfo(@RequestBody UserSaveReqDTO dto){
        userService.saveUserInfo(dto);

        return "save-userinfo";
    }
}
