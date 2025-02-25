package com.testowy.projectUser.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("name")
public class LoginController {

    private final AutenticationService autenticationService;
    public LoginController(AutenticationService autenticationService) {
        this.autenticationService = autenticationService;
    }

    @GetMapping("/login")
    public String gotoLoginPage(){
        return "login";
    }
    @PostMapping("/login")
    public String gotoWelcomePage(@RequestParam String name,
                                  @RequestParam String password,
                                  Model model ) {

        if (autenticationService.autentication(name, password)) {
            model.addAttribute("name", name);
           // model.addAttribute("password", password);
            return "welcome";
        }
        return "login";
    }
}
