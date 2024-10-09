package {{ root_package }}.integration.tests;

import org.junit.jupiter.api.Test;
import {{ root_package }}.grpc.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class {{ ProjectPrefix }}{{ ProjectSuffix }}GrpcTest extends {{ ProjectPrefix }}{{ ProjectSuffix }}BaseIT {

    @Test
    void test_create{{ ProjectPrefix }}() {
        {{ ProjectPrefix }}AssessmentResponse response = client.assess{{ ProjectPrefix }}({{ ProjectPrefix }}AssessmentRequest.newBuilder().setUserId("ID").build());
        assertThat(response.get{{ ProjectPrefix }}Level()).isEqualTo({{ ProjectPrefix }}Level.{{ PROJECT_PREFIX }}_MEDIUM);
    }
}