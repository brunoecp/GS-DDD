package fiap.com.br.wattsup.models;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contrato {

    @OneToOne
    @JoinColumn(name = "id_cliente", nullable = false, unique = true)
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_instalacao", nullable = false, unique = true)
    private Instalacao instalacao;

    @NotNull
    @PastOrPresent(message = "A data de início deve ser no passado ou no presente.")
    private Date dtInicio;

    private int timeframe;

    @NotNull
    private boolean ativo;

    @Id
    @GeneratedValue
    private UUID id;

}
