package soluction.com.portal.core.domain.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import soluction.com.portal.core.domain.model.Usuario;
import soluction.com.portal.core.domain.repository.MenuPerfilRepository;
import soluction.com.portal.shared.dto.MenuPerfilDTO;


@Service
@RequiredArgsConstructor
public class MenuPerfilService implements ServiceBase<MenuPerfilDTO, Integer> {

    private final ModelMapper modelMapper;

    private final MenuPerfilRepository menuPerfilRepository;


    @Override
    public MenuPerfilDTO create(MenuPerfilDTO menuPerfilDTO) {
        return null;
    }

    @Override
    public MenuPerfilDTO update(Integer id, MenuPerfilDTO menuPerfilDTO) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }


    @Override
    public Page<MenuPerfilDTO> getAll(Pageable pageable) {
        Page<Usuario> page;
        page = menuPerfilRepository.findAll(pageable);
        return page.map((entity) -> modelMapper.map(entity, MenuPerfilDTO.class));

    }


    @Override
    public MenuPerfilDTO findId(Integer id) {
        return null;
    }


}
