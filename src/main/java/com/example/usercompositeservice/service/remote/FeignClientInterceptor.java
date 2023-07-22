package com.example.usercompositeservice.service.remote;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class FeignClientInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        // Set the token value in the request header
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXBlckBlbWFpbC5jb20iLCJwZXJtaXNzaW9ucyI6W3siYXV0aG9yaXR5Ijoic3VwZXIifSx7ImF1dGhvcml0eSI6ImFkbWluIn0seyJhdXRob3JpdHkiOiJub3JtYWwifSx7ImF1dGhvcml0eSI6InVudmVyaWZpZWQifV0sImlkIjoxfQ.C8JuQwGBBN9FiJfI-Xan5BB1B3OBL5G1QEAM0RGPv_k";
        template.header("Authorization", "Bearer " + token);
    }
}

