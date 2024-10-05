package soluction.com.portal.exceptions;

import lombok.Getter;

@Getter
public enum ProblemType {
    MESAGEM_INCOMPREENSIVEL("/mesagem-incompreensivel", "Mesagem incompreensivel"),
    ENTIDADE_NAO_ENCONTRADA("/entidade-nao-encontrada", "Entidade não encontrada"),
    METHOD_NOT_SUPORTED("/método-nao-suportado", "/método não suportado"),

    RESOURSE_NOT_FOURD("/recurso-nao-encontrado", "/recurso não encontrado");


    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "https://portalbubling.com.br" + path;
        this.title = title;
    }
}
