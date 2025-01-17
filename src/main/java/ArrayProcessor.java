import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArrayProcessor {

    public static List<Integer> readFromFile(String filename) throws IOException {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            String[] numbers = line.split(",");
            for (String num : numbers) {
                list.add(Integer.parseInt(num.trim()));
            }
        }
        return list;
    }

    public static void writeToFile(String filename, List<Integer> list) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i).toString());
                if (i < list.size() - 1) {
                    writer.write(", ");
                }
            }
        }
    }

    public static void reverse(List<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n / 2; i++) {
            int temp = list.get(i);
            list.set(i, list.get(n - 1 - i));
            list.set(n - 1 - i, temp);
        }
    }
}
