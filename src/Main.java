import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = getFileData("src/data");
        System.out.println("Part one answer: " + getPartOneNumber(lines));
        System.out.println("Part two answer: " + getPartTwoNumber(lines));
    }


    public static int getPartOneNumber(ArrayList<String> lines) {
        int count = 0;
        for (String line : lines) {
            int letter = 0;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == '"') continue;
                if (c == '\\') {
                    i++;
                    if (i < line.length()) {
                        char next = line.charAt(i);
                        if (next == 'x') {
                            i += 2;
                        }
                    }
                }
                letter++;
            }
            count += line.length() - letter;
        }
        return count;
    }


        public static int getPartTwoNumber(ArrayList<String> lines) {
            int count = 0;
            for (String line : lines) {
                String newString = line;
                newString = newString.replace("\\", "\\\\");
                newString = newString.replace("\"", "\\\"");
                newString = "\"" + newString + "\"";

                count += newString.length() - line.length();
            }
            return count;
    }




    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}

