 
package com.tienda.controller;


import com.tienda.domain.Cliente;
import com.tienda.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class indexController {
    
    @Autowired
    private ClienteService clienteService;
         
    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora se usa arquitectura MVC");

       // Cliente cliente= new Cliente("Andrey", "Sosa", "andreyso2000@gmail.com","87946544");
        //Cliente cliente2= new Cliente("Juan", "Ortega", "OR255@gmail.com","8732322");
        //var clientes =Arrays.asList(cliente,cliente2);
        
        var clientes=clienteService.getClientes();
        model.addAttribute("clientes",clientes);
        return "index";
    }
    
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente){
        return "modificarCliente";
    }
    
    
    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/";
    }
    
    @GetMapping("modificarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente",cliente);
        return "modificarCliente";
    }
     @GetMapping("eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente, Model model){
       clienteService.delete(cliente);
        model.addAttribute("cliente",cliente);
        return "redirect:/";
    }
    
}
