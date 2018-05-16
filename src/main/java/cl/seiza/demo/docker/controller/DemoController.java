package cl.seiza.demo.docker.controller;

import cl.seiza.demo.docker.dominio.Usuario;
import cl.seiza.demo.docker.repository.GetUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo-app")
public class DemoController {
    
    @Autowired
    private GetUserRepository getUserRepository;

    @RequestMapping("/usuario/{filtro}")
    public List<Usuario> home(@PathVariable String filtro) {
        return getUserRepository.getUsuarios(filtro);
    }
    
    


}
