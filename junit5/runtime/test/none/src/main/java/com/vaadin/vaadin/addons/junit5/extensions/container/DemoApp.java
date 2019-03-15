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
package com.vaadin.vaadin.addons.junit5.extensions.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
public class DemoApp {
  public static void main(String[] args) {
    SpringApplication.run(DemoApp.class, args);
  }

  @Bean
  public DemoServlet demoServlet() {
    return new DemoServlet();
  }

  @Bean
  public ServletRegistrationBean exampleServletBean(DemoServlet demoServlet) {
    ServletRegistrationBean bean = new ServletRegistrationBean(
     demoServlet, "/demo/*");
    bean.setLoadOnStartup(1);
    return bean;
}
}