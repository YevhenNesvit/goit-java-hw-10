import java.io.*;
import java.util.*;

public class WordsCount {
    private static final File FILE_PATH = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "words.txt");

    public static void count() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH.getAbsolutePath()))) {
            int c;
            String strings = "";

            while ((c = bufferedReader.read()) != -1) {
                strings += (char) c;
            }

            String[] l = strings.split(System.lineSeparator());
            String li = "";
            for (int i = 0; i < l.length; i++) {
                li += l[i] + " ";
            }

            String[] list = li.split(" ");
            Map<String, Integer> wordsCount = new HashMap<>();
            ArrayList<String> words = new ArrayList<>(Arrays.asList(list));

            for (int i = 0; i < words.size(); i++) {
                String tempStr = words.get(i);

                if (!wordsCount.containsKey(tempStr)) {
                    wordsCount.put(tempStr, 1);
                } else {
                    wordsCount.put(tempStr, wordsCount.get(tempStr) + 1);
                }
            }

            for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
