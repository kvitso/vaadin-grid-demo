package com.kvitso.griddemo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.dataview.GridListDataView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route("works")
public class GridWithoutLombokView extends VerticalLayout {

    public GridWithoutLombokView() {

        Grid<PersonWithoutLombok> grid = new Grid<>();
        grid.addColumn(PersonWithoutLombok::getName)
                .setHeader("Name");
        grid.addColumn(PersonWithoutLombok::getEmail)
                .setHeader("Email");
        PersonWithoutLombok person = new PersonWithoutLombok();
        person.setName("Jorma");
        person.setEmail("old@gmail.com");

        GridListDataView<PersonWithoutLombok> gridDataView = grid.setItems(person);

        Button modify = new Button("Modify data", e -> {
            person.setEmail("new@gmail.com");
            gridDataView.refreshItem(person);
        });
        add(grid, modify);
    }
}
