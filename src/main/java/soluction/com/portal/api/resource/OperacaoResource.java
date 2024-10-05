package soluction.com.portal.api.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soluction.com.portal.core.domain.service.OperacaoService;
import soluction.com.portal.shared.dto.OperacaoDTO;

@RestController
@RequestMapping("operacaos")
@RequiredArgsConstructor
public class OperacaoResource {

    private final OperacaoService operacaoService;

    @GetMapping
    public ResponseEntity<Page<OperacaoDTO>> findALL(Pageable pageable){
        return ResponseEntity.ok().body(operacaoService.getAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OperacaoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(operacaoService.findId(id));
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<OperacaoDTO> update(@RequestBody OperacaoDTO operacaoDTO, @PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(operacaoService.update(id, operacaoDTO));
    }

    @PostMapping()
    public ResponseEntity<OperacaoDTO> create(@RequestBody OperacaoDTO operacaoDTO){
        return ResponseEntity.ok().body(operacaoService.create(operacaoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id){
        operacaoService.delete(id);
        return ResponseEntity.ok().body("Deletado com Sucesso");
    }


    @GetMapping("sistema/{id}")
    public ResponseEntity<Page<OperacaoDTO>> getAllOperacaoSistema(@PathVariable(name = "id") Long idSistema, Pageable pageable){
        return ResponseEntity.ok().body(operacaoService.findAllSistema(idSistema, pageable));
    }



}
