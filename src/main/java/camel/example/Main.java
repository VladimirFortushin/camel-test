package camel.example;

import camel.example.route.ChoiceExampleRoute;
import jakarta.jms.ConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.qpid.jms.JmsConnectionFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        try(CamelContext camelContext = new DefaultCamelContext()){
            camelContext.addRoutes(new ChoiceExampleRoute());
            JmsComponent jms = camelContext.getComponent("jms", JmsComponent.class);
            jms.setConnectionFactory(createConnectionFactory());
            camelContext.start();
            while (true) {
                Thread.sleep(200000);

            }
//            camelContext.stop();
        }
    }

    private static ConnectionFactory createConnectionFactory() {
        JmsConnectionFactory jmsConnectionFactory = new JmsConnectionFactory("amqp://localhost:61616");
        jmsConnectionFactory.setUsername("artemis");
        jmsConnectionFactory.setPassword("artemis");
        return jmsConnectionFactory;
    }
}