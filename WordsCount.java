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
            for (String s : l) {
                li += s + " ";
            }

            String[] list = li.split(" ");
            Map<String, Integer> wordsCount = new HashMap<>();
            ArrayList<String> words = new ArrayList<>(Arrays.asList(list));

            for (String tempStr : words) {
                if (!wordsCount.containsKey(tempStr)) {
                    wordsCount.put(tempStr, 1);
                } else {
                    wordsCount.put(tempStr, wordsCount.get(tempStr) + 1);
                }
            }
            
            wordsCount.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
