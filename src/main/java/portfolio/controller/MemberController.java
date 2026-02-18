package portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/login/email")
    public String loginEmail() {
        return "start/login-email";
    }

    @GetMapping("/join/email")
    public String joinEmail() {
        return "start/join-email";
    }
}
