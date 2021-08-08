package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String helloFunction(){
        return "Hello World ";
    }

    @GetMapping ("/capitalize/{small}")
    public String capitalizeWorld(Model model , @PathVariable String small){
       model.addAttribute("word",small.toUpperCase());
        return "capitals.html";
    }

    @GetMapping("/")
    public String  HomePage(){
        return "Home.html";
    }

}
