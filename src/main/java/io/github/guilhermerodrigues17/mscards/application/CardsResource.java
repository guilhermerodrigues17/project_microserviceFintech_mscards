package io.github.guilhermerodrigues17.mscards.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CardsResource {

    @GetMapping
    public String status() {
        return "ok";
    }
}
