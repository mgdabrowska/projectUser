package com.testowy.projectUser.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("name")
public class WelcomeController {



    @GetMapping("/")
    public String gotoWelcomePage(Model model){
        model.addAttribute("name", "gosia");

        return "welcome";
    }

}
