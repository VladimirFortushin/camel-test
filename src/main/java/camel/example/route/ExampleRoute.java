package camel.example.route;

import org.apache.camel.builder.RouteBuilder;

public class ExampleRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:src/main/resources/files?noop={{my.camel.property.noop}}&filter=#my-file-filter")
                .routeId("exampleRoute")
                .log("File contents: ${body}")
                .setProperty("destination", simple("${body}"))
                .toD("file:src/main/resources/files/output/${exchangeProperty.destination}?fileName=RAW(&file.txt)");
    }
}
