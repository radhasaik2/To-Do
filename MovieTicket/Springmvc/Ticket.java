package in.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ticket {
    @GetMapping("/sample")
    public String openTest() {
        return "sample";
    }
}
