package soluction.com.portal.core.domain.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import soluction.com.portal.core.domain.model.FotoUsuario;
import soluction.com.portal.core.domain.repository.FotoUsuarioRepository;
import soluction.com.portal.exceptions.EntidadeNaoEncontradaException;
import soluction.com.portal.shared.dto.FotoUsuarioDTO;


@Service
@RequiredArgsConstructor
public class FotoUsuarioService  implements ServiceBase<FotoUsuarioDTO, Long>  {

    private final ModelMapper modelMapper;

    private final FotoUsuarioRepository fotoUsuarioRepository;

    @Override
    public FotoUsuarioDTO create(FotoUsuarioDTO fotoUsuarioDTO) {
        return modelMapper.map(fotoUsuarioRepository.save(modelMapper.map(fotoUsuarioDTO, FotoUsuario.class)), FotoUsuarioDTO.class);
    }

    private FotoUsuario findExiste(Long id) {
        return fotoUsuarioRepository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("Registro não encontrado") {
            @Override
            public String getMessage() {
                return super.getMessage();
            }
        });
    }

    @Override
    public FotoUsuarioDTO update(Long id, FotoUsuarioDTO fotoUsuarioDTO) {
        FotoUsuario fotoUsuario = findExiste(id);
        fotoUsuario = modelMapper.map(fotoUsuarioDTO, FotoUsuario.class);
        fotoUsuario.setId(id);
        return modelMapper.map(fotoUsuarioRepository.save(fotoUsuario), FotoUsuarioDTO.class);
    }


    @Override
    public void delete(Long id) {
        FotoUsuario fotoUsuario = findExiste(id);
        fotoUsuarioRepository.delete(fotoUsuario);
    }

    @Override
    public Page<FotoUsuarioDTO> getAll(Pageable pageable) {
        Page<FotoUsuario> page = fotoUsuarioRepository.findAll(pageable);
        return page.map((entity) ->{
            return modelMapper.map(entity, FotoUsuarioDTO.class);
        });
    }

    @Override
    public FotoUsuarioDTO findId(Long id) {
        return modelMapper.map(findExiste(id), FotoUsuarioDTO.class);
    }
}
