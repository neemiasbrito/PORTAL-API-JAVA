package soluction.com.portal.core.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceBase<T, I> {

    public T create(T perfilDTO);

    public T update(I id, T perfilDTO);

    public void delete(I id);

    public Page<T> getAll(Pageable pageable);

    public T findId(I id);


}
