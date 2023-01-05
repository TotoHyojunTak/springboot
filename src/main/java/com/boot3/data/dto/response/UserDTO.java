package com.boot3.data.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    private Date createdDate;
}