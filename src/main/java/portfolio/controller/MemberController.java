package portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/login")
    public String login() {
        return "start/login";
    }

    @GetMapping("/join")
    public String join() {
        return "start/join";
    }
}
