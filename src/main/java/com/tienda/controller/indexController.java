
package com.tienda.controller;

import com.tienda.dao.ClienteDao;
import com.tienda.domain.Cliente;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class indexController {
    
    @Autowired
    private ClienteDao clienteDao;
         
    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora se usa arquitectura MVC");

       // Cliente cliente= new Cliente("Andrey", "Sosa", "andreyso2000@gmail.com","87946544");
        //Cliente cliente2= new Cliente("Juan", "Ortega", "OR255@gmail.com","8732322");
        //var clientes =Arrays.asList(cliente,cliente2);
        
        var clientes=clienteDao.findAll();
        model.addAttribute("clientes",clientes);
        return "index";
    }
    
}
