package soluction.com.portal.core.domain.model;

import java.time.ZonedDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "log", schema = "portal")
public class Log {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long log_nr_id;
    
    private String log_tx_sistema;
    private String log_tx_classe;
    private String log_tx_metodo;
    private String log_tx_usuario;
    private ZonedDateTime log_dt_datahora;
    private String log_tx_status;
    private String log_tx_ip;
    private String log_tx_parametros;

}
