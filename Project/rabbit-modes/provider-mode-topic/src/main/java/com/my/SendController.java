package com.my;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {
    @Autowired
    Sender sender;
    @GetMapping("/send")
    public String send(){

            sender.send();

        return "ok";

    }
}
