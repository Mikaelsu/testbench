/**
 * Copyright © 2017 Sven Ruppert (sven.ruppert@gmail.com)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package junit.com.vaadin.vaadin.addons.junit5.extensions.container;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import com.vaadin.testbench.addons.junit5.extensions.container.ContainerInfo;
import com.vaadin.testbench.addons.junit5.extensions.container.ServletContainerExtension;

@ExtendWith(ServletContainerExtension.class)
class TestSpringBoot2Initializer {

  @Test
  @Disabled
  void test_001(ContainerInfo containerInfo) throws IOException {
    try (InputStream in =
             new URL("http://" + containerInfo.host() + ":" + containerInfo.port() + "/demo")
                 .openStream();
         Scanner scanner = new Scanner(in)) {
      String string = scanner.nextLine();

      assertEquals("Hello World on port " + containerInfo.port() , string);
    }
  }
}