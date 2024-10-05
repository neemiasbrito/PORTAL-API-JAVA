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
import soluction.com.portal.core.domain.service.LogService;
import soluction.com.portal.shared.dto.LogDTO;

@RestController
@RequestMapping("logs")
@RequiredArgsConstructor
public class LogResource {

    private final LogService logService;

    @GetMapping
    public ResponseEntity<Page<LogDTO>> findAll(Pageable pageable){
        return ResponseEntity.ok().body(logService.getAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LogDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(logService.findId(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LogDTO> update(@RequestBody LogDTO loginDTO, @PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(logService.update(id, loginDTO));
    }

    @PostMapping()
    public ResponseEntity<LogDTO> create(@RequestBody LogDTO loginDTO){
        return ResponseEntity.ok().body(logService.create(loginDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id){
        logService.delete(id);
        return ResponseEntity.ok().body("Deletado com sucesso");
    }

    
}
