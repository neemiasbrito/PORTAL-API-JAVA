package soluction.com.portal.core.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "par_parametro", schema = "portal")
public class Parametro {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "par_nr_id")
    private Long id;

    @Column(name = "par_tx_nome")
    private String nome;

    @Column(name = "par_tx_valor")
    private String valor;

    @Column(name = "par_tx_secreto")
    private String secreto;

    @Column(name = "par_tx_descricao")
    private String descricao;

    @Column(name = "sis_nr_id")
    private Long idSistema;

}
