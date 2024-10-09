package {{ root_package }}.server.grpc;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import {{ root_package }}.core.{{ ProjectPrefix }}{{ ProjectSuffix }}Core;
import {{ root_package }}.grpc.*;
import {{ root_package }}.grpc.{{ ProjectPrefix }}{{ ProjectSuffix }}Grpc.{{ ProjectPrefix }}{{ ProjectSuffix }}ImplBase;

@GRpcService
public class {{ ProjectPrefix }}{{ ProjectSuffix }}GrpcImpl extends {{ ProjectPrefix }}{{ ProjectSuffix }}ImplBase {

    private final {{ ProjectPrefix }}{{ ProjectSuffix }}Core service;

    public {{ ProjectPrefix }}{{ ProjectSuffix }}GrpcImpl({{ ProjectPrefix }}{{ ProjectSuffix }}Core service) {
        this.service = service;
    }

    @Override
    public void assess{{ ProjectPrefix }}({{ ProjectPrefix }}AssessmentRequest request, StreamObserver<{{ ProjectPrefix }}AssessmentResponse> responseObserver) {
        {{ ProjectPrefix }}AssessmentResponse {{ ProjectPrefix }}Response = service.assess{{ ProjectPrefix }}(request);
        responseObserver.onNext({{ ProjectPrefix }}Response);
        responseObserver.onCompleted();
    }
}