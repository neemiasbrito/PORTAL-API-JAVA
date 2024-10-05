package soluction.com.portal.core.domain.service;

import java.time.ZonedDateTime;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import soluction.com.portal.core.domain.model.Log;
import soluction.com.portal.core.domain.repository.LogRepository;
import soluction.com.portal.exceptions.EntidadeNaoEncontradaException;
import soluction.com.portal.shared.dto.LogDTO;

@Service
@RequiredArgsConstructor
public class LogService implements ServiceBase<LogDTO, Long>{
 
    private final ModelMapper modelMapper;

    private final LogRepository loginRepository;

    @Override
    public LogDTO create(LogDTO logDTO){
        logDTO.setLog_tx_status("S");
        logDTO.setLog_dt_datahora(ZonedDateTime.now());
        logDTO.setLog_tx_ip("127.0.0.1");
        return modelMapper.map(loginRepository.save(modelMapper.map(logDTO, Log.class)), LogDTO.class);
    }

    @Override
    public LogDTO update(Long id, LogDTO logDTO) {
        var log = findExiste(id);
        log = modelMapper.map(logDTO, Log.class);
        log.setLog_nr_id(id);
        return modelMapper.map(loginRepository.save(log), LogDTO.class);
    }

    private Log findExiste(Long id) {
        return loginRepository.findById(id).orElseThrow(()-> new EntidadeNaoEncontradaException("Registro não encontrado") {
            @Override
            public String getMessage() {
                return super.getMessage();
            }
        });
    }

    @Override
    public void delete(Long id) {
        Log log = findExiste(id);
        loginRepository.delete(log);
    }

    @Override
    public Page<LogDTO> getAll(Pageable pageable) {
        Page<Log> page = loginRepository.findAll(pageable);
        return page.map((entity) -> modelMapper.map(entity, LogDTO.class));
    }

    @Override
    public LogDTO findId(Long id) {
        return modelMapper.map(findExiste(id), LogDTO.class);
    }

    



}
