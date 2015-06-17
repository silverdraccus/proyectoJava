package mx.unam.citas_medicas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HelpsController {
    @RequestMapping(value ="/headers")
    public String getHeaders(Model model) {
        return "/helps/headers";
    }
    
    @RequestMapping(value ="/footer")
    public String getFooter(Model model) {
        return "/helps/footer";
    }
}
