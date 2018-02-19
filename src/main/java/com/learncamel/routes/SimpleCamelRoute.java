package com.learncamel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by z001qgd on 1/3/18.
 */
@Component
public class SimpleCamelRoute extends RouteBuilder{

    @Autowired
    Environment environment;

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @Override
    public void configure() throws Exception {

        from("{{fromRoute}}")
                    .log("Current Environment is "+ environment.getProperty("message"))
                .to("{{toRoute}}");

        }
}
