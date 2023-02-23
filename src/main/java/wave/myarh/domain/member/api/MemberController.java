package wave.myarh.domain.member.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/test")
    public String test() {
        return "/login";
    }

}
