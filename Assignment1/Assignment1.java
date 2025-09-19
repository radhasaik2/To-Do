package in.spring.wmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class Assignment {
    
    @GetMapping("/")
    public String home() {
        return "index"; 
    }
    
    @GetMapping("/signup")
    public String openSignup() {
        return "signup";
    }
    
    @GetMapping("/login")
    public String openLogin(Model model) {
        model.addAttribute("logindto", new Logindto());
        return "login";
    }
    
    @ModelAttribute("user")
    public Userdto user() {
        return new Userdto();
    }
    
    @PostMapping("/signupdata")
    public String postSignupData(@ModelAttribute("user") Userdto user, Model model) {
        try {
            if (user.getName() == null || user.getName().trim().isEmpty() ||
                user.getEmail() == null || user.getEmail().trim().isEmpty() ||
                user.getPassword() == null || user.getPassword().trim().isEmpty()) {
                
                model.addAttribute("error", "All fields are required");
                return "signup";
            }
            
            int generatedId = Assignment1dao.insertUsers(user);
            user.setUserid(String.valueOf(generatedId));
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "signup";
        }
    }
    
    @PostMapping("/logindata")
    public String postLoginData(@ModelAttribute Logindto logs, @ModelAttribute("user") Userdto users, Model model) {
        try {
            if (logs.getEmail() == null || logs.getEmail().trim().isEmpty() ||
                logs.getPassword() == null || logs.getPassword().trim().isEmpty()) {
                model.addAttribute("error", "Email and password are required");
                return "login";
            }
            
            Userdto Db=Assignment1dao.getUserByEmail(logs.getEmail());
            
            if (Db!= null && Passwordinfo.checkPassword(logs.getPassword(), Db.getPassword())) {
                users.setUserid(Db.getUserid());
                users.setName(Db.getName());
                users.setEmail(Db.getEmail());
                users.setPassword(""); 
                model.addAttribute("user", users);
                model.addAttribute("message", "User login successful");
                return "profile";
            } else {
                model.addAttribute("error", "Invalid email or password");
                return "login";
            }
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred during login");
            return "login";
        }
    }
    @GetMapping("/profile")
    public String showProfile(@ModelAttribute("user") Userdto user, Model model) {
        if (user.getUserid() == null || user.getUserid().isEmpty()) {
            return "redirect:/login";
        }
        return "profile";
    }
}
