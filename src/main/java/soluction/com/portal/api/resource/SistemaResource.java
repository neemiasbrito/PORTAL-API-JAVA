package soluction.com.portal.api.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import soluction.com.portal.core.domain.service.SistemaService;
import soluction.com.portal.shared.dto.SistemaDTO;

@RestController
@RequestMapping("sistemas")
@RequiredArgsConstructor
public class SistemaResource {

    private final SistemaService sistemaService;

    @GetMapping
    public ResponseEntity<Page<SistemaDTO>> findALL(Pageable pageable){
        return ResponseEntity.ok().body(sistemaService.getAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SistemaDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(sistemaService.findId(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SistemaDTO> updade(@RequestBody SistemaDTO sistemaDTO, @PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(sistemaService.update(id, sistemaDTO));
    }

    @PostMapping()
    public ResponseEntity<SistemaDTO> create(@RequestBody SistemaDTO sistemaDTO){
        return ResponseEntity.ok().body(sistemaService.create(sistemaDTO));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id){
        sistemaService.delete(id);
        return ResponseEntity.ok().body("Deletado com Sucesso");
    }
    
}
