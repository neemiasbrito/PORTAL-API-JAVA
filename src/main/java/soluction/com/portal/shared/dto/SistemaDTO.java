package soluction.com.portal.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SistemaDTO {

    @JsonProperty(value = "id")
    public Long sis_nr_id;

    @JsonProperty(value = "nome")
    public String sis_tx_nome;
    @JsonProperty(value = "descricao")
    public String sis_tx_descricao;
    @JsonProperty(value = "status") 
    public String sis_tx_status;  
}
