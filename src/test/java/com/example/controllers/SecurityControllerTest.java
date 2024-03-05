package com.example.controllers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class SecurityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(roles = "ADMIN")
    void showSecuredPage_AdminRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/secured/page"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("secured-page"));
    }

    @Test
    @WithMockUser(roles = "USER")
    void showSecuredPage_UserRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/secured/page"))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "MODERATOR")
    void showSecuredPage_ModeratorRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/secured/page"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("secured-page"));
    }

    @Test
    @WithMockUser(roles = "MODERATOR")
    void showModerPage_ModeratorRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/secured/moder"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("moder-page"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void showModerPage_AdminRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/secured/moder"))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }
}

