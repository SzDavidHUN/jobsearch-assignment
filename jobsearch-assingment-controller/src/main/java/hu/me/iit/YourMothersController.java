package hu.me.iit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YourMothersController {

    @Autowired
    private YourMothersService yourMothersService;

    @GetMapping("/asd")
    public String index(){
        return yourMothersService.getStuff();
    }

}
