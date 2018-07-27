package hello.Controllers;

import hello.Models.Motors;
import hello.Services.MotorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MotorsController {

    @Autowired
    private MotorsService motorsService;

    @RequestMapping(value = "/owners", method = RequestMethod.GET)
    @ResponseBody
    public List<Motors> findAll(){
        return motorsService.findAll();
    }
}
