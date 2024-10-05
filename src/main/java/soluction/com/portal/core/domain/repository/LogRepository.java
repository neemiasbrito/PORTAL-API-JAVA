package soluction.com.portal.core.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soluction.com.portal.core.domain.model.Log;

public interface LogRepository  extends JpaRepository<Log, Long>{
    
}
