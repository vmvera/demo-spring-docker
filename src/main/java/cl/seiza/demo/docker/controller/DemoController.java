package cl.seiza.demo.docker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo-app")
public class DemoController {

    @RequestMapping("/hello")
    public String home() {
        return "Prueba docker";
    }
    
    


}
