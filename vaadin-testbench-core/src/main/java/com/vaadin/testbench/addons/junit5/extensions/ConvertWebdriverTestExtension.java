package com.vaadin.testbench.addons.junit5.extensions;

/*-
 * #%L
 * vaadin-testbench-core
 * %%
 * Copyright (C) 2019 Vaadin Ltd
 * %%
 * This program is available under Commercial Vaadin Add-On License 3.0
 * (CVALv3).
 *
 * See the file licensing.txt distributed with this software for more
 * information about licensing.
 *
 * You should have received a copy of the license along with this program.
 * If not, see <http://vaadin.com/license/cval-3>.
 * #L%
 */

import com.vaadin.testbench.addons.webdriver.junit5.WebdriverExtensionFunctions;
import com.vaadin.testbench.proxy.TestBenchDriverProxy;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

import static com.vaadin.testbench.TestBench.createDriver;
import static com.vaadin.testbench.TestBenchLogger.logger;

public class ConvertWebdriverTestExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        logger().debug("BeforeEach -> convert WebDriver to TestBenchDriverProxy");
        final WebDriver driver = WebdriverExtensionFunctions.webdriver(context);
        if (driver == null) {
            logger().warn("Unable to convert webdriver");
            return;
        }

        WebdriverExtensionFunctions.removeWebDriver(context);
        WebdriverExtensionFunctions.storeWebDriver(context, createDriver(driver));
    }

    @Override
    public void afterEach(ExtensionContext context) {
        logger().debug("WfterEach -> convert VaadinWebDriver to WebDriver");
        // TODO(sven): Not a clean life cycle -> compat tests.

        final WebDriver driver = WebdriverExtensionFunctions.webdriver(context);
        if (!(driver instanceof TestBenchDriverProxy)) {
            logger().info("WebDriver is NOT instanceof TestBenchDriverProxy");
            return;
        }

        logger().debug("WebDriver is an instanceof TestBenchDriverProxy");

        WebdriverExtensionFunctions.removeWebDriver(context);
        WebdriverExtensionFunctions.storeWebDriver(context,
                ((TestBenchDriverProxy) driver).getWrappedDriver());
    }
}