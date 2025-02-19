package org.example;
import org.json.JSONArray;
import org.json.JSONObject;
public class JsonStudent {
    public static void main(String[] args) {
        JSONArray subjects = new JSONArray();
        subjects.put("Physics");
        subjects.put("Chemistry");
        subjects.put("Mathematics");
        JSONObject user = new JSONObject();
        user.put("name", "Alice");
        user.put("age", 25);
        user.put("subjects", subjects);
        System.out.println(user.toString());
    }
}
