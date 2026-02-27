package portfolio.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import portfolio.dto.SubjectTimeSaveDto;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @ResponseBody
    @PostMapping("/home/record")
    public SubjectTimeSaveDto record(@RequestBody SubjectTimeSaveDto subjectTimeSaveDto) {
        log.info("timeSaveDto.toString() : {}", subjectTimeSaveDto.toString());
        // TODO : 공부 시간 기록 서비스 로직 제작

        return subjectTimeSaveDto;
    }
}
