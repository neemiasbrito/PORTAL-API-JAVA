package soluction.com.portal.api.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soluction.com.portal.core.domain.service.PerfilService;
import soluction.com.portal.shared.dto.PerfilDTO;

@RestController
@RequestMapping("perfis")
@RequiredArgsConstructor
public class PerfilResource {

    private final PerfilService perfilService;

    @GetMapping
    public ResponseEntity<Page<PerfilDTO>> findAll(Pageable pageable){
        return ResponseEntity.ok().body(perfilService.getAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PerfilDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(perfilService.findId(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PerfilDTO> update(@RequestBody PerfilDTO perfilDTO, @PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(perfilService.update(id, perfilDTO));
    }

    @PostMapping()
    public ResponseEntity<PerfilDTO> create(@RequestBody PerfilDTO perfilDTO){
        return ResponseEntity.ok().body(perfilService.create(perfilDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete( @PathVariable(value = "id") Long id){
        perfilService.delete(id);
        return ResponseEntity.ok().body("Deletado com sucesso");
    }


}
