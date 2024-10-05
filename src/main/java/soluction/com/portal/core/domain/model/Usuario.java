package soluction.com.portal.core.domain.model;

import java.time.ZonedDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity 
@Table(name = "usu_usuario", schema = "portal")
public class Usuario{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usu_nr_id;

    private String usu_tx_nome;
    private String usu_tx_login;

    @JsonIgnore
    private String usu_tx_senha;

    private String usu_tx_status;

    @Column(unique = true,length = 100)
    private String usu_tx_email;

    private String usu_tx_trocarsenha;
    private ZonedDateTime usu_dt_cadastro;
    private String usu_tx_hash;
    private ZonedDateTime usu_dt_hashcriado;
    private String usu_tx_fone;

    @Column(unique = true)
    private String usu_tx_cpf;

    private String usu_tx_codigosms;  
    private Integer id_migracao;  
    private String usu_tx_apelido;
    private String usu_tx_sexo;
    private String usu_tx_token;  
    private String usu_tx_plataform;
    private ZonedDateTime usu_dt_nascimento;
    private Boolean usu_bl_receber_notificacao;

    @ManyToMany
    @JoinTable(name = "pu_per_usu", schema = "portal",
            joinColumns = @JoinColumn(name = "usu_nr_id"),
            inverseJoinColumns = @JoinColumn(name = "per_nr_id"))
    private List<Perfil> perfis;
   
}
