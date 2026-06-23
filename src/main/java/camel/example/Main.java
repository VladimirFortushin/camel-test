package camel.example;

import camel.example.route.ExampleRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        try(CamelContext camelContext = new DefaultCamelContext()){
            camelContext.addRoutes(new ExampleRoute());
            camelContext.start();
            Thread.sleep(2000);
            camelContext.stop();
        }
    }
}