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
        int maxDistance = 0;
        int totalTime = 2503;
        for (String line : lines) {
            String[] parts = line.split(" ");
            int speed = Integer.parseInt(parts[3]);
            int flyTime = Integer.parseInt(parts[6]);
            int restTime = Integer.parseInt(parts[13]);

            int cycle = flyTime + restTime;
            int fullCycles = totalTime / cycle;
            int remainder = totalTime % cycle;
            int distance = fullCycles * flyTime * speed + Math.min(remainder, flyTime) * speed;

            if (distance > maxDistance) maxDistance = distance;
        }
        return maxDistance;
    }

    public static int getPartTwoNumber(ArrayList<String> lines) {
        int totalTime = 2503;
        int n = lines.size();
        int[] speed = new int[n];
        int[] flyTime = new int[n];
        int[] restTime = new int[n];
        int[] state = new int[n]; // 0=flying, 1=resting
        int[] timeLeft = new int[n];
        int[] distance = new int[n];
        int[] points = new int[n];

        for (int i = 0; i < n; i++) {
            String[] parts = lines.get(i).split(" ");
            speed[i] = Integer.parseInt(parts[3]);
            flyTime[i] = Integer.parseInt(parts[6]);
            restTime[i] = Integer.parseInt(parts[13]);
            state[i] = 0;
            timeLeft[i] = flyTime[i];
            distance[i] = 0;
            points[i] = 0;
        }

        for (int t = 0; t < totalTime; t++) {
            for (int i = 0; i < n; i++) {
                if (state[i] == 0) distance[i] += speed[i];
                timeLeft[i]--;
                if (timeLeft[i] == 0) {
                    if (state[i] == 0) {
                        state[i] = 1;
                        timeLeft[i] = restTime[i];
                    } else {
                        state[i] = 0;
                        timeLeft[i] = flyTime[i];
                    }
                }
            }
            int maxDist = 0;
            for (int d : distance) if (d > maxDist) maxDist = d;
            for (int i = 0; i < n; i++) if (distance[i] == maxDist) points[i]++;
        }

        int maxPoints = 0;
        for (int p : points) if (p > maxPoints) maxPoints = p;
        return maxPoints;
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
