package portfolio.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import portfolio.domain.MemberType;
import portfolio.dto.*;

@Slf4j
@Controller
public class MemberController {

    @GetMapping("/userinfo")
    public String userinfoForm(Model model) {
        model.addAttribute("userInfoDto", new UserInfoDto());
        model.addAttribute("memberTypes", MemberType.values());

        return "member/userinfo";
    }

    @PostMapping("/userinfo")
    public String userinfo(@ModelAttribute("userInfoDto") UserInfoDto userInfoDto) {
        log.info("userInfoDto.toString() : {}", userInfoDto.toString());
        // TODO : 사용자 정보 저장 기능 구현

        return "redirect:/home";
    }
}
