package in.spring.wmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class Assignment {
    @GetMapping("/signup")
    public String openSignup() {
        return "signup";
    }
    @GetMapping("/login")
    public String openLogin() {
        return "login";
    }
    @ModelAttribute("user")
    public Userdto user() {
        return new Userdto();
    }
    @PostMapping("/signupdata")
    public String postSignupData(@ModelAttribute("user") Userdto user) {
        return "redirect:/login";
    }
    @PostMapping("/logindata")
    public String postLoginData(@ModelAttribute Logindto logs,@ModelAttribute("user") Userdto users,Model model) {
        if (users.getEmail().equals(logs.getEmail()) &&users.getPassword().equals(logs.getPassword())) {
            model.addAttribute("user", users);
            return "profile";
        } else {
        	model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }
}
