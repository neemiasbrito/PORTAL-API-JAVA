package soluction.com.portal.core.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "sis_sistema", schema = "portal")
public class Sistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sis_nr_id;

    private String sis_tx_nome;
    private String sis_tx_descricao;
    private String sis_tx_status;   

    @OneToMany
    @JoinColumn(name = "par_nr_id")
    private List<Parametro> parametros;

    @OneToMany
    @JoinColumn(name = "ope_nr_id")
    private List<Operacao> operacaos;

}
