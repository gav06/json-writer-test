import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        JSONObject obj2 = new JSONObject();
        Example exampleObj = new Example("Gavin", 69, true);
        Example exampleObj2 = new Example("Joe", 48, false);

        // adding first object to array
        obj.put("name", exampleObj.getName());
        obj.put("number", exampleObj.getNumber());
        obj.put("isCool", exampleObj.isCool());

        // adding second object to array
        obj2.put("name", exampleObj2.getName());
        obj2.put("number", exampleObj2.getNumber());
        obj2.put("isCool", exampleObj2.getNumber());

        JSONArray objList = new JSONArray();
        objList.add(obj);
        objList.add(obj2);

        // write file
        try (FileWriter writer = new FileWriter("test.json")) {
            writer.write(objList.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Json shit saved");

        System.out.println("reloading json shit");

        JSONParser parser = new JSONParser();
        JSONArray readList;

        // i googled some of this because i have no clue how the simple json library works
        try (FileReader reader = new FileReader("test.json")) {
            Object readObj = parser.parse(reader);

            readList = (JSONArray) readObj;



            System.out.println(readList);

            //readList.forEach(o -> parseShit((JSONObject) o));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }
}
