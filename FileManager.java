import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "employee_data.txt";

    public static void saveEmployee(Employee emp) throws IOException {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(emp.toFileString() + "\n");
        }
    }

    public static ArrayList<String> loadEmployees() throws IOException {
        ArrayList<String> list = new ArrayList<>();

        File file = new File(FILE_NAME);
        if (!file.exists()) {
            file.createNewFile();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        }
        return list;
    }
}
