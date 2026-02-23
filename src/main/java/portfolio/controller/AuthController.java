package portfolio.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import portfolio.dto.EmailCodeDto;
import portfolio.dto.EmailIdDto;
import portfolio.dto.EmailLoginDto;
import portfolio.dto.EmailPasswordResetDto;

@Slf4j
@Controller
public class AuthController {

    @GetMapping("/login/google")
    public String loginGoogle() {
        // TODO : 구글 로그인 서비스 로직 제작

        return "redirect:/home";
    }

    @GetMapping("/login/email")
    public String loginEmailForm(Model model) {
        model.addAttribute("emailLoginDto", new EmailLoginDto());
        return "auth/login-email";
    }

    @PostMapping("/login/email")
    public String loginEmail(@ModelAttribute EmailLoginDto emailLoginDto) {
        log.info("emailLoginDto.toString() : {}", emailLoginDto.toString());
        // TODO : 이메일 로그인 서비스 로직 제작

        return "redirect:/home";
    }

    @GetMapping("/password/email")
    public String passwordEmailForm(Model model) {
        model.addAttribute("emailIdDto", new EmailIdDto());
        return "auth/password-email";
    }

    @PostMapping("/password/email")
    public String passwordEmail(@ModelAttribute EmailIdDto emailIdDto) {
        log.info("emailIdDto.toString() : {}", emailIdDto.toString());
        // TODO : 인증코드 전송 서비스 로직 제작

        return "redirect:/password/code";
    }

    @GetMapping("/password/code")
    public String passwordCodeForm(Model model) {
        model.addAttribute("emailCodeDto", new EmailCodeDto());

        return "auth/password-code";
    }

    @PostMapping("/password/code")
    public String passwordCode(@ModelAttribute EmailCodeDto emailCodeDto) {
        log.info("emailCodeDto.toString() : {}", emailCodeDto.toString());
        // TODO : 인증코드 확인 서비스 로직 제작

        return "redirect:/password/reset";
    }

    @PostMapping("/password/code/resend")
    public String passwordCodeResend(RedirectAttributes redirectAttributes) {
        // TODO : 인증코드 재전송 서비스 로직 제작

        redirectAttributes.addAttribute("resend", true);
        return "redirect:/password/code";
    }

    @GetMapping("/password/reset")
    public String passwordResetForm(Model model) {
        model.addAttribute("emailPasswordResetDto", new EmailPasswordResetDto());
        return "auth/password-reset";
    }

    @PostMapping("/password/reset")
    public String passwordReset(@ModelAttribute EmailPasswordResetDto emailPasswordResetDto, RedirectAttributes redirectAttributes) {
        log.info("emailPasswordResetDto.toString() : {}", emailPasswordResetDto.toString());
        // TODO : 비밀번호 재설정 서비스 로직 제작

        redirectAttributes.addAttribute("reset", true);
        return "redirect:/login/email";
    }
}
