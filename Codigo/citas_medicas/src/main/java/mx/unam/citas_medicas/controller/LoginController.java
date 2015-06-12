package mx.unam.citas_medicas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



/**
 *
 * @author Ariadna
 */
@Controller

public class LoginController {

     @RequestMapping(value = {"/*", "/index"})
    public String getIndex(Model model) {
        return "index";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String printHello(ModelMap model) {
        System.out.println("aaaaa");
        return "X";
    }
}
