import java.io.IOException;
import java.util.List;

public class ConsoleApp {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Использование: java ConsoleApp <input file> <output file>");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        try {
            List<Integer> list = ArrayProcessor.readFromFile(inputFile);
            ArrayProcessor.reverse(list);
            ArrayProcessor.writeToFile(outputFile, list);
            System.out.println("Обработка завершена. Результат записан в " + outputFile);
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
