package {{ root_package }}.integration.tests;

import org.junit.jupiter.api.Test;
import {{ root_package }}.grpc.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class {{ ProjectPrefix }}{{ ProjectSuffix }}GrpcTest extends {{ ProjectPrefix }}{{ ProjectSuffix }}BaseIT {

    @Test
    void test_assess{{ ProjectPrefix }}_LowRisk() {
        {{ ProjectPrefix }}AssessmentResponse response = client.assess{{ ProjectPrefix }}({{ ProjectPrefix }}AssessmentRequest.newBuilder().setAttempts(2).build());
        assertThat(response.get{{ ProjectPrefix }}Level()).isEqualTo({{ ProjectPrefix }}Level.{{ PROJECT_PREFIX }}_LOW);
    }

    @Test
    void test_assess{{ ProjectPrefix }}_MediumRisk() {
        {{ ProjectPrefix }}AssessmentResponse response = client.assess{{ ProjectPrefix }}({{ ProjectPrefix }}AssessmentRequest.newBuilder().setAttempts(15).build());
        assertThat(response.get{{ ProjectPrefix }}Level()).isEqualTo({{ ProjectPrefix }}Level.{{ PROJECT_PREFIX }}_MEDIUM);
    }

    @Test
    void test_assess{{ ProjectPrefix }}_HighRisk() {
        {{ ProjectPrefix }}AssessmentResponse response = client.assess{{ ProjectPrefix }}({{ ProjectPrefix }}AssessmentRequest.newBuilder().setAttempts(100).build());
        assertThat(response.get{{ ProjectPrefix }}Level()).isEqualTo({{ ProjectPrefix }}Level.{{ PROJECT_PREFIX }}_HIGH);
    }
}