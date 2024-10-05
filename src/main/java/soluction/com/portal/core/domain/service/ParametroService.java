package soluction.com.portal.core.domain.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import soluction.com.portal.core.domain.model.Parametro;
import soluction.com.portal.core.domain.repository.ParametroRepository;
import soluction.com.portal.exceptions.EntidadeNaoEncontradaException;
import soluction.com.portal.shared.dto.ParametroDTO;

@Service
@RequiredArgsConstructor
public class ParametroService implements ServiceBase<ParametroDTO, Long> {
    
    private final ModelMapper modelMapper;

    private final ParametroRepository parametroRepository;

    @Override
    public ParametroDTO create(ParametroDTO parametroDTO) {
        return modelMapper.map(parametroRepository.save(modelMapper.map(parametroDTO, Parametro.class)), ParametroDTO.class);
    }

    private Parametro findExiste(Long id) {
        return parametroRepository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("Registro não encontrado.") {
            @Override
            public String getMessage() {
                return super.getMessage();
            }
        });
    }
    @Override
    public ParametroDTO update(Long id, ParametroDTO parametroDTO) {
        var parametro = findExiste(id);
        parametro = modelMapper.map(parametroDTO, Parametro.class);
        parametro.setId(id);
        return modelMapper.map(parametroRepository.save(parametro), ParametroDTO.class);
    }

    @Override
    public void delete(Long id){
        Parametro parametro = findExiste(id);
        parametroRepository.delete(parametro);
    }

    @Override
    public Page<ParametroDTO> getAll(Pageable pageable){
        Page<Parametro> page = parametroRepository.findAll(pageable);
        return page.map((entity) -> modelMapper.map(entity, ParametroDTO.class));
    }

    @Override
    public ParametroDTO findId(Long id) {

        return modelMapper.map(findExiste(id), ParametroDTO.class);
    }


    public Page<ParametroDTO> findAllSistema(Long idSistema, Pageable pageable){
        Page<Parametro> page = parametroRepository.findByIdSistema(idSistema, pageable);
        return  page.map((entity) -> modelMapper.map(entity, ParametroDTO.class));
    }


}
