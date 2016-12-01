package de.davidcrome.boot.examples;

import org.osiam.resources.scim.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class WebController {

    @RequestMapping("/")
    public String index(Model model, Principal principal) {
        setUsername(model, principal);
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/start")
    public String start(Model model, Principal principal) {
        setUsername(model, principal);
        return "start";
    }

    private void setUsername(Model model, Principal principal) {
        if (principal != null) {
            User osiamUser = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
            model.addAttribute("name", osiamUser.getUserName());
        } else {
            model.addAttribute("name", "Guest");
        }
    }
}