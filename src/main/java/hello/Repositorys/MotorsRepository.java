package hello.Repositorys;

import hello.Models.Motors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorsRepository extends JpaRepository<Motors, Long> {
}
