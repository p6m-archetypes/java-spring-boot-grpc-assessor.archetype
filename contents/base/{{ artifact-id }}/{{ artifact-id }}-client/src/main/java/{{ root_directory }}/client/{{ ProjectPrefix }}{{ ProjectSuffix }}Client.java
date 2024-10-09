package {{ root_package }}.client;

import io.grpc.ManagedChannelBuilder;
import {{ root_package }}.api.{{ ProjectPrefix }}{{ ProjectSuffix }};
import {{ root_package }}.grpc.*;

public class {{ ProjectPrefix }}{{ ProjectSuffix }}Client implements {{ ProjectPrefix }}{{ ProjectSuffix }} {
    {{ ProjectPrefix }}{{ ProjectSuffix }}Grpc.{{ ProjectPrefix }}{{ ProjectSuffix }}BlockingStub stub;

    public static {{ ProjectPrefix }}{{ ProjectSuffix }}Client of(String host, int port) {
        return new {{ ProjectPrefix }}{{ ProjectSuffix }}Client(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
    }

    private {{ ProjectPrefix }}{{ ProjectSuffix }}Client(ManagedChannelBuilder<?> channelBuilder) {
        this.stub = {{ ProjectPrefix }}{{ ProjectSuffix }}Grpc.newBlockingStub(channelBuilder.build());
    }

    @Override
    public {{ ProjectPrefix }}AssessmentResponse assess{{ ProjectPrefix }}({{ ProjectPrefix }}AssessmentRequest assessmentRequest) {
        return stub.assess{{ ProjectPrefix }}(assessmentRequest);
    }
}
