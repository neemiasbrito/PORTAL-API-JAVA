package soluction.com.portal.shared.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.ZonedDateTime;

@Getter
@Setter
public class RecallSenhaDTO {

    private Long id;
    private String pergunta;
    private String resposta;
    private ZonedDateTime ultimoAcesso;
    private Integer tentativas;

}
