import java.io.*;

public class PhoneNumbers {
    private static  final File FILE_PATH = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "file1.txt");

    public static void validPhoneNumbers() {
        try(FileInputStream fileInputStream = new FileInputStream(FILE_PATH.getAbsolutePath())) {
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            String strings = "";

            for (byte b : buffer) {
                strings += (char) b;
            }

            String[] list = strings.split(System.lineSeparator());
            for (int i = 0; i < list.length; i++) {
                if (!(list[i].matches("^\\d{3}-\\d{3}-\\d{4}") || list[i].matches("^\\(\\d{3}\\)\\s\\d{3}-\\d{4}"))) {
                    list[i] = null;
                }
            }
            for (String s : list) {
                if (s != null) {
                    System.out.println(s);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
