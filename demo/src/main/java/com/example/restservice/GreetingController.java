package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/greeting", method= RequestMethod.GET)
    public Greeting greeting(@RequestParam(value = "name",
    defaultValue = "World") String name ){
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @PostMapping("/greeting")
    public Greeting postGreeting(@RequestParam(value = "name",
            defaultValue = "Post World") String newName ){
        return new Greeting(counter.incrementAndGet(),
                String.format(template, newName));
    }

    @PutMapping("/greeting")
    public Greeting putGreeting(@RequestParam(value = "name",
            defaultValue = "Put World") String newName ){
        return new Greeting(counter.incrementAndGet(),
                String.format(template, newName));
    }

    @DeleteMapping("/greeting")
    public String deleteGreeting() {
        return "Entries deleted :)";
    }

    @PatchMapping("/greeting")
        public String patchGreeting() {
            return "This is confirmation you have used a patch method";
        }


}