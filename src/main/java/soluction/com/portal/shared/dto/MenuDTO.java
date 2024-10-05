package soluction.com.portal.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class MenuDTO {
    
    @JsonProperty(value = "id")
    private Long men_nr_id;
    @JsonProperty(value = "id super menu")
    private Long supermenu_nr_id;
    @JsonProperty(value = "status")
    private String men_tx_status;
    @JsonProperty(value = "nome")
    private String men_tx_nome;
    @JsonProperty(value = "ordem")
    private Integer men_nr_ordem;
    @JsonProperty(value = "url")
    private String men_tx_url;
    @JsonProperty(value = "ação")
    private String men_tx_acao;
    @JsonProperty(value = "id sistema")
    private Long sis_nr_id;
    @JsonProperty(value = "icone")
    private String men_tx_icone;
    @JsonProperty(value = "tipo")
    private String men_tx_tipo;

    private List<PerfilDTO> perfis;
}
