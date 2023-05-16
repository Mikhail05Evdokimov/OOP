import org.json.simple.* ;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        FileReader reader = new FileReader("input.json");
        JSONParser jsonParser = new JSONParser();
        JSONObject pizza = (JSONObject) jsonParser.parse(reader);
        new Pizzeria(Integer.parseInt(pizza.get("Storage capacity").toString()));
//        var cookNum = Integer.parseInt(pizza.get("Cookers number").toString());
//        var delNum = Integer.parseInt(pizza.get("Delivers number").toString());

        JSONArray cookList = (JSONArray) pizza.get("CookStaff");
        JSONArray delList = (JSONArray) pizza.get("DeliverStaff");
        Iterator cookItr = cookList.iterator();
        Iterator delItr = delList.iterator();

        List<Cook> cookers = new ArrayList<>();
        List<Delivery> delivers = new ArrayList<>();

        while (cookItr.hasNext()) {
            JSONObject o = (JSONObject) cookItr.next();
            cookers.add(new Cook(Integer.parseInt(o.get("WorkTime").toString()), o.get("Name").toString()));
        }

        while (delItr.hasNext()) {
            JSONObject o = (JSONObject) delItr.next();
            delivers.add(new Delivery(Integer.parseInt(o.get("BagSize").toString()), Integer.parseInt(o.get("Speed").toString()), o.get("Name").toString()));
        }

        for (Cook i : cookers) {
            i.start();
        }

        for (Delivery i : delivers) {
            i.start();
        }

        Pizzeria.newOrder("1", 1000);
        Pizzeria.newOrder("2", 600);
        Pizzeria.newOrder("3", 400);
        Pizzeria.newOrder("4", 200);
        Pizzeria.newOrder("5", 300);
        Pizzeria.newOrder("last", 500);
        //while (true) {


        //} //подумать над аккуратным завершением
    }
}
