package soluction.com.portal.core.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "fus_foto_usuario", schema = "portal")
@Entity
public class FotoUsuario {

    @Id
    private Long id;

    @Column(name = "fus_bt_foto")
    private byte[] foto;

    @Column(name = "fus_tx_formato")
    private String formato;

    @ManyToOne
    @JoinColumn(name = "usu_nr_id")
    private Usuario usuario;


}
