package test_data;

import org.codehaus.jackson.annotate.*;

import java.util.HashMap;
import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true)

public class ReqresTestData {
    public Map<String,String> reqresMethodMap(String  name, String job ){
        Map<String,String> reqresMap = new HashMap();


     reqresMap.put("name", name);
     reqresMap.put("job", job);

    return reqresMap;
    }


}
