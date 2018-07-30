package hello.controller;

import hello.model.Owner;
import hello.service.OwnerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OwnerController {

    private final OwnerServiceImpl ownerService;

    @Autowired
    public OwnerController(OwnerServiceImpl ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping(value = "/owners", method = RequestMethod.GET)
    @ResponseBody
    public List<Owner> findAll(){
        return ownerService.findAll();
    }
}
