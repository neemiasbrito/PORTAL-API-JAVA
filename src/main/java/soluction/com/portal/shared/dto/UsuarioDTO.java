package soluction.com.portal.shared.dto;

import java.time.ZonedDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {


    @JsonProperty(value = "id") 
    private Long usu_nr_id ;

    @NotNull
    @JsonProperty(value = "nome")
    private String usu_tx_nome;

    @NotNull
    @JsonProperty(value = "login")
    private String usu_tx_login;

    @JsonProperty(value = "senha")
    private String usu_tx_senha;

    @JsonProperty(value = "status")
    private String usu_tx_status;

    @NotNull
    @Size(max = 255)
    @Email
    @JsonProperty(value = "email")
    private String usu_tx_email;


    @JsonProperty(value = "trocar a senha")
    private String usu_tx_trocarsenha;

    @JsonProperty(value = "data de cadastro")
    private ZonedDateTime usu_dt_cadastro;

    @JsonProperty(value = "hash")
    private String usu_tx_hash;

    @JsonProperty(value = "data do hashcriado")
    private ZonedDateTime usu_dt_hashcriado;

    @NotNull
    @Size(max = 20)
    @JsonProperty(value = "fone")
    private String usu_tx_fone;

    @NotNull
    @JsonProperty(value = "cpf")
    private String usu_tx_cpf;

    @JsonProperty(value = "codigosms")
    private String usu_tx_codigosms;

    @JsonProperty(value = "migracao")
    private Integer id_migracao;

    @JsonProperty(value = "apelido")
    private String usu_tx_apelido;

    @NotNull
    @JsonProperty(value = "sexo")
    private String usu_tx_sexo;


    @JsonProperty(value = "token")
    private String usu_tx_token;

    @NotNull
    @JsonProperty(value = "plataforma")
    private String usu_tx_plataform;

    //@NotBlank
    @JsonProperty(value = "nascimento")
    private ZonedDateTime usu_dt_nascimento;


    @JsonProperty(value = "notificacao")
    private boolean usu_bl_receber_notificacao;

    private List<PerfilDTO> perfis;

}
