package portfolio.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import portfolio.dto.EmailCodeDto;
import portfolio.dto.EmailJoinDto;

@Slf4j
@Controller
@RequestMapping("/join")
public class JoinController {

    @GetMapping("/google")
    public String joinGoogle() {
        // TODO : 구글 회원가입 서비스 로직 제작

        return "redirect:/userinfo";
    }

    @GetMapping("/email")
    public String joinEmailForm(Model model) {
        model.addAttribute("emailJoinDto", new EmailJoinDto());
        return "join/join-email-info";
    }

    @PostMapping("/email")
    public String joinEmail(@ModelAttribute EmailJoinDto emailJoinDto) {
        log.info("emailJoinDto.toString() : {}", emailJoinDto.toString());
        // TODO : 이메일 회원가입 서비스 로직 제작

        // TODO : 세션에 이메일 아이디 저장

        // TODO : 인증코드 전송 서비스 로직 제작

        return "redirect:/join/email/code";
    }

    @GetMapping("/email/code")
    public String joinEmailCodeForm(Model model) {
        model.addAttribute("emailCodeDto", new EmailCodeDto());

        return "join/join-email-code";
    }

    @PostMapping("/email/code")
    public String joinEmailCode(@ModelAttribute EmailCodeDto emailCodeDto) {
        log.info("emailCodeDto.toString() : {}", emailCodeDto.toString());
        // TODO : 인증코드 확인 서비스 로직 제작 (세션에 있는 이메일 아이디 이용)

        return "redirect:/userinfo";
    }

    @PostMapping("/email/resend")
    public String joinEmailCodeResend(RedirectAttributes redirectAttributes) {
        // TODO : 인증코드 재전송 서비스 로직 제작

        redirectAttributes.addAttribute("resend", true);
        return "redirect:/join/email/code";
    }
}
