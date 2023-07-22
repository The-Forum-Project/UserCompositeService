package com.example.usercompositeservice.service.remote;

import com.example.usercompositeservice.dto.MessageResponse;
import com.example.usercompositeservice.dto.UpdateRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


@Service
@FeignClient("user-service")
public interface UserRemoteService {

    @PutMapping(value = "user-service/users/{id}")
    void updateUser(@PathVariable Long id, @RequestBody UpdateRequest request);

}