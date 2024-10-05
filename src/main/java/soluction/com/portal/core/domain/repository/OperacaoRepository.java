package soluction.com.portal.core.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import soluction.com.portal.core.domain.model.Operacao;

public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
    Page<Operacao> findByIdSistema(Long idSistema, Pageable pageable);

}
