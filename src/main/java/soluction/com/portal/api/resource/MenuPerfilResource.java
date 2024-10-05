package soluction.com.portal.api.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soluction.com.portal.core.domain.service.MenuPerfilService;
import soluction.com.portal.shared.dto.MenuPerfilDTO;

@RestController
@RequestMapping("menusperfis")
@RequiredArgsConstructor
public class MenuPerfilResource {

    private final MenuPerfilService menuPerfilService;

    @GetMapping
    public ResponseEntity<Page<MenuPerfilDTO>> findALL(Pageable pageable){
        return ResponseEntity.ok().body(menuPerfilService.getAll(pageable));
    }

}
