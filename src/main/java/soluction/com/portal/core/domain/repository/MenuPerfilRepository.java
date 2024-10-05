package soluction.com.portal.core.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soluction.com.portal.core.domain.model.Usuario;

public interface MenuPerfilRepository extends JpaRepository<Usuario, Integer> {
    }
