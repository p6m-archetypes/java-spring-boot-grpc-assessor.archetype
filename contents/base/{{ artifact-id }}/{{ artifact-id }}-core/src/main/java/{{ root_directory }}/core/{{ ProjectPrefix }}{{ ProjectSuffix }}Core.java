package {{ root_package }}.core;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import {{ root_package }}.api.{{ ProjectPrefix }}Assessor;
import {{ root_package }}.core.model.{{ ProjectPrefix }}Assessment;
import {{ root_package }}.core.model.{{ ProjectPrefix }}Model;
import {{ root_package }}.grpc.{{ ProjectPrefix }}AssessmentRequest;
import {{ root_package }}.grpc.{{ ProjectPrefix }}AssessmentResponse;
import {{ root_package }}.grpc.{{ ProjectPrefix }}Level;

public class {{ ProjectPrefix }}AssessorCore implements {{ ProjectPrefix }}Assessor {

    private final KieContainer kieContainer;

    public {{ ProjectPrefix }}AssessorCore(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    @Override
    public {{ ProjectPrefix }}AssessmentResponse assess{{ ProjectPrefix }}({{ ProjectPrefix }}AssessmentRequest assessmentRequest) {
        {{ ProjectPrefix }}Model {{ projectPrefix }}Model = new {{ ProjectPrefix }}Model(15); // Look up required data
        {{ ProjectPrefix }}Assessment {{ projectPrefix }}Assessment = new {{ ProjectPrefix }}Assessment({{ ProjectPrefix }}Level.{{ PROJECT_PREFIX }}_LOW);
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("{{ ProjectPrefix }}Assessment", {{ projectPrefix }}Assessment);
        kieSession.insert({{ projectPrefix }}Model);
        kieSession.fireAllRules();
        kieSession.dispose();
        return {{ ProjectPrefix }}AssessmentResponse.newBuilder().set{{ ProjectPrefix }}Level({{ projectPrefix }}Assessment.getLevel()).build();
    }
}
