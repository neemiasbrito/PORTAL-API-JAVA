package soluction.com.portal.core.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "per_perfil", schema = "portal")
public class Perfil {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long per_nr_id;

    private String per_tx_nome;
    private String per_tx_status;
    private String per_tx_class;

    @ManyToMany(mappedBy = "perfis")
    @JsonIgnore
    private List<Usuario> usuarios;

    @ManyToMany(mappedBy = "perfis")
    @JsonIgnore
    private List<Menu> menus;

    @ManyToMany
    @JoinTable(name = "opm_met_ope_per", schema = "portal",
            joinColumns = @JoinColumn(name = "per_nr_id"),
            inverseJoinColumns = @JoinColumn(name = "ope_nr_id"))
    private List<Operacao> operacaos;

    @ManyToMany
    @JoinTable(name = "opm_met_ope_per", schema = "portal",
            joinColumns = @JoinColumn(name = "per_nr_id"),
            inverseJoinColumns = @JoinColumn(name = "met_nr_id"))
    private List<Metodo> metodos;


}
