import java.io.File;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.math.BigInteger;




public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = getFileData("src/data");
        System.out.println("Part one answer: " + getPartOneNumber(lines));
        System.out.println("Part two answer: " + getPartTwoNumber(lines));
    }




    public static int getPartOneNumber(ArrayList<String> lines) {
        int nice = 0;

        for (String line : lines) {
            int nicesub = 0;
            int vowelCount = 0;
            for (char c : line.toCharArray()) {
                if ("aeiou".indexOf(c) >= 0) {
                    vowelCount++;
                }
            }
            if (vowelCount >= 3) {
                nicesub++;
            }

            boolean hasDouble = false;
            for (int i = 1; i < line.length(); i++) {
                if (line.charAt(i) == line.charAt(i - 1)) {
                    hasDouble = true;
                    break;
                }
            }
            if (hasDouble) {
                nicesub++;
            }

            if (!(line.contains("ab") || line.contains("cd") ||
                    line.contains("pq") || line.contains("xy"))) {
                nicesub++;
            }

            if (nicesub == 3) {
                nice++;
            }
        }
        return nice;
    }



    public static int getPartTwoNumber(ArrayList<String> lines) {
        int nice = 0;

        for (String line : lines) {
            boolean hasRepeatedPair = false;
            boolean hasSandwich = false;

            // Rule 1: repeated pair without overlapping
            for (int i = 0; i < line.length() - 1; i++) {
                String pair = line.substring(i, i + 2);

                // Look for same pair later in string (i + 2 prevents overlap)
                if (line.indexOf(pair, i + 2) != -1) {
                    hasRepeatedPair = true;
                    break;
                }
            }

            // Rule 2: x_y pattern ("sandwich")
            for (int i = 0; i < line.length() - 2; i++) {
                if (line.charAt(i) == line.charAt(i + 2)) {
                    hasSandwich = true;
                    break;
                }
            }

            if (hasRepeatedPair && hasSandwich) {
                nice++;
            }
        }

        return nice;
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



