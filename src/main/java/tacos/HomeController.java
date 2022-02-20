package tacos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {

        // this String will be interpreted as the logical name of a view
        // Thymeleaf is in the classpath, so it knows this name
        // template name = /templates/[logical view nane].html
        return "home";
    }
}
