package soluction.com.portal.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class PerfilDTO {

    @JsonProperty(value = "id") 
    public Long per_nr_id;

    @JsonProperty(value = "nome") 
    public String per_tx_nome;
    @JsonProperty(value = "status") 
    public String per_tx_status;
    @JsonProperty(value = "classe") 
    public String per_tx_class;

    private List<OperacaoDTO> operacaos;

    private List<MetodoDTO> metodos;
}
