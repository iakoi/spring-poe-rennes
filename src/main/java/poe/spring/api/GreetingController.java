package poe.spring.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class GreetingController {

    @GetMapping
    public String greeting(@RequestParam(value = "name") String name) {
        return "hello " + name;
    }

    @PostMapping
    public String greetingPost(@RequestParam(value = "name") String name) {
        return "hello POST " + name;
    }

    @PostMapping("/post2")
    public String greetingPost2(@RequestParam(value = "name") String name) {
        return "hello POST2 " + name;
    }

    @DeleteMapping
    public String greetingDelete() {
        return "hello Delete ";
    }


}
