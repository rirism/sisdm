package apap.sisdm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class BaseController {
    @GetMapping("/")
    private String Beranda() {
        return "beranda";
    }
}

