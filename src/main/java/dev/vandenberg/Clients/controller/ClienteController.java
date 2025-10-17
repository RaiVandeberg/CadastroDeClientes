package dev.vandenberg.Clients.controller;

import dev.vandenberg.Clients.ClienteDTO;
import dev.vandenberg.Clients.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private  final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {

        this.clienteService = clienteService;

    }

    // adicionar cliente
    @PostMapping("/criar")
    public ResponseEntity<String> criarCliente(@RequestBody ClienteDTO cliente){
        ClienteDTO clienteDTO = clienteService.criarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body( "criado com sucesso" + clienteDTO.toString());
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClienteDTO>> listarClientes(){
        List<ClienteDTO> clienteDTO = clienteService.listarClientes();
        return ResponseEntity.ok(clienteDTO);
    }

   @GetMapping("/{id}")
   public ResponseEntity<?> buscarClientePorId(@PathVariable Long id){
        ClienteDTO clienteDTO = clienteService.buscarClientePorId(id);
        if(clienteDTO != null){
            return ResponseEntity.ok(clienteDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" dependete com" + id + " Nao encontrado");
        }
   }

   @PutMapping("/{id}")
    public  ResponseEntity<?> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO cliente){
        ClienteDTO clienteDTO = clienteService.atualizarClientePorId(id,cliente );
        if(clienteDTO != null){
            return ResponseEntity.ok(clienteDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" dependete com" + id + " Nao encontrado");
        }
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirCliente(@PathVariable Long id){
        if (clienteService.buscarClientePorId(id) != null) {
            clienteService.deletarClientePorId(id);
            return ResponseEntity.ok(" Cliente removido com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" dependete com" + id + "Nao encontrado");
        }
   }

}
