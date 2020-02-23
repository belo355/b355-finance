package com.b355.repository;

import com.b355.model.Debito;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitoRepository extends CrudRepository<Debito,Long> {
}
