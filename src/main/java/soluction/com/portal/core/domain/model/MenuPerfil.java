package soluction.com.portal.core.domain.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@Table(name = "vw_menu_perfil", schema = "portal")
public class MenuPerfil {

    public Integer per_nr_id;
    public Integer men_nr_id;
    public Integer supermenu_nr_id;
    public String men_tx_status;
    public String men_tx_nome;
    public Integer men_nr_ordem;
    public String men_tx_url;
    public String men_tx_acao;
    public Integer sis_nr_id;
    public String men_tx_icone;
    public String men_tx_tipo;

}
