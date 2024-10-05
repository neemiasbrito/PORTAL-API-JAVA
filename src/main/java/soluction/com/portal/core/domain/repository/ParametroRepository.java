package soluction.com.portal.core.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import soluction.com.portal.core.domain.model.Parametro;

public interface ParametroRepository extends JpaRepository<Parametro, Long>{
    Page<Parametro> findByIdSistema(Long idSistema, Pageable pageable);
    
}
