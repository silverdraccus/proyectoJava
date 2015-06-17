package mx.unam.citas_medicas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HelpsController {
    @RequestMapping(value ="/headers")
    public String getIndex(Model model) {
        return "/helps/headers";
    }
}
