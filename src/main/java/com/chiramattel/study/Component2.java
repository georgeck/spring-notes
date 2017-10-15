package com.chiramattel.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * A dummy component that depends on another component.
 * @see Component1Impl
 */
@Component
public class Component2 {

    private final Component1 component1;

    @Autowired
    public Component2(Component1 component1) {
        this.component1 = component1;
    }

    @PostConstruct
    public void afterSetup(){
        System.out.println("Data from Comp1 " + component1.getDataFromResource());
    }
}
