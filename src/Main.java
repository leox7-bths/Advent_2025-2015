import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = getFileData("src/data");
        ArrayList<String> ranges = getFileData("src/data2");
        System.out.println("Part one answer: " + getPartOneNumber(lines, ranges));
        System.out.println("Part two answer: " + getPartTwoNumber(lines, ranges));
    }



    public static int getPartOneNumber(ArrayList<String> lines, ArrayList<String> ranges) {
        int count = 0;
        long first = 0;
        long second = 0;

        for (String line : lines) {
            long id = Long.parseLong(line);
            boolean isFresh = false;
            for (String range : ranges) {
                String[] rangenum = range.split("-");
                first = Long.parseLong(rangenum[0]);
                second = Long.parseLong(rangenum[1]);

                if (id >= first && id <= second) {
                    isFresh = true;
                    break;
                }
            }
            if (isFresh) {
                count++;
            }
        }
        return count;
    }




    public static long getPartTwoNumber(ArrayList<String> lines, ArrayList<String> ranges) {
        ArrayList<long[]> list = new ArrayList<>();

        for (String range : ranges) {
            if (range.trim().isEmpty()) continue;
            String[] r = range.split("-");
            long first = Long.parseLong(r[0].trim());
            long second = Long.parseLong(r[1].trim());
            list.add(new long[]{ first, second });
        }

        if (list.isEmpty()) return 0;

        list.sort((a, b) -> Long.compare(a[0], b[0]));

        ArrayList<long[]> merged = new ArrayList<>();
        long start = list.get(0)[0];
        long end = list.get(0)[1];

        for (int i = 1; i < list.size(); i++) {
            long s = list.get(i)[0];
            long e = list.get(i)[1];

            if (s <= end + 1) {
                if (e > end) end = e;
            } else {
                merged.add(new long[]{ start, end });
                start = s;
                end = e;
            }
        }
        merged.add(new long[]{ start, end });

        long count = 0;
        for (long[] m : merged) {
            count += (m[1] - m[0] + 1);
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