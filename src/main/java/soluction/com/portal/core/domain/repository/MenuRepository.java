package soluction.com.portal.core.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soluction.com.portal.core.domain.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    
}
