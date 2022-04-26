package com.simplilearn.Phase4.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @RequestMapping(value = "/greetMe", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public Greet greet() {
        Greet greet = new Greet();
        greet.setName("Dhruvik");
        greet.setMessage("Hello world!");
        return greet;
    }


}
