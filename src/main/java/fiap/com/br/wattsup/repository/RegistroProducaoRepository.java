package fiap.com.br.wattsup.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import fiap.com.br.wattsup.models.RegistroProducao;

public interface RegistroProducaoRepository extends JpaRepository<RegistroProducao, UUID>{
    
}
