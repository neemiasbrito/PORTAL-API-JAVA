package soluction.com.portal.api.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soluction.com.portal.core.domain.service.FotoUsuarioService;
import soluction.com.portal.shared.dto.FotoUsuarioDTO;

@RestController
@RequestMapping("fotos")
@RequiredArgsConstructor
public class FotoUsuarioResource {

    private final FotoUsuarioService fotoUsuarioService;

    @GetMapping
    public ResponseEntity<Page<FotoUsuarioDTO>> findALL(Pageable pageable){
        return ResponseEntity.ok().body(fotoUsuarioService.getAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FotoUsuarioDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(fotoUsuarioService.findId(id));
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<FotoUsuarioDTO> update(@RequestBody FotoUsuarioDTO fotoUsuarioDTO, @PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(fotoUsuarioService.update(id, fotoUsuarioDTO));
    }

    @PostMapping()
    public ResponseEntity<FotoUsuarioDTO> create(@RequestBody FotoUsuarioDTO fotoUsuarioDTO){
        return ResponseEntity.ok().body(fotoUsuarioService.create(fotoUsuarioDTO));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body("Deletado com Sucesso");
    }


}
