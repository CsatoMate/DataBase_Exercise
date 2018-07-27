package hello.Repositorys;

import hello.Models.Owners;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnersRepository extends JpaRepository<Owners, Long> {

}
