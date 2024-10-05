package soluction.com.portal.core.domain.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import soluction.com.portal.core.domain.model.Menu;
import soluction.com.portal.core.domain.repository.MenuRepository;
import soluction.com.portal.exceptions.EntidadeNaoEncontradaException;
import soluction.com.portal.shared.dto.MenuDTO;

@Service
@RequiredArgsConstructor
public class MenuService implements ServiceBase<MenuDTO, Long>{

    private final ModelMapper modelMapper;

    private final MenuRepository menuRepository;


    @Override
    public MenuDTO create(MenuDTO menuDTO) {
        menuDTO.setMen_tx_status("A");
        menuDTO.setMen_tx_tipo("M");
        return modelMapper.map(menuRepository.save(modelMapper.map
        (menuDTO, Menu.class)), MenuDTO.class);
    }


    @Override
    public MenuDTO update(Long id, MenuDTO menuDTO){
        var menu = findExiste(id);
        menu = modelMapper.map(menuDTO, Menu.class);
        menu.setMen_nr_id(id);
        return modelMapper.map(menuRepository.save(menu), MenuDTO.class);
    }


    @Override
    public void delete(Long id){
        Menu menu = findExiste(id);
        menuRepository.delete(menu);
    }

    @Override
    public MenuDTO findId(Long id){
        return modelMapper.map(findExiste(id), MenuDTO.class);
    }

    @Override
    public Page<MenuDTO> getAll(Pageable pageable) {
        Page<Menu> page = menuRepository.findAll(pageable);
        return page.map((entity) -> modelMapper.map(entity, MenuDTO.class));
    }


     private Menu findExiste(Long id) {
        return menuRepository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("Registro não encontrado") {
            @Override
            public String getMessage() {
                return super.getMessage();
            }
        });
    }



}
