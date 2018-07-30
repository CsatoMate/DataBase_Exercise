package hello.repository;

import hello.model.Motor;
import org.springframework.data.repository.CrudRepository;

public interface MotorRepository extends CrudRepository<Motor, Long> {
}
