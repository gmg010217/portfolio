package portfolio.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import portfolio.domain.MemberType;
import portfolio.dto.EmailCodeDto;
import portfolio.dto.EmailJoinDto;
import portfolio.dto.EmailLoginDto;
import portfolio.dto.UserInfoDto;

@Slf4j
@Controller
public class MemberController {

    @GetMapping("/login/google")
    public String loginGoogle() {
        // TODO : 구글 로그인 서비스 로직 제작

        return "redirect:/home";
    }

    @GetMapping("/login/email")
    public String loginEmailForm(Model model) {
        model.addAttribute("emailLoginDto", new EmailLoginDto());
        return "start/login-email";
    }

    @PostMapping("/login/email")
    public String loginEmail(@ModelAttribute("emailLoginDto") EmailLoginDto emailLoginDto) {
        log.info("emailLoginDto.toString() : {}", emailLoginDto.toString());
        // TODO : 이메일 로그인 서비스 로직 제작

        return "redirect:/home";
    }

    @GetMapping("/join/google")
    public String joinGoogle() {
        // TODO : 구글 회원가입 서비스 로직 제작

        return "redirect:/userinfo";
    }

    @GetMapping("/join/email")
    public String joinEmailForm(Model model) {
        model.addAttribute("emailJoinDto", new EmailJoinDto());
        return "start/join-email1";
    }

    @PostMapping("/join/email")
    public String joinEmail(@ModelAttribute("emailJoinDto") EmailJoinDto emailJoinDto) {
        log.info("emailJoinDto.toString() : {}", emailJoinDto.toString());
        // TODO : 이메일 회원가입 서비스 로직 제작

        // TODO : 세션에 이메일 아이디 저장

        return "redirect:/join/email/code";
    }

    @GetMapping("/join/email/code")
    public String joinEmailCodeForm(Model model) {
        log.info("재전송 확인용 로그");
        // TODO : 인증코드 전송 서비스 로직 제작 (세션에 있는 이메일 아이디 이용)
        model.addAttribute("emailCodeDto", new EmailCodeDto());

        return "start/join-email2";
    }

    @PostMapping("/join/email/code")
    public String joinEmailCode(@ModelAttribute("emailCodeDto") EmailCodeDto emailCodeDto) {
        log.info("emailCodeDto.toString() : {}", emailCodeDto.toString());
        // TODO : 인증코드 확인 서비스 로직 제작 (세션에 있는 이메일 아이디 이용)

        return "redirect:/userinfo";
    }

    @GetMapping("/userinfo")
    public String userinfoForm(Model model) {
        model.addAttribute("userInfoDto", new UserInfoDto());
        model.addAttribute("memberTypes", MemberType.values());

        return "start/userinfo";
    }

    @PostMapping("/userinfo")
    public String userinfo(@ModelAttribute("userIntoDto") UserInfoDto userInfoDto) {
        log.info("userInfoDto.toString() : {}", userInfoDto.toString());
        // TODO : 사용자 정보 저장 기능 구현

        return "redirect:/home";
    }
}
