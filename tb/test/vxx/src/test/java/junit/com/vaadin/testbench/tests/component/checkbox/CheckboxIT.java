package junit.com.vaadin.testbench.tests.component.checkbox;

import static com.vaadin.flow.component.checkbox.testbench.test.CheckboxView.CHECKED;
import static com.vaadin.flow.component.checkbox.testbench.test.CheckboxView.NAV;
import static com.vaadin.flow.component.checkbox.testbench.test.CheckboxView.NOTEXT;
import static com.vaadin.flow.component.checkbox.testbench.test.CheckboxView.TEXT;

import org.junit.jupiter.api.Assertions;
import com.vaadin.flow.component.checkbox.testbench.CheckboxElement;
import com.vaadin.testbench.addons.junit5.extensions.unittest.VaadinTest;
import junit.com.vaadin.testbench.tests.component.common.AbstractIT;
import junit.com.vaadin.testbench.tests.testUI.GenericTestPageObject;

@VaadinTest
public class CheckboxIT extends AbstractIT {


  @VaadinTest(navigateAsString = NAV)
  public void checkUncheck(GenericTestPageObject po) throws Exception {

    final CheckboxElement checkboxWithText = po.checkBox().id(TEXT);
    final CheckboxElement checkboxWithNoText = po.checkBox().id(NOTEXT);
    final CheckboxElement checkboxInitiallyChecked = po.checkBox().id(CHECKED);

    Assertions.assertFalse(checkboxWithNoText.isChecked());
    Assertions.assertFalse(checkboxWithText.isChecked());
    Assertions.assertTrue(checkboxInitiallyChecked.isChecked());

    checkboxWithNoText.setChecked(true);
    Assertions.assertTrue(checkboxWithNoText.isChecked());
    checkboxWithText.setChecked(true);
    Assertions.assertTrue(checkboxWithText.isChecked());
    checkboxInitiallyChecked.setChecked(false);
    Assertions.assertFalse(checkboxInitiallyChecked.isChecked());

    checkboxWithNoText.setChecked(false);
    Assertions.assertFalse(checkboxWithNoText.isChecked());
    checkboxWithText.setChecked(false);
    Assertions.assertFalse(checkboxWithText.isChecked());
    checkboxInitiallyChecked.setChecked(true);
    Assertions.assertTrue(checkboxInitiallyChecked.isChecked());
  }

  @VaadinTest(navigateAsString = NAV)
  public void getLabel(GenericTestPageObject po) throws Exception {

    final CheckboxElement checkboxWithText = po.checkBox().id(TEXT);
    final CheckboxElement checkboxWithNoText = po.checkBox().id(NOTEXT);
    final CheckboxElement checkboxInitiallyChecked = po.checkBox().id(CHECKED);

    Assertions.assertEquals("Text" , checkboxWithText.getLabel());
    Assertions.assertEquals("" , checkboxWithNoText.getLabel());
    Assertions.assertEquals("Checked initially" ,
                            checkboxInitiallyChecked.getLabel());
  }

}
