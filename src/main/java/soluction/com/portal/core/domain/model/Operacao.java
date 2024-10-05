package soluction.com.portal.core.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "ope_operacao", schema = "portal")
public class Operacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ope_nr_id")
    private Long id;

    @Column(name = "ope_tx_nome")
    private String nome;

    @Column(name = "ope_tx_status")
    private String status;

    @Column(name = "ope_tx_url")
    private String url;

    @Column(name = "ope_tx_descricao")
    private String descricao;

    @Column(name = "ope_tx_classe")
    private String classe;

    @Column(name = "sis_nr_id")
    private Long idSistema;

    @OneToMany
    @JoinColumn(name = "met_nr_id")
    private List<Metodo> metodos;

    @ManyToMany(mappedBy = "operacaos")
    @JsonIgnore
    private List<Perfil> perfis;


}
