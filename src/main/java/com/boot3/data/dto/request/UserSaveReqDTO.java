package com.boot3.data.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserSaveReqDTO {

    private String userId;


    @NotNull()
    @Size(min = 2)
    @Email
    private String email;

    @NotNull()
    @Size(min = 2)
    private String name;

    @NotNull()
    @Size(min = 8)
    private String pwd;
}