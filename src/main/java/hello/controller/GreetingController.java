package hello.controller;

import hello.model.Greeting;
import hello.UpperFirstLetter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private UpperFirstLetter ufl = new UpperFirstLetter();

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/api/greeting")
    public String apigreeting() {
        return "Hello JSON";
    }

    @RequestMapping("/api/greeting/{usernames}")
    public Greeting greeting(@PathVariable(value = "usernames") String name) {
        return new Greeting(String.format(template, ufl.makeUpper(name)));
    }


}
