package com.vaadin.testbench.addons.framework;

import static com.vaadin.testbench.addons.framework.GenericIDGenerator.genericID;

import java.util.function.BiFunction;
import java.util.function.Function;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

/**
 *
 */
public interface ComponentIDGenerator {

  static Function<String, String> caption() {
    return (id) -> id + "." + "caption";
  }

  static Function<String, String> placeholder() {
    return (id) -> id + "." + "placeholder";
  }


  static Function<Class, BiFunction<Class, String, String>> typedComponentIDGenerator() {
    return (clazz) -> (uiClass , label) -> genericID().apply(uiClass , clazz , label);
  }

  static BiFunction<Class, String, String> gridID() {
    return (uiClass , label) -> genericID().apply(uiClass , Grid.class , label);
  }

  static BiFunction<Class, String, String> buttonID() {
    return (uiClass , label) -> genericID().apply(uiClass , Button.class , label);
  }

  static BiFunction<Class, String, String> comboBoxID() {
    return (uiClass , label) -> genericID().apply(uiClass , ComboBox.class , label);
  }

  static BiFunction<Class, String, String> datePickerID() {
    return (uiClass , label) -> genericID().apply(uiClass , DatePicker.class , label);
  }

  static BiFunction<Class, String, String> labelID() {
    return (uiClass , label) -> genericID().apply(uiClass , Label.class , label);
  }

  static BiFunction<Class, String, String> spanID() {
    return (uiClass , label) -> genericID().apply(uiClass , Span.class , label);
  }

  static BiFunction<Class, String, String> textfieldID() {
    return (uiClass , label) -> genericID().apply(uiClass , TextField.class , label);
  }

  static BiFunction<Class, String, String> passwordID() {
    return (uiClass , label) -> genericID().apply(uiClass , PasswordField.class , label);
  }

  static BiFunction<Class, String, String> checkboxID() {
    return (uiClass , label) -> genericID().apply(uiClass , Checkbox.class , label);
  }

//  Layouts

//  static BiFunction<Class, String, String> cssLayoutID() {
//    return (uiClass, label) -> genericID().apply(uiClass, CssLayout.class, label);
//  }

  static BiFunction<Class, String, String> verticalLayoutID() {
    return (uiClass , label) -> genericID().apply(uiClass , VerticalLayout.class , label);
  }

  static BiFunction<Class, String, String> horizontalLayoutID() {
    return (uiClass , label) -> genericID().apply(uiClass , HorizontalLayout.class , label);
  }
}
