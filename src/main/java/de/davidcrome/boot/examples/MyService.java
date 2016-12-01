package de.davidcrome.boot.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private MyConfiguration.MyObject myObject;
    private final CounterService counterService;

    @Autowired
    public MyService(MyConfiguration.MyObject myObject, CounterService counterService) {
        this.myObject = myObject;
        this.counterService = counterService;
    }

    public MyConfiguration.MyObject getMyObject() {
        this.counterService.increment("myobject.invoked");
        return myObject;
    }

    public String getString() {
        return myObject.getString();
    }

    public Integer getInteger() {
        return myObject.getInteger();
    }
}
