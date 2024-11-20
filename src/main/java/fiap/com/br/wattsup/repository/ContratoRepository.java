package fiap.com.br.wattsup.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import fiap.com.br.wattsup.models.Cliente;
import fiap.com.br.wattsup.models.Contrato;
import fiap.com.br.wattsup.models.Instalacao;

public interface ContratoRepository extends JpaRepository<Contrato, UUID> {
    Optional<Contrato> findByClienteIdAndInstalacaoIdAndAtivoTrue(Cliente cliente, Instalacao instalacao);
}
