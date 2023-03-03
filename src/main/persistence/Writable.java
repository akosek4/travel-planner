package persistence;

import org.json.JSONObject;
//Code is based on JsonSerializationDemo
// Represents an interface that returns objects as JSON objects

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
