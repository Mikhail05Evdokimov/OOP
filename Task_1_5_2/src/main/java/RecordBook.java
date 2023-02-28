import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;

public class RecordBook {
    public final File file;

    public RecordBook(String fileName) {
        file = new File(fileName);
    }

    public void add(String name, String value) throws IOException {
        Record newRecord = new Record();
        newRecord.name = name;
        newRecord.value = value;
        Writer writer = new FileWriter(file);
        Gson gson = new Gson();
        gson.toJson(newRecord, writer);
        writer.flush();
    }

    public static void main(String[] args) throws IOException {
        RecordBook book = new RecordBook("./MyFile.json");
        book.add("Моя заметка", "Содержимое заметки");

    }
}
