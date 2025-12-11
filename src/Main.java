import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = getFileData("src/data");
        System.out.println("Part one answer: " + getPartOneNumber(lines));
        System.out.println("Part two answer: " + getPartTwoNumber(lines));
    }

    //2147397120
    public static long getPartOneNumber(ArrayList<String> lines) {
        ArrayList<long[]> tiles = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(",");
            long x = Long.parseLong(parts[0]);
            long y = Long.parseLong(parts[1]);
            tiles.add(new long[]{x, y});
        }

        long maxArea = 0;

        for (int i = 0; i < tiles.size(); i++) {
            for (int j = i + 1; j < tiles.size(); j++) {
                long[] t1 = tiles.get(i);
                long[] t2 = tiles.get(j);

                long width = Math.abs(t1[0] - t2[0]) + 1;
                long height = Math.abs(t1[1] - t2[1]) + 1;

                long area = width * height;
                if (area > maxArea) maxArea = area;
            }
        }

        return maxArea;
    }

    public static int getPartTwoNumber(ArrayList<String> lines) {
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