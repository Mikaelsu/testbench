package junit.com.vaadin.testbench.tests.component.textfield;

import com.vaadin.flow.component.textfield.testbench.PasswordFieldElement;
import com.vaadin.testbench.addons.junit5.extensions.unittest.VaadinTest;
import junit.com.vaadin.testbench.tests.component.common.AbstractIT;
import junit.com.vaadin.testbench.tests.testUI.GenericTestPageObject;
import org.junit.jupiter.api.Assertions;

import static com.vaadin.flow.component.textfield.testbench.test.PasswordFieldView.INITIAL_VALUE;
import static com.vaadin.flow.component.textfield.testbench.test.PasswordFieldView.LABEL_EAGER;
import static com.vaadin.flow.component.textfield.testbench.test.PasswordFieldView.NAV;
import static com.vaadin.flow.component.textfield.testbench.test.PasswordFieldView.NOLABEL;
import static com.vaadin.flow.component.textfield.testbench.test.PasswordFieldView.PLACEHOLDER;

@VaadinTest
public class PasswordFieldIT extends AbstractIT {

    @VaadinTest(navigateAsString = NAV)
    public void getSetValue(GenericTestPageObject po) throws Exception {

        final PasswordFieldElement labelEager = po.$(PasswordFieldElement.class).id(LABEL_EAGER);
        final PasswordFieldElement nolabel = po.$(PasswordFieldElement.class).id(NOLABEL);
        final PasswordFieldElement initialValue = po.$(PasswordFieldElement.class).id(INITIAL_VALUE);
        final PasswordFieldElement placeholder = po.$(PasswordFieldElement.class).id(PLACEHOLDER);

        Assertions.assertEquals("", labelEager.getValue());
        Assertions.assertEquals("", nolabel.getValue());
        Assertions.assertEquals("Initial", initialValue.getValue());
        Assertions.assertEquals("", placeholder.getValue());

        labelEager.setValue("Foo");
        assertStringValue(po, labelEager, "Foo");

        nolabel.setValue("Foo");
        assertStringValue(po, nolabel, "Foo");

        initialValue.setValue("Foo");
        assertStringValue(po, initialValue, "Foo");

        placeholder.setValue("Foo");
        assertStringValue(po, placeholder, "Foo");
    }

    @VaadinTest(navigateAsString = NAV)
    public void getLabelEager(GenericTestPageObject po) throws Exception {

        final PasswordFieldElement labelEager = po.$(PasswordFieldElement.class).id(LABEL_EAGER);
        final PasswordFieldElement nolabel = po.$(PasswordFieldElement.class).id(NOLABEL);
        final PasswordFieldElement initialValue = po.$(PasswordFieldElement.class).id(INITIAL_VALUE);
        final PasswordFieldElement placeholder = po.$(PasswordFieldElement.class).id(PLACEHOLDER);

        Assertions.assertEquals("Label (eager)", labelEager.getLabel());
        Assertions.assertEquals("", nolabel.getLabel());
        Assertions.assertEquals("Has an initial value", initialValue.getLabel());
        Assertions.assertEquals("Has a placeholder", placeholder.getLabel());
    }

    @VaadinTest(navigateAsString = NAV)
    public void getPlaceholder(GenericTestPageObject po) throws Exception {

        final PasswordFieldElement labelEager = po.$(PasswordFieldElement.class).id(LABEL_EAGER);
        final PasswordFieldElement nolabel = po.$(PasswordFieldElement.class).id(NOLABEL);
        final PasswordFieldElement initialValue = po.$(PasswordFieldElement.class).id(INITIAL_VALUE);
        final PasswordFieldElement placeholder = po.$(PasswordFieldElement.class).id(PLACEHOLDER);

        Assertions.assertEquals("", labelEager.getPlaceholder());
        Assertions.assertEquals("", nolabel.getPlaceholder());
        Assertions.assertEquals("", initialValue.getPlaceholder());
        Assertions.assertEquals("Text goes here", placeholder.getPlaceholder());
    }

    @VaadinTest(navigateAsString = NAV)
    public void passwordVisible(GenericTestPageObject po) throws Exception {

        final PasswordFieldElement labelEager = po.$(PasswordFieldElement.class).id(LABEL_EAGER);
        final PasswordFieldElement nolabel = po.$(PasswordFieldElement.class).id(NOLABEL);
        final PasswordFieldElement initialValue = po.$(PasswordFieldElement.class).id(INITIAL_VALUE);
        final PasswordFieldElement placeholder = po.$(PasswordFieldElement.class).id(PLACEHOLDER);

        Assertions.assertFalse(labelEager.isPasswordVisible());
        Assertions.assertFalse(nolabel.isPasswordVisible());
        Assertions.assertFalse(initialValue.isPasswordVisible());
        Assertions.assertFalse(placeholder.isPasswordVisible());

        labelEager.setPasswordVisible(true);
        nolabel.setPasswordVisible(true);
        initialValue.setPasswordVisible(true);
        placeholder.setPasswordVisible(true);

        Assertions.assertTrue(labelEager.isPasswordVisible());
        Assertions.assertTrue(nolabel.isPasswordVisible());
        Assertions.assertTrue(initialValue.isPasswordVisible());
        Assertions.assertTrue(placeholder.isPasswordVisible());

        labelEager.setPasswordVisible(false);
        nolabel.setPasswordVisible(false);
        initialValue.setPasswordVisible(false);
        placeholder.setPasswordVisible(false);

        Assertions.assertFalse(labelEager.isPasswordVisible());
        Assertions.assertFalse(nolabel.isPasswordVisible());
        Assertions.assertFalse(initialValue.isPasswordVisible());
        Assertions.assertFalse(placeholder.isPasswordVisible());

    }

}
