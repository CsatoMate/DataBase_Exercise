package hello.service;

import hello.model.Motor;

import java.util.List;
import java.util.Optional;

public interface MotorService {


    List<Motor> findAll();

    Optional<Motor> findById(Long pId);

    void addOwner(Motor pMotor);

    void deleteById(Long pId);

    void deleteOwner(Motor pMotor);
}
