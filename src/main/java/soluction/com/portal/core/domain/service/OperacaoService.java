package soluction.com.portal.core.domain.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import soluction.com.portal.core.domain.model.Operacao;
import soluction.com.portal.core.domain.repository.OperacaoRepository;
import soluction.com.portal.exceptions.EntidadeNaoEncontradaException;
import soluction.com.portal.shared.dto.OperacaoDTO;

@Service
@RequiredArgsConstructor
public class OperacaoService implements ServiceBase<OperacaoDTO, Long> {

    private final ModelMapper modelMapper;

    private final OperacaoRepository operacaoRepository;


    @Override
    public OperacaoDTO create(OperacaoDTO operacaoDTO) {
        return modelMapper.map(operacaoRepository.save(modelMapper.map(operacaoDTO, Operacao.class)), OperacaoDTO.class);
    }

    private Operacao findExiste(Long id) {
        return (Operacao) operacaoRepository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("Register não encontrado") {
            @Override
            public String getMessage() {
                return super.getMessage();
            }
        });
    }

    @Override
    public OperacaoDTO update(Long id, OperacaoDTO operacaoDTO) {
        var operacao = findExiste(id);
        operacao = modelMapper.map(operacaoDTO, Operacao.class);
        operacao.setId(id);
        return modelMapper.map(operacaoRepository.save(operacao), OperacaoDTO.class);
    }

    @Override
    public void delete(Long id) {
        Operacao operacao = findExiste(id);
        operacaoRepository.delete(operacao);
    }

    @Override
    public Page<OperacaoDTO> getAll(Pageable pageable) {
        Page<Operacao> page = operacaoRepository.findAll(pageable);
        return page.map((entity) -> modelMapper.map(entity, OperacaoDTO.class));
    }

    @Override
    public OperacaoDTO findId(Long id) {
        return modelMapper.map(findExiste(id), OperacaoDTO.class);
    }


    public Page<OperacaoDTO> findAllSistema(Long idSistema, Pageable pageable){

        Page<Operacao> page = operacaoRepository.findByIdSistema(idSistema, pageable);
        return page.map((entity) -> modelMapper.map(entity, OperacaoDTO.class));
    }


}
