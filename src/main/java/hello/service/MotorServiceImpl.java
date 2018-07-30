package hello.service;

import hello.model.Motor;
import hello.repository.MotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorServiceImpl implements MotorService{

    private final MotorRepository motorRepository;

    @Autowired
    public MotorServiceImpl(MotorRepository motorRepository) {
        this.motorRepository = motorRepository;
    }


    @Override
    public List<Motor> findAll() {
        return (List<Motor>) motorRepository.findAll();
    }

    @Override
    public Optional<Motor> findById(Long pId) {
        return  motorRepository.findById(pId);
    }

    @Override
    public void addOwner(Motor pMotor) {
        motorRepository.save(pMotor);
    }

    @Override
    public void deleteById(Long pId) {
        motorRepository.deleteById(pId);
    }

    @Override
    public void deleteOwner(Motor pMotor) {
        motorRepository.delete(pMotor);
    }

}