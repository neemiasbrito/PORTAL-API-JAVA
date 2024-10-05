package soluction.com.portal.api.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soluction.com.portal.core.domain.service.MetodoService;
import soluction.com.portal.shared.dto.MetodoDTO;

@RestController
@RequestMapping("metodos")
@RequiredArgsConstructor
public class MetodoResource {

    private final MetodoService metodoService;

    @GetMapping
    public ResponseEntity<Page<MetodoDTO>> findAll(Pageable pageable){
        return ResponseEntity.ok().body(metodoService.getAll (pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MetodoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(metodoService.findId(id));
    }

    @PutMapping
    public ResponseEntity<MetodoDTO> update(@RequestBody MetodoDTO metodoDTO, @PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(metodoService.update(id, metodoDTO));
    }

    @PostMapping()
    public ResponseEntity<MetodoDTO> create(@RequestBody MetodoDTO metodoDTO){
        return ResponseEntity.ok().body(metodoService.create(metodoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        metodoService.delete(id);
        return ResponseEntity.ok().body("Deletado com Sucesso");
    }

    @GetMapping("operacao/{id}")
    public ResponseEntity<Page<MetodoDTO>> getAllMetodoOperacao(@PathVariable(name = "id") Long idOperacao, Pageable pageable) {
        return ResponseEntity.ok().body(metodoService.findAllOperacao(idOperacao, pageable));
    }


}
