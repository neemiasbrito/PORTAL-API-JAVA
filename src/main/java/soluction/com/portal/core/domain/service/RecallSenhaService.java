package soluction.com.portal.core.domain.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import soluction.com.portal.core.domain.model.RecallSenha;
import soluction.com.portal.core.domain.repository.RecallSenhaRepository;
import soluction.com.portal.exceptions.EntidadeNaoEncontradaException;
import soluction.com.portal.shared.dto.RecallSenhaDTO;
import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class RecallSenhaService implements ServiceBase<RecallSenhaDTO, Long>{

    private final ModelMapper modelMapper;

    private final RecallSenhaRepository recallSenhaRepository;

    @Override
    public RecallSenhaDTO findId(Long id){
        return modelMapper.map(findExiste(id), RecallSenhaDTO.class);
    }

    @Override
    public RecallSenhaDTO create(RecallSenhaDTO recallSenhaDTO){
        recallSenhaDTO.setUltimoAcesso(ZonedDateTime.now());
        return modelMapper.map(recallSenhaRepository.save(modelMapper.map(recallSenhaDTO, RecallSenha.class)), RecallSenhaDTO.class);
    }

    @Override
    public RecallSenhaDTO update(Long id, RecallSenhaDTO recallSenhaDTO) {
        RecallSenha recallSenha = findExiste(id);
        recallSenha = modelMapper.map(recallSenhaDTO, RecallSenha.class);
        recallSenha.setId(id);
        return modelMapper.map(recallSenhaRepository.save(recallSenha), RecallSenhaDTO.class);
    }

    @Override
    public void delete(Long id) {
        RecallSenha recallSenha = findExiste(id);
        recallSenhaRepository.delete(recallSenha);
    }

    @Override
    public Page<RecallSenhaDTO> getAll(Pageable pageable) {
        Page<RecallSenha> page = recallSenhaRepository.findAll(pageable);
        return page.map((entity) -> modelMapper.map(entity, RecallSenhaDTO.class));

    }

    private RecallSenha findExiste(Long id) {
        return recallSenhaRepository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("Registro não encontrado.") {
            @Override
            public String getMessage() {
                return super.getMessage();
            }
        });
    }

}
