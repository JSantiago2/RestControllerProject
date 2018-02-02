package com.juan.demojuan;

import com.juan.demojuan.Greeting;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private static final String home = "Welcome to my, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }


    @RequestMapping("/home")
    public Greeting homePage(@RequestParam(value = "query", defaultValue = "Homepage") String query){
        return new Greeting(counter.incrementAndGet(),
                String.format(home, query));

    }

}


