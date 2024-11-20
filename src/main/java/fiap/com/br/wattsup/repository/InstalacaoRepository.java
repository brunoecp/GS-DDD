package fiap.com.br.wattsup.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import fiap.com.br.wattsup.models.Instalacao;

public interface InstalacaoRepository extends JpaRepository<Instalacao,UUID>{
    
}
