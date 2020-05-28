package lab4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping({"/logReg", "/home"})
public class FrontController {

    @RequestMapping
    public String request() {
        return "forward://index.html";
    }
}
