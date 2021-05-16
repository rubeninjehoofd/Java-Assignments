package nl.schild.ruben.RubenfirstAPI.controller;

import nl.schild.ruben.RubenfirstAPI.model.DTO.LoginDTO;
import nl.schild.ruben.RubenfirstAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController
{
    @Autowired
    UserService userService;


    //hier moeten nog exceptions bij
    @PostMapping("/login")
    public String login(@RequestBody LoginDTO login)
    {
        return userService.login(login.getUsername(), login.getPassword());
    }
}
