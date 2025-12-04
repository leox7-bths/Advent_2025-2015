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
        int total = 0;

        for (String line: lines) {
            char[] chars = line.toCharArray();
            ArrayList<Integer> digits = new ArrayList<>();
            for (char ch : chars) {
                if (Character.isDigit(ch)) digits.add(ch - '0');
            }

            int best = 0;
            for (int i = 0; i < digits.size(); i++) {
                for (int j = i + 1; j < digits.size(); j++) {
                    int val = digits.get(i) * 10 + digits.get(j);
                    if (val > best) best = val;
                }
            }

            System.out.println(best);
            total += best;
        }

        return total;
    }



    public static long getPartTwoNumber(ArrayList<String> lines) {
        long total = 0;

        for (String line: lines) {
            char[] chars = line.toCharArray();
            ArrayList<Integer> digits = new ArrayList<>();
            for (char ch : chars) {
                if (Character.isDigit(ch)) digits.add(ch - '0');
            }

            int n = digits.size();
            int toPick = 12;
            StringBuilder result = new StringBuilder();
            int start = 0;

            while (toPick > 0) {
                int maxDigit = -1;
                int maxIndex = start;
                for (int i = start; i <= n - toPick; i++) {
                    if (digits.get(i) > maxDigit) {
                        maxDigit = digits.get(i);
                        maxIndex = i;
                    }
                }
                result.append(maxDigit);
                start = maxIndex + 1;
                toPick--;
            }

            System.out.println(result.toString());
            total += Long.parseLong(result.toString());
        }

        return total;
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
