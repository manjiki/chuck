package chuck;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by manji on 5/26/16. test commit this is new comment 
 */

@JsonIgnoreProperties(ignoreUnknown = true)

public class Chuck {

    private String type;
    private CValue value;

    public Chuck() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CValue getValue() {
        return value;
    }

    public void setValue(CValue value) {
        this.value = value;
    }
}
