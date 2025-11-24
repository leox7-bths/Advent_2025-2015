import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = getFileData("src/data");

        int partOneAnswer = 0;
        int partTwoAnswer = 0;
        for (int i = 0; i < lines.size(); i++) {
            partOneAnswer += getPartOneNumber(lines.get(i));
            partTwoAnswer += getPartTwoNumber(lines.get(i));
        }

        System.out.println("Part one answer: " + partOneAnswer);
        System.out.println("Part two answer: " + partTwoAnswer);
    }

    public static int getPartOneNumber(String line) {
        String first = "";
        String second = "";
        int finalnum = 0;
        for (int i = 0; i < line.length(); i++ ) {
            char current = line.charAt(i);
            if (Character.isDigit(current)) {
                first = Character.toString(current);
                //System.out.println(current);
                break;
            }
        }
        for (int i = line.length()-1; i >= 0; i-- ) {
            char current = line.charAt(i);
            if (Character.isDigit(current)) {
                second = Character.toString(current);
                //System.out.println(current);
                break;
            }
        }
        for (int i = 0; i < first.length(); i++) {
            char Str1 = first.charAt(i);
            char Str2 = second.charAt(i);
            //System.out.println(list);
            finalnum += Integer.parseInt(String.valueOf(Str1) + String.valueOf(Str2));
        }
        return finalnum;


    }

    public static int getPartTwoNumber(String line) {
        String first = "";
        String second = "";
        int finalnum = 0;


        for (int i = 0; i < line.length(); i++ ) {
            char current = line.charAt(i);
            if (Character.isDigit(current)) {
                first = Character.toString(current);
                //System.out.println(current);
                break;
            }

            boolean found = line.contains("one") || line.contains("two") || line.contains("three") || line.contains("four") || line.contains("five") || line.contains("six") || line.contains("seven") || line.contains("eight") || line.contains("nine");
            if (found) {
                
            }
        }

        for (int i = line.length()-1; i >= 0; i-- ) {
            char current = line.charAt(i);
            if (Character.isDigit(current)) {
                second = Character.toString(current);
                //System.out.println(current);
                break;
            }
        }
        for (int i = 0; i < first.length(); i++) {
            char Str1 = first.charAt(i);
            char Str2 = second.charAt(i);
            //System.out.println(list);
            finalnum += Integer.parseInt(String.valueOf(Str1) + String.valueOf(Str2));
        }
        return finalnum;
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