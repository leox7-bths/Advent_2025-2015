import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = getFileData("src/data");

        System.out.println("Part one answer: " + getPartOneNumber(lines));
        System.out.println("Part two answer: " + getPartTwoNumber(lines));
    }


    public static int getPartOneNumber(ArrayList<String> lines) {
        int total = 0;
        int past = 0;
        int current = 0;
        for (int i = 0; i < lines.size(); i++) {
            if (i == 0) {
                current = Integer.parseInt(lines.get(i));
                past = Integer.parseInt(lines.get(i));
            } else {
                current = Integer.parseInt(lines.get(i));
                if (current > past) {
                    total++;
                }
                past = Integer.parseInt(lines.get(i));
            }
        }
        return total;
    }

    public static int getPartTwoNumber(ArrayList<String> lines) {
        int total = 0;
        int first = 0;
        int second = 0;
        int third = 0;
        ArrayList<String> biggerList = new ArrayList<>();
        for (int i = 0; i < lines.size()-2; i++) {
            first = Integer.parseInt(lines.get(i));
            second = Integer.parseInt(lines.get(i+1));
            third = Integer.parseInt(lines.get(i+2));
            total = first + second + third;
            biggerList.add("" + total);
        }
        return getPartOneNumber(biggerList);
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

