package soluction.com.portal.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL) // se o atributo  tive null não vai incluir na requesição
@Getter
@Builder
public class Problem {

    private Integer status;
    private LocalDateTime dateTime; // novo atributo
    private String type;
    private String title;
    private String detail;
    private String userMessage; // novo atributo
    private List<Field> fields; // novo atributo

    @Getter
    @Setter
    @Builder
    public static class Field{
        private String name;
        private String userMessage;
    }

  
}
