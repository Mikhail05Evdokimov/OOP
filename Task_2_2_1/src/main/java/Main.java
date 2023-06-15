import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        FileReader reader = new FileReader("input.json");
        JSONParser jsonParser = new JSONParser();
        JSONObject pizza = (JSONObject) jsonParser.parse(reader);
        new Pizzeria(Integer.parseInt(pizza.get("Storage capacity").toString()));

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

        Scanner in = new Scanner(System.in);
        while (true) {
            if(in.hasNextLine()) {
                String orderName = in.next();
                if(Objects.equals(orderName, "stop") || Objects.equals(orderName, "STOP")) {
                    break;
                }
                Pizzeria.newOrder(orderName, Integer.parseInt(in.next()));
            }
        }

        for (Cook i : cookers) {
            i.goHome = true;
        }

        for (Delivery i : delivers) {
            i.goHome = true;
            i.interrupt();
        }

        System.out.println("CLOSED");
    }
}
