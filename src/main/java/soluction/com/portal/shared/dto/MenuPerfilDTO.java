package soluction.com.portal.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuPerfilDTO {


    @JsonProperty(value = "id do perfil")
    public Integer per_nr_id;
    @JsonProperty(value = "id do menu")
    public Integer men_nr_id;
    @JsonProperty(value = "id do supermenu")
    public Integer supermenu_nr_id;
    @JsonProperty(value = "status")
    public String men_tx_status;
    @JsonProperty(value = "nome")
    public String men_tx_nome;
    @JsonProperty(value = "ordem")
    public Integer men_nr_ordem;
    @JsonProperty(value = "url")
    public String men_tx_url;
    @JsonProperty(value = "ação")
    public String men_tx_acao;
    @JsonProperty(value = "id do sistema")
    public Integer sis_nr_id;
    @JsonProperty(value = "icone")
    public String men_tx_icone;
    @JsonProperty(value = "tipo")
    public String men_tx_tipo;
}
