package soluction.com.portal.core.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import soluction.com.portal.core.domain.model.Metodo;

public interface MetodoRepository extends JpaRepository<Metodo, Long> {
    Page<Metodo> findByIdOperacao(Long idOperacao, Pageable pageable);

}

