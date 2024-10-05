package soluction.com.portal.api.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import soluction.com.portal.core.domain.service.UsuarioService;
import soluction.com.portal.shared.dto.UsuarioDTO;

import javax.validation.Valid;

@RestController
@RequestMapping("usuarios") 
@RequiredArgsConstructor
public class UsuarioResource {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<Page<UsuarioDTO>> findALL(@Valid Pageable pageable){
        return ResponseEntity.ok().body(usuarioService.getAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(usuarioService.findId(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioDTO usuarioDTO, @PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(usuarioService.update(id, usuarioDTO));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO usuarioDTO){
        return ResponseEntity.ok().body(usuarioService.create(usuarioDTO));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id){
        usuarioService.delete(id);
        return ResponseEntity.ok().body("Deletado com sucesso");
    }


}
