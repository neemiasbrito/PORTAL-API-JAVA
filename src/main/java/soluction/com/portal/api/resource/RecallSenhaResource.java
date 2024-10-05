package soluction.com.portal.api.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soluction.com.portal.core.domain.service.RecallSenhaService;
import soluction.com.portal.shared.dto.RecallSenhaDTO;

@RestController
@RequestMapping("recalls")
@RequiredArgsConstructor
public class RecallSenhaResource {

    private final RecallSenhaService recallSenhaService;

    @GetMapping
    public ResponseEntity<Page<RecallSenhaDTO>> findALL(Pageable pageable){
        return ResponseEntity.ok().body(recallSenhaService.getAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RecallSenhaDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(recallSenhaService.findId(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<RecallSenhaDTO> update(@RequestBody RecallSenhaDTO recallSenhaDTO, @PathVariable(value = "id") Long id){
        return  ResponseEntity.ok().body(recallSenhaService.update(id, recallSenhaDTO));
    }

    @PostMapping()
    public ResponseEntity<RecallSenhaDTO> create(@RequestBody RecallSenhaDTO recallSenhaDTO){
        return ResponseEntity.ok().body(recallSenhaService.create(recallSenhaDTO));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body("Deletado com Sucesso");
    }


}
