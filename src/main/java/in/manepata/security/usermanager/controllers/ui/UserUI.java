package in.manepata.security.usermanager.controllers.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserUI {
	
	 @GetMapping("/users")
	    public String index() {
	        return "users";
	    }
	 
	 @GetMapping("/students")
	    public String students() {
	        return "students";
	    }

}
