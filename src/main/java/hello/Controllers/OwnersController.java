package hello.Controllers;

import hello.Models.Owners;
import hello.Services.OwnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OwnersController {

    @Autowired
    private OwnersService ownersService;

    @RequestMapping(value = "/owners", method = RequestMethod.GET)
    @ResponseBody
    public List<Owners> findAll(){
        return ownersService.findAll();
    }
}
