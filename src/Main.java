import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Part one answer: " + getPartOneNumber());
        System.out.println("Part two answer: " + getPartTwoNumber());
    }

    public static int getPartOneNumber() {
        int floor = 0;
        String line = "()())";
        for (int i = 0; i < line.length(); i++ ) {
            String current = "" + (line.charAt (i));
            if (current.equals("(")) {
                floor++;
            } else if (current.equals(")")) {
                floor--;
            }
        }
        return floor;
    }

    public static int getPartTwoNumber() {
        int floor = 0;
        String line = "()())";
        for (int i = 0; i < line.length(); i++ ) {
            String current = "" + (line.charAt (i));
            if (current.equals("(")) {
                floor++;
            } else if (current.equals(")")) {
                floor--;
            }
            if (floor < 0) {
                return i + 1;
            }
        }
        return floor;
    }

//    public static ArrayList<String> getFileData(String fileName) {
//        ArrayList<String> fileData = new ArrayList<String>();
//        try {
//            File f = new File(fileName);
//            Scanner s = new Scanner(f);
//            while (s.hasNextLine()) {
//                String line = s.nextLine();
//                if (!line.equals(""))
//                    fileData.add(line);
//            }
//            return fileData;
//        }
//        catch (FileNotFoundException e) {
//            return fileData;
//        }
//    }
}