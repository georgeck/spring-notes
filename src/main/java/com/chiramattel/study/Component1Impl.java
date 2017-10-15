package com.chiramattel.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Profile("dev")
@Component
public class Component1Impl implements Component1 {
    private final ApplicationContext context;

    @Autowired
    public Component1Impl(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public String getDataFromResource(){
        final Resource resource = context.getResource("resource.txt");
        try (final InputStream inputStream = resource.getInputStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostConstruct
    public void init(){
        System.out.println("In Init of Component1");
    }
}
