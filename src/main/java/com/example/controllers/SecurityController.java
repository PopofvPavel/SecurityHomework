package com.example.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/secured")
public class SecurityController {
    @GetMapping("/page")
    @PreAuthorize("hasAnyRole('ADMIN', 'MODERATOR')")
    public String showSecuredPage(Authentication authentication) {
        System.out.println(authentication.getAuthorities());
        return "secured-page";
    }

    @GetMapping("/moder")
    @PreAuthorize("hasRole('MODERATOR')")
    public String showModerPage(){

        return "moder-page";
    }
}
