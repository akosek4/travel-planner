package persistence;

import org.json.JSONObject;
//Code is based on JsonSerializationDemo

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
