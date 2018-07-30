package hello.model;

public class Greeting {

    private final String greeting;

    public Greeting(String greeting) {
        this.greeting = greeting;
    }

    public String getContent() {
        return greeting;
    }
}