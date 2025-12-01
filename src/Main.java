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
        int dial = 50;
        int count = 0;

        for (String line : lines) {
            char dir = line.charAt(0);
            int num = Integer.parseInt(line.substring(1));
            num %= 100;

            if (dir == 'R') {
                dial = (dial + num) % 100;
            } else { // L
                dial = (dial - num + 100) % 100;
            }
            if (dial == 0) {
                count++;
            }
//            System.out.println(dial);
        }
        return count;
    }





    public static int getPartTwoNumber(ArrayList<String> lines) {
        int dial = 50;  // starting position
        int count = 0;

        for (String line : lines) {
            char dir = line.charAt(0);
            int num = Integer.parseInt(line.substring(1));

            int step = (dir == 'R') ? 1 : -1;

            // simulate each click
            for (int i = 0; i < num; i++) {
                dial = (dial + step + 100) % 100;
                if (dial == 0) count++;
            }
//            System.out.println(dial);
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



