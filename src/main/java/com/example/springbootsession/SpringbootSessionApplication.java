package com.example.springbootsession;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.shared.communication.PushMode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Push(value = PushMode.DISABLED)
@SpringBootApplication
public class SpringbootSessionApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSessionApplication.class, args);
    }
}
