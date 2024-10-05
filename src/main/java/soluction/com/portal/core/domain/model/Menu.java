package soluction.com.portal.core.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "men_menu", schema = "portal")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long men_nr_id;

    private Integer supermenu_nr_id;
    private String men_tx_status;
    private String men_tx_nome;
    private Integer men_nr_ordem;
    private String men_tx_url;
    private String men_tx_acao;
    private Integer sis_nr_id;
    private String men_tx_icone;
    private String men_tx_tipo;

    @ManyToMany
    @JoinTable(name = "mep_men_per", schema = "portal",
            joinColumns = @JoinColumn(name = "men_nr_id"),
            inverseJoinColumns = @JoinColumn(name = "per_nr_id"))
    private List<Perfil> perfis;


}
