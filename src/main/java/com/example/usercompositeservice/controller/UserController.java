package com.example.usercompositeservice.controller;

import com.example.usercompositeservice.dto.GeneralResponse;
import com.example.usercompositeservice.exception.InvalidAuthorityException;
import com.example.usercompositeservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<GeneralResponse> modifyUser(@PathVariable Long userId,
                                                      @RequestParam(value = "firstName", required = false) String firstName,
                                                      @RequestParam(value = "lastName", required = false) String lastName,
                                                      @RequestParam(value = "email", required = false) String email,
                                                      @RequestParam(value = "password", required = false) String password,
                                                      @RequestParam(value = "profileImage", required = false) MultipartFile profileImage) throws InvalidAuthorityException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) authentication.getAuthorities();

        if (authorities.stream().noneMatch(authority -> authority.getAuthority().equals("admin"))) {
            if (!userId.equals(authentication.getPrincipal())) {
                throw new InvalidAuthorityException();
            }
        }

        userService.modifyUser(userId, firstName, lastName, email, password, profileImage);

        return ResponseEntity.ok(GeneralResponse.builder().statusCode("200").message("User modified").build());
    }
}
