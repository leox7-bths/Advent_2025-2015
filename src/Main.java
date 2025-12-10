import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = getFileData("src/data");
        System.out.println("Part one answer: " + getPartOneNumber(lines));
        System.out.println("Part two answer: " + getPartTwoNumber(lines));
    }

    public static long getPartOneNumber(ArrayList<String> lines) {
        long sum = 0;
        Pattern p = Pattern.compile("-?\\d+");
        for (String line : lines) {
            Matcher m = p.matcher(line);
            while (m.find()) sum += Long.parseLong(m.group());
        }
        return sum;
    }

    public static long getPartTwoNumber(ArrayList<String> lines) {
        return 0;
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals("")) fileData.add(line);
            }
            return fileData;
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
