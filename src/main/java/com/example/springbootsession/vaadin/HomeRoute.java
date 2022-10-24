package com.example.springbootsession.vaadin;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;

@PermitAll
@Route("")
public class HomeRoute extends HorizontalLayout {

    public HomeRoute() {
        this.add(new Label("Vaadin works!"));
    }
}
