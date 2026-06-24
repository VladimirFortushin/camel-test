package camel.example;

import camel.example.bean.ExampleFileFilter;
import camel.example.route.ChoiceExampleRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.spi.PropertiesComponent;

public class FileManager {
    public static void main(String[] args) throws Exception {
        try(CamelContext camelContext = new DefaultCamelContext()){
            camelContext.addRoutes(new ChoiceExampleRoute());
            PropertiesComponent props = camelContext.getPropertiesComponent();
            props.setLocation("classpath:my-camel.properties");
            camelContext.getRegistry().bind("my-file-filter", new ExampleFileFilter());
            camelContext.start();
            while (true) {
                Thread.sleep(200000);

            }
//            camelContext.stop();
        }

    }
}
