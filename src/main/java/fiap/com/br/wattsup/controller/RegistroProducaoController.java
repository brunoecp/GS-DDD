package fiap.com.br.wattsup.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fiap.com.br.wattsup.models.RegistroProducao;
import fiap.com.br.wattsup.repository.RegistroProducaoRepository;

@RestController
@RequestMapping("/registroproducao")
public class RegistroProducaoController {

    @Autowired
    private RegistroProducaoRepository rpr;

    @GetMapping
    public List<RegistroProducao> getAllRegistroProducaos() {
        List<RegistroProducao> atualTodoRe = rpr.findAll();
        List<RegistroProducao> futuraTodore = new ArrayList<>();
        for (RegistroProducao registroProducao : atualTodoRe) {
            registroProducao.setProducao(registroProducao.getProducao() + 5);
            registroProducao.setMedicao(new Date());
            rpr.save(registroProducao);
            futuraTodore.add(registroProducao);
        }
        return futuraTodore;
    }
    @GetMapping("{id}")
    public ResponseEntity<RegistroProducao> showRegistroProducao(@PathVariable UUID id) {
        Optional<RegistroProducao> registroProducao = getRegistroProducao(id);   
        if(registroProducao.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        RegistroProducao rc =registroProducao.get();
        rc.setMedicao(new Date());
        rc.setProducao(rc.getProducao() + 5); 
        rpr.save(rc);
        
        return ResponseEntity.ok(rc);        
    }
    @PostMapping
    public ResponseEntity<RegistroProducao> addRegistro(@RequestBody RegistroProducao rc) {

        rc.setCreated(new Date());
        rc.setId(UUID.randomUUID());
        rpr.save(rc);
        return ResponseEntity.status(HttpStatus.CREATED).body(rc);
    }
    

    private Optional<RegistroProducao> getRegistroProducao(UUID id){
        return rpr.findById(id);
    }    
}
