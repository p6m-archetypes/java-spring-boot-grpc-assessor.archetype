package {{ root_package }}.integration.tests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import {{ root_package }}.client.{{ ProjectPrefix }}{{ ProjectSuffix }}Client;
import {{ root_package }}.integration.tests.config.IntegrationTestsConfig;
import {{ root_package }}.server.{{ ProjectPrefix }}{{ ProjectSuffix }}Server;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { IntegrationTestsConfig.class })
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class {{ ProjectPrefix }}{{ ProjectSuffix }}BaseIT {
    @Autowired
    protected {{ ProjectPrefix }}{{ ProjectSuffix }}Server server;

    @Autowired
    protected {{ ProjectPrefix }}{{ ProjectSuffix }}Client client;
}