package io.javabrains.jwt.repo;

import io.javabrains.jwt.model.Demon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemonRepo extends CrudRepository<Demon,Long> {
}
