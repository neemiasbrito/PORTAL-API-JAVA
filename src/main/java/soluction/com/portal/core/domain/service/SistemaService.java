package soluction.com.portal.core.domain.service;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import soluction.com.portal.core.domain.model.Sistema;
import soluction.com.portal.core.domain.repository.SistemaRepository;
import soluction.com.portal.exceptions.EntidadeNaoEncontradaException;
import soluction.com.portal.shared.dto.SistemaDTO;

@Service
@RequiredArgsConstructor
public class SistemaService implements ServiceBase<SistemaDTO, Long>{

    private final ModelMapper modelMapper;

    private final SistemaRepository sistemaRepository;

    @Override
    public SistemaDTO create(SistemaDTO sistemaDTO) {
        sistemaDTO.setSis_tx_status("A");
        return modelMapper.map(sistemaRepository.save(modelMapper.map
        (sistemaDTO, Sistema.class)), SistemaDTO.class);
    }

    @Override
    public SistemaDTO update(Long id, SistemaDTO sistemaDTO) {
        var sistema = findExiste(id);
        sistema = modelMapper.map(sistemaDTO, Sistema.class);
        sistema.setSis_nr_id(id);
        return modelMapper.map(sistemaRepository.save(sistema), SistemaDTO.class);
    }

    @Override
    public void delete(Long id) {
        Sistema sistema = findExiste(id);
        sistemaRepository.delete(sistema);
    }

    @Override
    public SistemaDTO findId(Long id) {
        return modelMapper.map(findExiste(id), SistemaDTO.class);
    }

    @Override
    public Page<SistemaDTO> getAll(Pageable pageable) {
        Page<Sistema> page = sistemaRepository.findAll(pageable);
        return page.map((entity) -> modelMapper.map(entity, SistemaDTO.class));
        
    }

    private Sistema findExiste(Long id) {
        return sistemaRepository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("Registro não encontrado.") {
            @Override
            public String getMessage() {
                return super.getMessage();
            }
        });
    }


}
