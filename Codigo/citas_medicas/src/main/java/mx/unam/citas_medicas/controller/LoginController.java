package mx.unam.citas_medicas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 *
 * @author Ariadna
 */
@Controller
@RequestMapping("/LoginController")
public class LoginController {
    @RequestMapping(method = RequestMethod.POST)
    public String printHello(ModelMap model) {
        System.out.println("aaaaa");
        return "X";
    }
}
