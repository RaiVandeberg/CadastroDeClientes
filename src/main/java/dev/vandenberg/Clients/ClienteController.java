package dev.vandenberg.Clients;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {


    // adicionar cliente
    @PostMapping("/criar")
    public String criarCliente(){
        return  "Cliente criado";
    }

    @GetMapping("/all")
    public String mostrarCliente(){
        return  "Mostrar cliente";
    }

   @GetMapping("/id")
   public String mostrarClienteId(){
       return  "Mostrar cliente por id";
   }

   @PutMapping("/id")
    public  String atualizarClientePorId(){
        return  "Cliente atualizado";
   }

   @DeleteMapping("/id")
    public String deletarClientePorId(){
        return  "Cliente deletado";
   }

}
