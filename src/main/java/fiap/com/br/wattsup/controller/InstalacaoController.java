package fiap.com.br.wattsup.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fiap.com.br.wattsup.models.Instalacao;
import fiap.com.br.wattsup.repository.InstalacaoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/instalacao")
public class InstalacaoController {
    
    @Autowired
    private InstalacaoRepository instalacaoR;

    @GetMapping
    public List<Instalacao> getAllInstalacoes() {
        return instalacaoR.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Instalacao> show(@PathVariable UUID id) {
        Optional<Instalacao> instalacao = getInstalacao(id);
        if(instalacao.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(instalacao.get());
    }

    @PostMapping
    public ResponseEntity<Instalacao> addInstalacao(@RequestBody Instalacao instalacao) {
        instalacao.setId(UUID.randomUUID());
        instalacao.setAtivo(true);
        instalacaoR.save(instalacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(instalacao);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Instalacao> deleteInstalacao(@PathVariable UUID id) {
        Optional<Instalacao> instalacao = getInstalacao(id);
        
        if (instalacao.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Instalacao instalacaoExistente = instalacao.get();
        instalacaoExistente.setAtivo(false);
        instalacaoR.save(instalacaoExistente);
        return ResponseEntity.ok(instalacaoExistente);
    }

    private Optional<Instalacao> getInstalacao(UUID id){
        return instalacaoR.findById(id);
    }
}
