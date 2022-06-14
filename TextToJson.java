import com.google.gson.*;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.*;

public class TextToJson {
    private static final String INPUT_FILE_PATH = "C:\\Users\\Yevhen\\IdeaProjects\\goit-java-hw-10\\src\\main\\resources\\file2.txt";
    private static final String OUTPUT_FILE_PATH = "C:\\Users\\Yevhen\\IdeaProjects\\goit-java-hw-10\\src\\main\\resources\\user.json";

    public static void convert() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            int c;
            String strings = "";

            while ((c = bufferedReader.read()) != -1) {
                strings += (char) c;
            }
            String[] l = strings.split("\r\n");
            String li = "";

            for (int i = 1; i < l.length; i++) {
                li += l[i] + " ";
            }
            String[] list = li.split(" ");
            ArrayList<User> userList = new ArrayList<>();

            for (int i = 0; i < list.length; i = i + 2) {
                userList.add(new User(list[i], Integer.parseInt(list[i + 1])));
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String[] user = new String[userList.size()];
            for (int i = 0; i < userList.size(); i++) {
                user[i] = gson.toJson(userList.get(i));
            }

            bufferedWriter.write(Arrays.toString(user));
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}