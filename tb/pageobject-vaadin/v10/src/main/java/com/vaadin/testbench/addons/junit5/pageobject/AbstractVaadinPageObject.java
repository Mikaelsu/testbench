/**
 * Copyright © 2017 Sven Ruppert (sven.ruppert@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vaadin.testbench.addons.junit5.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.vaadin.testbench.addons.junit5.extensions.container.ContainerInfo;
import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.combobox.testbench.ComboBoxElement;
import com.vaadin.flow.component.grid.testbench.GridElement;
import com.vaadin.flow.component.html.testbench.LabelElement;
import com.vaadin.flow.component.html.testbench.SpanElement;
import com.vaadin.flow.component.textfield.testbench.PasswordFieldElement;
import com.vaadin.flow.component.textfield.testbench.TextFieldElement;
import com.vaadin.testbench.ElementQuery;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.commands.TestBenchCommandExecutor;

/**
 *
 */
public abstract class AbstractVaadinPageObject
    extends AbstractPageObject
    implements VaadinPageObject {

  private TestBenchTestCase testCase = new TestBenchTestCase() { };

  public AbstractVaadinPageObject(WebDriver webdriver, ContainerInfo containerInfo) {
    super(webdriver, containerInfo);
    //testbench specific init
    testCase.setDriver(webdriver);
    setDriver(testCase.getDriver());
  }



  //compat Method
  public <T extends TestBenchElement> ElementQuery<T> $(Class<T> clazz) {return testCase.$(clazz);}

  public ElementQuery<TestBenchElement> $(String tagName) {return testCase.$(tagName);}

  public TestBenchCommandExecutor getCommandExecutor() {return testCase.getCommandExecutor();}

  public WebElement findElement(By by) {return testCase.findElement(by);}

  public List<WebElement> findElements(By by) {return testCase.findElements(by);}



  public WithID<TextFieldElement> textField() {
    return id -> testCase.$(TextFieldElement.class).id(id);
  }

  public WithID<PasswordFieldElement> passwordField() {
    return id -> testCase.$(PasswordFieldElement.class).id(id);
  }

  public WithID<ButtonElement> btn() {
    return id -> testCase.$(ButtonElement.class).id(id);
  }

  public WithID<SpanElement> span() {
    return id -> testCase.$(SpanElement.class).id(id);
  }

  public WithID<LabelElement> label() {
    return id -> testCase.$(LabelElement.class).id(id);
  }

  public WithID<GridElement> grid() {
    return id -> testCase.$(GridElement.class).id(id);
  }

  public WithID<ComboBoxElement> comboBox() {
    return id -> testCase.$(ComboBoxElement.class).id(id);
  }


  //TODO not available until now
//  public WithID<DateFieldElement> dateField() {
//    return id -> testCase.$(DateFieldElement.class).id(id);
//  }


//  New inheritence in V10
//  public WithID<FormLayoutElement> formLayout() {
//    return id -> testCase.$(FormLayoutElement.class).id(id);
//  }

//  public WithID<HorizontalLayoutElement> horizontalLayout() {
//    return id -> testCase.$(HorizontalLayoutElement.class).id(id);
//  }

//  public WithID<VerticalLayoutElement> verticalLayout() {
//    return id -> testCase.$(VerticalLayoutElement.class).id(id);
//  }


}
