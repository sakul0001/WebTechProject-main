package edu.tcu.cs.superfrogproject.controller;

import edu.tcu.cs.superfrogproject.domain.MyUserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(Model model, HttpServletRequest request){
        model.addAttribute("today", Calendar.getInstance());

        // Access Currently Authenticated User
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserPrincipal principal = (MyUserPrincipal) authentication.getPrincipal();
        request.getSession(true).setAttribute("user", principal.getUser());

        if(principal.getUser().getRoles().equals("director")){
            System.out.println("Redirecting to Director!");
            model.addAttribute("user",principal.getUser());
            return "director";
        }
        else if(principal.getUser().getRoles().equals("superfrog")){
            System.out.println("Redirecting to superfrog!");
            model.addAttribute("user",principal.getUser());
            return "superfrog";
        }
        else if(principal.getUser().getRoles().equals("person")){
            System.out.println("Redirecting to Customer!");
            model.addAttribute("user",principal.getUser());
            return "person";
        }
        return "person";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

}
