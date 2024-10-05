package soluction.com.portal.core.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.ZonedDateTime;

@Setter
@Getter
@Table(name = "res_recall_senha", schema = "portal")
@Entity
public class RecallSenha{

    @Id
    private Long id;

    @Column(name = "res_tx_pergunta")
    private String pergunta;

    @Column(name = "res_tx_resposta")
    private  String responta;

    @Column(name = "res_dt_ultimoacesso")
    private ZonedDateTime ultimoAcesso;

    @Column(name = "res_nr_tentativas")
    private Integer tentativas;


    @ManyToOne
    @JoinColumn(name = "usu_nr_id")
    private Usuario usuario;



}
