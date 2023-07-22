package com.example.usercompositeservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String profileImageURL;

}
