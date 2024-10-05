package soluction.com.portal.shared.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetodoDTO {

    private Long id;
    private String metodo;
    private String status;
    private String descricao;
    private Long idOperacao;
    private Long idSistema;


}
