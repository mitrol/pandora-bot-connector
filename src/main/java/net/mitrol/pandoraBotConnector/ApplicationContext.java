package net.mitrol.pandoraBotConnector;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
        "net.mitrol.pandoraBotConnector.model",
        "net.mitrol.pandoraBotConnector.service"
})
public class ApplicationContext {

    public ApplicationContext() {
    }
}
