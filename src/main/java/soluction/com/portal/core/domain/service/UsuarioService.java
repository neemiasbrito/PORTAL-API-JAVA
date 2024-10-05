package soluction.com.portal.core.domain.service;

import java.time.ZonedDateTime;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soluction.com.portal.core.domain.model.Usuario;
import soluction.com.portal.core.domain.repository.UsuarioRepository;
import soluction.com.portal.exceptions.EntidadeNaoEncontradaException;
import soluction.com.portal.shared.dto.UsuarioDTO;

@Service
@RequiredArgsConstructor
public class UsuarioService implements ServiceBase<UsuarioDTO, Long>{

    private final ModelMapper modelMapper;

    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDTO create(UsuarioDTO usuarioDTO){ // SALVAR
        usuarioDTO.setUsu_dt_cadastro(ZonedDateTime.now());
        usuarioDTO.setUsu_tx_status("A");
        usuarioDTO.setUsu_tx_senha("N");
        usuarioDTO.setUsu_tx_trocarsenha("N");
        return modelMapper.map(usuarioRepository.save(modelMapper.map(usuarioDTO, Usuario.class)), UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO) {
        var usuario = findExiste(id);
        usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuario.setUsu_nr_id(id);
        return modelMapper.map(usuarioRepository.save(usuario),UsuarioDTO.class);
    }

    private Usuario findExiste(Long id) {

        return usuarioRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Registro não encontrado! id: " + id) {
            @Override
            public String getMessage() {
                return super.getMessage();
            }
        });

    }

    @Override
    public void delete(Long id) { // EXCLUIR
        Usuario usuario = findExiste(id);
        usuarioRepository.delete(usuario);
    }

    @Override
    public Page<UsuarioDTO> getAll(Pageable pageable){
        Page<Usuario> page = usuarioRepository.findAll(pageable);
        return page.map((entity) -> modelMapper.map(entity, UsuarioDTO.class));
    }

    @Override
    public UsuarioDTO findId(Long id){

        return modelMapper.map(findExiste(id), UsuarioDTO.class);
    }


}
