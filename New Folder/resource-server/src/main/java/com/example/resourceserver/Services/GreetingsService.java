package com.example.resourceserver.Services;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.*;
import java.util.Map;

@Service
public class GreetingsService {
    @PreAuthorize("hasAuthority('SCOPE_user.read')")
    public Map<String, String> greet()
    {
        var jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return Map.of("message","hello"+jwt.getSubject());

    }
}
