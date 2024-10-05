package soluction.com.portal.core.domain.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import soluction.com.portal.core.domain.model.Perfil;
import soluction.com.portal.core.domain.repository.PerfilRepository;
import soluction.com.portal.exceptions.EntidadeNaoEncontradaException;
import soluction.com.portal.shared.dto.PerfilDTO;

@Service
@RequiredArgsConstructor
public class PerfilService implements ServiceBase<PerfilDTO, Long>{

    private final ModelMapper modelMapper;

    private final PerfilRepository perfilRepository;

    @Override
    public PerfilDTO create(PerfilDTO perfilDTO) {
        perfilDTO.setPer_tx_status("A");  
        return modelMapper.map(perfilRepository.save(modelMapper.map
        (perfilDTO, Perfil.class)),PerfilDTO.class);
    }

    @Override
    public PerfilDTO update(Long id, PerfilDTO perfilDTO) {
        var perfil =  findExiste(id);
        perfil = modelMapper.map(perfilDTO, Perfil.class);
        perfil.setPer_nr_id(id);
        return modelMapper.map(perfilRepository.save(perfil), PerfilDTO.class);
    }

    @Override
    public void delete(Long id) {
        Perfil perfil =  findExiste(id);
        perfilRepository.delete(perfil);
    }

    @Override
    public Page<PerfilDTO> getAll(Pageable pageable) {
        Page<Perfil> page  = perfilRepository.findAll(pageable);
        return page.map((entity) -> modelMapper.map(entity, PerfilDTO.class));
    }

    @Override
    public PerfilDTO findId(Long id) {
        return modelMapper.map(findExiste(id), PerfilDTO.class);
    }

    private Perfil findExiste(Long id){
        return perfilRepository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("Registro não encontrado.") {
            @Override
            public String getMessage() {
                return super.getMessage();
            }
        });
    }
}
