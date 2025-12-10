import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = getFileData("src/data");
        System.out.println("Part one answer: " + getPartOneNumber(lines));
        System.out.println("Part two answer: " + getPartTwoNumber(lines));
    }

    public static int getPartOneNumber(ArrayList<String> lines) {
        int n = lines.size();
        int[] cap = new int[n];
        int[] dur = new int[n];
        int[] fla = new int[n];
        int[] tex = new int[n];

        for (int i = 0; i < n; i++) {
            String line = lines.get(i);
            line = line.replaceAll("[:,]", "");
            String[] parts = line.split(" ");
            cap[i] = Integer.parseInt(parts[2]);
            dur[i] = Integer.parseInt(parts[4]);
            fla[i] = Integer.parseInt(parts[6]);
            tex[i] = Integer.parseInt(parts[8]);
        }

        int maxScore = 0;
        for (int a = 0; a <= 100; a++) {
            for (int b = 0; b <= 100 - a; b++) {
                for (int c = 0; c <= 100 - a - b; c++) {
                    int d = 100 - a - b - c;
                    int capSum = Math.max(0, a*cap[0] + b*cap[1] + c*cap[2] + d*cap[3]);
                    int durSum = Math.max(0, a*dur[0] + b*dur[1] + c*dur[2] + d*dur[3]);
                    int flaSum = Math.max(0, a*fla[0] + b*fla[1] + c*fla[2] + d*fla[3]);
                    int texSum = Math.max(0, a*tex[0] + b*tex[1] + c*tex[2] + d*tex[3]);
                    int score = capSum * durSum * flaSum * texSum;
                    if (score > maxScore) maxScore = score;
                }
            }
        }

        return maxScore;
    }

    public static int getPartTwoNumber(ArrayList<String> lines) {
        int n = lines.size();
        int[] cap = new int[n];
        int[] dur = new int[n];
        int[] fla = new int[n];
        int[] tex = new int[n];
        int[] cal = new int[n];

        for (int i = 0; i < n; i++) {
            String line = lines.get(i);
            line = line.replaceAll("[:,]", "");
            String[] parts = line.split(" ");
            cap[i] = Integer.parseInt(parts[2]);
            dur[i] = Integer.parseInt(parts[4]);
            fla[i] = Integer.parseInt(parts[6]);
            tex[i] = Integer.parseInt(parts[8]);
            cal[i] = Integer.parseInt(parts[10]);
        }

        int maxScore = 0;
        for (int a = 0; a <= 100; a++) {
            for (int b = 0; b <= 100 - a; b++) {
                for (int c = 0; c <= 100 - a - b; c++) {
                    int d = 100 - a - b - c;
                    int capSum = Math.max(0, a*cap[0] + b*cap[1] + c*cap[2] + d*cap[3]);
                    int durSum = Math.max(0, a*dur[0] + b*dur[1] + c*dur[2] + d*dur[3]);
                    int flaSum = Math.max(0, a*fla[0] + b*fla[1] + c*fla[2] + d*fla[3]);
                    int texSum = Math.max(0, a*tex[0] + b*tex[1] + c*tex[2] + d*tex[3]);
                    int calSum = a*cal[0] + b*cal[1] + c*cal[2] + d*cal[3];
                    if (calSum == 500) {
                        int score = capSum * durSum * flaSum * texSum;
                        if (score > maxScore) maxScore = score;
                    }
                }
            }
        }

        return maxScore;
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
