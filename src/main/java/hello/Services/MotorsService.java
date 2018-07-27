package hello.Services;

import hello.Models.Motors;
import hello.Repositorys.MotorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorsService {
    @Autowired
    private MotorsRepository motorRepository;

    public List<Motors> findAll() {
        return motorRepository.findAll();
    }

    public Optional<Motors> findById(Long pId){
        return  motorRepository.findById(pId);
    }

    public void addOwner(Motors pMotor){
        motorRepository.save(pMotor);
    }

    public void deleteById(Long pId){
        motorRepository.deleteById(pId);
    }

    public void deleteOwner(Motors pMotor){
        motorRepository.delete(pMotor);
    }

    public void deleteAll(){
        motorRepository.deleteAll();
    }
}
