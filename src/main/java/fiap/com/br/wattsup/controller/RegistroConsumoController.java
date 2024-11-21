package fiap.com.br.wattsup.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fiap.com.br.wattsup.models.RegistroConsumo;
import fiap.com.br.wattsup.repository.RegistroConsumoRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/registroconsumo")
public class RegistroConsumoController {
    
    @Autowired
    private RegistroConsumoRepository rcr;
    Logger log = LoggerFactory.getLogger(ContratoController.class);

    @GetMapping
    public List<RegistroConsumo> getAllRegistroConsumos() {
        List<RegistroConsumo> atualTodoRe = rcr.findAll();
        List<RegistroConsumo> futuraTodore = new ArrayList<>();
        for (RegistroConsumo registroConsumo : atualTodoRe) {
            registroConsumo.setConsumo(registroConsumo.getConsumo() + 5);
            registroConsumo.setMedicao(new Date());
            rcr.save(registroConsumo);
            futuraTodore.add(registroConsumo);
        }
        return futuraTodore;
    }
    @GetMapping("{id}")
    public ResponseEntity<RegistroConsumo> showRegistroConsumo(@PathVariable UUID id) {
        Optional<RegistroConsumo> registroConsumo = getRegistroConsumo(id);   
        if(registroConsumo.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        RegistroConsumo rc =registroConsumo.get();
        rc.setMedicao(new Date());
        rc.setConsumo(rc.getConsumo() + 5); 
        rcr.save(rc);
        
        return ResponseEntity.ok(rc);        
    }
    @PostMapping
    public ResponseEntity<RegistroConsumo> addRegistro(@RequestBody RegistroConsumo rc) {

        rc.setCreated(new Date());
        rc.setId(UUID.randomUUID());
        log.info("registrando: " +rc  );
        rcr.save(rc);
        return ResponseEntity.status(HttpStatus.CREATED).body(rc);
    }
    

    private Optional<RegistroConsumo> getRegistroConsumo(UUID id){
        return rcr.findById(id);
    }    
}
