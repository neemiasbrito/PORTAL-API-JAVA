package soluction.com.portal.api.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import soluction.com.portal.core.domain.service.MenuService;
import soluction.com.portal.shared.dto.MenuDTO;

@RestController
@RequestMapping("menus") 
@RequiredArgsConstructor
public class MenuResource {

    private final MenuService menuService;

    @GetMapping
    public ResponseEntity<Page<MenuDTO>> findALL(Pageable pageable){
        return ResponseEntity.ok().body(menuService.getAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MenuDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(menuService.findId(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MenuDTO> updade(@RequestBody MenuDTO menuDTO, @PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(menuService.update(id, menuDTO));
    }

    @PostMapping()
    public ResponseEntity<MenuDTO> create(@RequestBody MenuDTO menuDTO){
        return ResponseEntity.ok().body(menuService.create(menuDTO));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id){
        menuService.delete(id);
        return ResponseEntity.ok().body("Deletado com Sucesso");
    }



}
