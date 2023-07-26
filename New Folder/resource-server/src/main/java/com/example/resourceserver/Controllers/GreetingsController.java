package com.example.resourceserver.Controllers;

import com.example.resourceserver.Services.GreetingsService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@ResponseBody
public class GreetingsController {
    private final GreetingsService greetingsService;

    public GreetingsController(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    @GetMapping(path = "/hello")
    Map<String,String> hello(@AuthenticationPrincipal Jwt jwt)
    {
        return this.greetingsService.greet();
    }
}
