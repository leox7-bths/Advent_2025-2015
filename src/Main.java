import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;






public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = getFileData("src/data");
        System.out.println("Part one answer: " + getPartOneNumber("3113322113", 40));
        System.out.println("Part two answer: " + getPartTwoNumber("3113322113", 50));
    }



    public static int getPartOneNumber(String line, int countnum) {
        for (int count = 0; count < countnum; count++) {
            StringBuilder next = new StringBuilder();
            int i = 0;
            while (i < line.length()) {
                char current = line.charAt(i);
                int runLength = 1;
                while (i + 1 < line.length() && line.charAt(i + 1) == current) {
                    i++;
                    runLength++;
                }
                next.append(runLength).append(current);
                i++;
//                System.out.println(line);
            }
            line = next.toString();
        }
        return line.length();
    }



    public static int getPartTwoNumber(String line, int countnum) {
        for (int count = 0; count < countnum; count++) {
            StringBuilder next = new StringBuilder();
            int i = 0;
            while (i < line.length()) {
                char current = line.charAt(i);
                int runLength = 1;
                while (i + 1 < line.length() && line.charAt(i + 1) == current) {
                    i++;
                    runLength++;
                }
                next.append(runLength).append(current);
                i++;
//                System.out.println(line);
            }
            line = next.toString();
        }
        return line.length();
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
