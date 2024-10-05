package soluction.com.portal.core.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "met_metodo", schema = "portal")
public class Metodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "met_nr_id")
    private Long id;

    @Column(name = "met_tx_metodo")
    private String metodo;
    @Column(name = "met_tx_status")
    private String status;
    @Column(name = "met_tx_descricao")
    private String descricao;

    @Column(name = "ope_nr_id")
    private Long idOperacao;

    @Column(name = "sis_nr_id")
    private Long idSistema;

    @ManyToMany(mappedBy = "metodos")
    @JsonIgnore
    private List<Perfil> perfis;

}
