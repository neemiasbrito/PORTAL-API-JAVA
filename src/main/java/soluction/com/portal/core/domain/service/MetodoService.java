package soluction.com.portal.core.domain.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import soluction.com.portal.core.domain.model.Metodo;
import soluction.com.portal.core.domain.repository.MetodoRepository;
import soluction.com.portal.exceptions.EntidadeNaoEncontradaException;
import soluction.com.portal.shared.dto.MetodoDTO;

@Service
@RequiredArgsConstructor
public class MetodoService implements ServiceBase<MetodoDTO, Long>{

    private final ModelMapper modelMapper;

    private final MetodoRepository metodoRepository;

    @Override
    public MetodoDTO create(MetodoDTO metodoDTO) {
        return modelMapper.map(metodoRepository.save(modelMapper.map(metodoDTO, Metodo.class)), MetodoDTO.class);
    }

    @Override
    public MetodoDTO update(Long id, MetodoDTO metodoDTO) {
        var metodo = findExiste(id);
        metodo = modelMapper.map(metodoDTO, Metodo.class);
        metodo.setId(id);
        return modelMapper.map(metodoRepository.save(metodo), MetodoDTO.class);
    }

    private Metodo findExiste(Long id) {
        return metodoRepository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("Registro não encontrado.") {
            @Override
            public String getMessage() {
                return super.getMessage();
            }
        });
    }

    @Override
    public void delete(Long id) {
        Metodo metodo = findExiste(id);
        metodoRepository.delete(metodo);
    }

    @Override
    public Page<MetodoDTO> getAll(Pageable pageable) {
        Page<Metodo> page = metodoRepository.findAll(pageable);
        return page.map((entity) ->modelMapper.map(entity, MetodoDTO.class));
    }

    @Override
    public MetodoDTO findId(Long id) {
        return modelMapper.map(findExiste(id), MetodoDTO.class);
    }

    public Page<MetodoDTO> findAllOperacao(Long idOperacao, Pageable pageable) {
        Page<Metodo> page = metodoRepository.findByIdOperacao(idOperacao, pageable);
        return page.map((entity) -> modelMapper.map(entity, MetodoDTO.class));
    }



}
