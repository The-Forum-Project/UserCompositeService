package com.example.usercompositeservice.service;

import com.example.usercompositeservice.dto.FileUrlResponse;
import com.example.usercompositeservice.dto.UpdateRequest;
import com.example.usercompositeservice.service.remote.FileService;
import com.example.usercompositeservice.service.remote.UserRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService {
    private UserRemoteService userRemoteService;
    private FileService fileService;

    @Autowired
    public void setUserRemoteService(UserRemoteService userRemoteService) {
        this.userRemoteService = userRemoteService;
    }

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    public void modifyUser(Long userId, String firstName, String lasName, String email, String password, MultipartFile profileImage) {
        String imageUrl = null;
        if(profileImage != null){
            MultipartFile[] filesToUpload = new MultipartFile[1];
            filesToUpload[0] = profileImage;
            ResponseEntity<FileUrlResponse> response = fileService.uploadFiles(filesToUpload);
            imageUrl = response.getBody().getUrls().get(0);
        }

        UpdateRequest request = UpdateRequest.builder()
                .firstName(firstName)
                .lastName(lasName)
                .email(email)
                .password(password)
                .profileImageURL(imageUrl)
                .build();

        userRemoteService.updateUser(userId, request);
    }
}