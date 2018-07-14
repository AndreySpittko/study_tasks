package exchangeService.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
    //постав правильну лінку папку куди зберігати файл
    private static final String FILE_NAME = "/Users/ivan/Documents/projects/Andrii/src/main/resources/exchange_rate.txt";

    public void write(String string){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            bw.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
