package fiap.com.br.wattsup.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Instalacao {
    
    @Id
    @GeneratedValue
    private UUID id;
    
    @NotBlank
    private String endereco;

    @NotBlank
    private String cep;

    @NotNull
    private boolean ativo;
}
