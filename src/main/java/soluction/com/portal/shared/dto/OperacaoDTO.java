package soluction.com.portal.shared.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperacaoDTO {

    private Long id;
    private String nome;
    private String status;
    private String url;
    private String descricao;
    private String classe;
    private Long idSistema;

}
