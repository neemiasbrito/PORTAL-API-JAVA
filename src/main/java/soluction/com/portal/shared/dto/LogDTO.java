package soluction.com.portal.shared.dto;

import java.time.ZonedDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogDTO {
    
    @JsonProperty(value = "id")
    private Long log_nr_id;
    @JsonProperty(value = "sistema")
    private String log_tx_sistema;
    @JsonProperty(value = "classe")
    private String log_tx_classe;
    @JsonProperty(value = "metodo")
    private String log_tx_metodo;
    @JsonProperty(value = "usuario")
    private String log_tx_usuario;
    @JsonProperty(value = "data da hora")
    private ZonedDateTime log_dt_datahora;
    @JsonProperty(value = "status")
    private String log_tx_status;
    @JsonProperty(value = "ip")
    private String log_tx_ip;
    @JsonProperty(value = "parametros")
    private String log_tx_parametros;
}
