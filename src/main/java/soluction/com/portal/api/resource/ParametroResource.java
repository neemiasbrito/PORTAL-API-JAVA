package soluction.com.portal.api.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import soluction.com.portal.core.domain.service.ParametroService;
import soluction.com.portal.shared.dto.ParametroDTO;

@RestController
@RequestMapping("parametros")
@RequiredArgsConstructor
public class ParametroResource {

    private final ParametroService parametroService;

    @GetMapping
    public ResponseEntity<Page<ParametroDTO>> findAll(Pageable pageable){
        return ResponseEntity.ok().body(parametroService.getAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ParametroDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(parametroService.findId(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ParametroDTO> update(@RequestBody ParametroDTO parametroDTO, @PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(parametroService.update(id, parametroDTO));
    }


    @PostMapping()
    public ResponseEntity<ParametroDTO> create(@RequestBody ParametroDTO parametroDTO){
        return ResponseEntity.ok().body(parametroService.create(parametroDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id){
        parametroService.delete(id);
        return ResponseEntity.ok().body("Deletado com Sucesso");
    }

    @GetMapping("sistema/{id}")
    public ResponseEntity<Page<ParametroDTO>> getAllParamentroSistema(@PathVariable(name = "id") Long idSistema, Pageable pageable){
        return ResponseEntity.ok().body(parametroService.findAllSistema(idSistema, pageable));
    }

    
}
