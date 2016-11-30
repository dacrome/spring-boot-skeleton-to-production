package de.davidcrome.boot.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private final MyService myService;

    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }

    @RequestMapping("/my-object")
    public MyConfiguration.MyObject getMyObject() {
        return myService.getMyObject();
    }

    @RequestMapping("/my-string")
    public String getMyString() {
        return myService.getString();
    }

    @RequestMapping("/my-integer")
    public Integer getMyInteger() {
        return myService.getInteger();
    }
}
