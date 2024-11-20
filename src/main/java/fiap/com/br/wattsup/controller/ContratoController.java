package fiap.com.br.wattsup.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fiap.com.br.wattsup.models.Contrato;
import fiap.com.br.wattsup.repository.ContratoRepository;


@RestController
@RequestMapping("/contrato")
public class ContratoController {

    @Autowired
    private ContratoRepository contratoRepository;
    Logger log = LoggerFactory.getLogger(ContratoController.class);

    // Método para obter todos os contratos
    @GetMapping
    public List<Contrato> getAllContratos() {
        return contratoRepository.findAll();
    }
    @GetMapping("{id}")
    public ResponseEntity<Contrato> show(@PathVariable UUID id) {
        return ResponseEntity.ok(getContrato(id).get());
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Contrato contrato) {
        contrato.setAtivo(true);
        contrato.setId(UUID.randomUUID());
        contrato.setDtInicio(new Date());
        if(contrato.getTimeframe() % 90==0 && contrato.getTimeframe()<=810 ){
            contratoRepository.save(contrato);
        
            return ResponseEntity.status(HttpStatus.CREATED).body(contrato);    
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Verifique se a vingencia é um numero divisivel por 90 e se é abaixo de 810");
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Contrato> exclude(@PathVariable UUID id){
        Optional<Contrato> c = getContrato(id);
        if(c.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } 
        Contrato con = c.get();
        con.setAtivo(false);
        contratoRepository.save(con);
        return ResponseEntity.ok(con);
    }

private Optional<Contrato> getContrato(UUID id) {
    Optional<Contrato> con = contratoRepository.findById(id);
    
    if (con.isEmpty()) {
        return Optional.empty(); 
    }
    
    Contrato contrato = con.get();
    
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(contrato.getDtInicio());
    calendar.add(Calendar.DAY_OF_MONTH, contrato.getTimeframe());
    Date dataFinal = calendar.getTime();
    
    if (dataFinal.before(new Date())) {
        contrato.setAtivo(false);
    }
    
    contratoRepository.save(contrato);
    
    return Optional.of(contrato);
}

}
