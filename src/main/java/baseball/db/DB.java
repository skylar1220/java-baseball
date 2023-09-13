package baseball.db;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.DateFormatter;

public class DB {
    private static DB instance;
    private List<Data> database = new ArrayList<>();

    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }

    public void addData(Data data) {
        database.add(data);
    }

    public void showAllData() {
        for ( Data data : database ) {
            System.out.println(data);
        }
    }
}
