package {{root_package}}.integration.tests.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import {{root_package}}.client.{{ ProjectPrefix }}{{ ProjectSuffix }}Client;
import {{root_package}}.server.{{ ProjectPrefix }}{{ ProjectSuffix }}Server;

@Configuration
public class IntegrationTestsConfig {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public {{ ProjectPrefix }}{{ ProjectSuffix }}Server {{ projectPrefix }}{{ ProjectSuffix }}Server() {
         return new {{ ProjectPrefix }}{{ ProjectSuffix }}Server()
                .withRandomPorts()
                .withTempDb();
    }

    @Bean
    public {{ ProjectPrefix }}{{ ProjectSuffix }}Client {{ projectPrefix }}{{ ProjectSuffix }}Client({{ ProjectPrefix }}{{ ProjectSuffix }}Server server) {
        return {{ ProjectPrefix }}{{ ProjectSuffix }}Client.of("localhost", server.getGrpcPort());
    }
}
