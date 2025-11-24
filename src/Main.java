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

        for (String line : lines) {
            String[] parts = line.split("x");

            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            int c = Integer.parseInt(parts[2]);

            total += getArea(a, b, c);
        }
        return total;
    }

    public static int getPartTwoNumber(ArrayList<String> lines) {
        int total = 0;

        for (String line : lines) {
            String[] parts = line.split("x");

            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            int c = Integer.parseInt(parts[2]);
            total += getRibbon(a, b, c);
        }

        return total;
    }

    public static int getArea(int len, int wid, int hei) {
        int area1 = len * wid;
        int area2 = wid * hei;
        int area3 = len * hei;

        int extra = Math.min(area1, Math.min(area2, area3));

        return 2 * area1 + 2 * area2 + 2 * area3 + extra;
    }

    public static int getRibbon(int len, int wid, int hei) {
        int[] sides = {len, wid, hei};
        Arrays.sort(sides);

        int area1 = 2 * sides[0] + 2 * sides[1];
        int area2 = len * wid * hei;

        return area1 + area2;
    }


    public static int getPartTwoNumber() {
        return 0;
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

