package by.tms.springbootcalculcator.controller;


import by.tms.springbootcalculcator.entity.User;
import by.tms.springbootcalculcator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

    @PostMapping("/reg")
    public String reg(User user) {
        userService.save(user);
        return "redirect:/";

    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @PostMapping("/login")
    public String login(User user, Model model) {
        Optional<User> byUsername = userService.findByUsername(user.getUsername());
        if (byUsername.isPresent()) {
            User tempUser = byUsername.get();
            if (tempUser.getPassword().equals(user.getPassword())) {
                model.addAttribute("message", "Welcome!");
            } else {
                model.addAttribute("message", "Wrong password!");
            }
        } else {
            model.addAttribute("message", "User not found");
        }
        return  "login";
    }
}

