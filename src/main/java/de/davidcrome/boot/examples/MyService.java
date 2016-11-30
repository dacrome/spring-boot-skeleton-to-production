package de.davidcrome.boot.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private MyConfiguration.MyObject myObject;

    @Autowired
    public MyService(MyConfiguration.MyObject myObject) {
        this.myObject = myObject;
    }

    public MyConfiguration.MyObject getMyObject() {
        return myObject;
    }

    public String getString() {
        return myObject.getString();
    }

    public Integer getInteger() {
        return myObject.getInteger();
    }
}
