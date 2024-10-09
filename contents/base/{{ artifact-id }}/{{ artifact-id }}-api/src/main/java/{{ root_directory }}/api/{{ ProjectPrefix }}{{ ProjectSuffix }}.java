package {{ root_package }}.api;

import {{ root_package }}.grpc.*;

import java.util.Iterator;

public interface {{ ProjectPrefix }}{{ ProjectSuffix }} {
    {{ ProjectPrefix }}AssessmentResponse assess{{ ProjectPrefix }}({{ ProjectPrefix }}AssessmentRequest assessmentRequest);
}
