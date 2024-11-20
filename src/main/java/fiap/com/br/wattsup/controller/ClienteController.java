package fiap.com.br.wattsup.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fiap.com.br.wattsup.models.Cliente;
import fiap.com.br.wattsup.repository.ClienteRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteR;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteR.findAll();
    }
    @GetMapping("{id}")
    public ResponseEntity<Cliente> show(@PathVariable UUID id) {
        Optional<Cliente> cliente = getCliente(id);
        if(cliente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(cliente.get());
    }
    @PostMapping
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
        cliente.setId(UUID.randomUUID());
        cliente.setAtivo(true);
        clienteR.save(cliente);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable UUID id) {
        Optional<Cliente> cliente = getCliente(id);
        
        if (cliente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    
        Cliente clienteExistente = cliente.get();
        clienteExistente.setAtivo(false); 
        clienteR.save(clienteExistente);
    
        return ResponseEntity.ok(clienteExistente);
    }

    private Optional<Cliente> getCliente(UUID id){
        return clienteR.findById(id);
    }
}
