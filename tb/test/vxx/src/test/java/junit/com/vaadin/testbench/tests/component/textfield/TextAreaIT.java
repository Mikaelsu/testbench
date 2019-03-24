package junit.com.vaadin.testbench.tests.component.textfield;

import static com.vaadin.flow.component.textfield.testbench.test.TextAreaView.INITIAL_VALUE;
import static com.vaadin.flow.component.textfield.testbench.test.TextAreaView.LABEL_EAGER;
import static com.vaadin.flow.component.textfield.testbench.test.TextAreaView.NAV;
import static com.vaadin.flow.component.textfield.testbench.test.TextAreaView.NOLABEL;
import static com.vaadin.flow.component.textfield.testbench.test.TextAreaView.PLACEHOLDER;

import org.junit.jupiter.api.Assertions;
import com.vaadin.flow.component.textfield.testbench.TextAreaElement;
import com.vaadin.testbench.addons.junit5.extensions.unittest.VaadinTest;
import junit.com.vaadin.testbench.tests.component.common.AbstractIT;
import junit.com.vaadin.testbench.tests.testUI.GenericTestPageObject;

@VaadinTest
public class TextAreaIT extends AbstractIT {


  @VaadinTest(navigateAsString = NAV)
  public void getSetValue(GenericTestPageObject po) throws Exception {

    final TextAreaElement labelEager = po.textArea().id(LABEL_EAGER);
    final TextAreaElement nolabel = po.textArea().id(NOLABEL);
    final TextAreaElement initialValue = po.textArea().id(INITIAL_VALUE);
    final TextAreaElement placeholder = po.textArea().id(PLACEHOLDER);

    Assertions.assertEquals("" , labelEager.getValue());
    Assertions.assertEquals("" , nolabel.getValue());
    Assertions.assertEquals("Initial" , initialValue.getValue());
    Assertions.assertEquals("" , placeholder.getValue());

    labelEager.setValue("Foo");
    assertStringValue(po,labelEager , "Foo");

    nolabel.setValue("Foo");
    assertStringValue(po,nolabel , "Foo");

    initialValue.setValue("Foo");
    assertStringValue(po,initialValue , "Foo");

    placeholder.setValue("Foo");
    assertStringValue(po,placeholder , "Foo");
  }

  @VaadinTest(navigateAsString = NAV)
  public void getLabelEager(GenericTestPageObject po) throws Exception {

    final TextAreaElement labelEager = po.textArea().id(LABEL_EAGER);
    final TextAreaElement nolabel = po.textArea().id(NOLABEL);
    final TextAreaElement initialValue = po.textArea().id(INITIAL_VALUE);
    final TextAreaElement placeholder = po.textArea().id(PLACEHOLDER);

    Assertions.assertEquals("Label (eager)" , labelEager.getLabel());
    Assertions.assertEquals("" , nolabel.getLabel());
    Assertions.assertEquals("Has an initial value" , initialValue.getLabel());
    Assertions.assertEquals("Has a placeholder" , placeholder.getLabel());
  }

  @VaadinTest(navigateAsString = NAV)
  public void getPlaceholder(GenericTestPageObject po) throws Exception {

    final TextAreaElement labelEager = po.textArea().id(LABEL_EAGER);
    final TextAreaElement nolabel = po.textArea().id(NOLABEL);
    final TextAreaElement initialValue = po.textArea().id(INITIAL_VALUE);
    final TextAreaElement placeholder = po.textArea().id(PLACEHOLDER);

    Assertions.assertEquals("" , labelEager.getPlaceholder());
    Assertions.assertEquals("" , nolabel.getPlaceholder());
    Assertions.assertEquals("" , initialValue.getPlaceholder());
    Assertions.assertEquals("Text goes here" , placeholder.getPlaceholder());
  }

}
