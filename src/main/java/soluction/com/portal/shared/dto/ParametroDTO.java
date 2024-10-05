package soluction.com.portal.shared.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParametroDTO {

    private Long id;
    private String nome;
    private String valor;
    private String secreto;
    private String descricao;
    private Long idSistema;

}
