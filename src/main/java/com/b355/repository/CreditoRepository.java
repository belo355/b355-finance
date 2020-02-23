package com.b355.repository;

import com.b355.model.Credito;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditoRepository extends CrudRepository<Credito,Long> {
}
