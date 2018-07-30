package hello.controller;

import hello.model.Motor;
import hello.service.MotorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MotorController {

    private final MotorService motorService;

    @Autowired
    public MotorController(MotorService motorService) {
        this.motorService = motorService;
    }

    @RequestMapping(value = "/motors", method = RequestMethod.GET)
//    @ResponseBody
    public List<Motor> findAll(){
        return motorService.findAll();
    }
}
