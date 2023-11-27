package com.kvitso.griddemo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.dataview.GridListDataView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route("fails")
public class GridWithLombokView extends VerticalLayout {

    public GridWithLombokView() {

        Grid<PersonWithLombok> grid = new Grid<>();
        grid.addColumn(PersonWithLombok::getName)
                .setHeader("Name");
        grid.addColumn(PersonWithLombok::getEmail)
                .setHeader("Email");
        PersonWithLombok person = new PersonWithLombok();
        person.setName("Jorma");
        person.setEmail("old@gmail.com");

        GridListDataView<PersonWithLombok> gridDataView = grid.setItems(person);

        Button modify = new Button("Modify data", e -> {
            person.setEmail("new@gmail.com");
            gridDataView.refreshItem(person);
        });
        add(grid, modify);
    }
}
