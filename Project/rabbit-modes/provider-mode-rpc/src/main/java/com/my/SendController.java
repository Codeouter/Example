package com.my;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {
    @Autowired
    Sender sender;
    @PostMapping("/get/{id}")
    public String send(@PathVariable(value = "id") int id){

        sender.getPow(id);
        return "ok";

    }
}
