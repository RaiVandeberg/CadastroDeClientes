package dev.vandenberg.Clients.services;

import dev.vandenberg.Clients.ClienteDTO;
import dev.vandenberg.Clients.ClienteMapper;
import dev.vandenberg.Clients.ClienteModel;
import dev.vandenberg.Clients.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public List<ClienteDTO> listarClientes(){
        List<ClienteModel> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(clienteMapper::map)
                .collect(Collectors.toList());
    }

    public ClienteDTO buscarClientePorId(Long id){
        Optional<ClienteModel> clienteId = clienteRepository.findById(id);
        return clienteId.map(clienteMapper::map).orElse(null);
    }

    public ClienteDTO criarCliente(ClienteDTO clienteDTO){
        ClienteModel cliente = clienteMapper.map(clienteDTO);
        if (cliente.getDependentes() != null) {
            final ClienteModel temp = cliente;
            cliente.getDependentes().forEach(d -> d.setClientes(temp));
        }
        cliente = clienteRepository.save(cliente);
        return clienteMapper.map(cliente);
    }

    public void deletarClientePorId(Long id){
        clienteRepository.deleteById(id);
    }

    public ClienteDTO atualizarClientePorId(Long id, ClienteDTO clienteDTO){
        Optional<ClienteModel> clienteId = clienteRepository.findById(id);
        if(clienteId.isPresent()){
            ClienteModel clienteAtualizado = clienteMapper.map(clienteDTO);
            clienteAtualizado.setId(id);
            ClienteModel clienteSalvo = clienteRepository.save(clienteAtualizado);
            return clienteMapper.map(clienteSalvo);
        }
        return null;
    }
}
