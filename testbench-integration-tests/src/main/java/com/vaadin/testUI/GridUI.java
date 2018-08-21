package com.vaadin.testUI;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.tests.AbstractTestUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;

public class GridUI extends AbstractTestUI {
    @WebServlet(value = { "/VAADIN/*", "/GridUI/*" }, asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = GridUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void setup(VaadinRequest request) {
        int rowCount = 100;
        if (request.getParameter("rowCount") != null) {
            rowCount = Integer.parseInt(request.getParameter("rowCount"));
        }
        IndexedContainer container = new IndexedContainer();

        container.addContainerProperty("foo", String.class, null);
        container.addContainerProperty("bar", String.class, null);

        for (int i = 0; i < rowCount; i++) {
            final Item item = container.addItem(i);
            item.getItemProperty("foo").setValue("foo " + i);
            item.getItemProperty("bar").setValue("bar " + i);
        }

        final Grid grid = new Grid(container);
        grid.setDetailsGenerator(new Grid.DetailsGenerator() {
            public Component getDetails(Grid.RowReference rowReference) {
                final Item item = rowReference.getItem();
                return new Label("Foo = "
                        + item.getItemProperty("foo").getValue() + " Bar = "
                        + item.getItemProperty("bar").getValue());
            }
        });

        grid.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            public void itemClick(ItemClickEvent itemClickEvent) {
                if (itemClickEvent.isDoubleClick()) {
                    Object itemId = itemClickEvent.getItemId();
                    grid.setDetailsVisible(itemId,
                            !grid.isDetailsVisible(itemId));
                }
            }
        });

        addComponent(grid);
        addComponent(new Button("Scroll to 10", new ClickListener() {

            public void buttonClick(ClickEvent event) {
                grid.scrollTo(grid.getContainerDataSource().getIdByIndex(10));

            }
        }));
    }

    @Override
    protected String getTestDescription() {
        return "Test UI for Grid element API";
    }

    @Override
    protected Integer getTicketNumber() {
        return null;
    }
}