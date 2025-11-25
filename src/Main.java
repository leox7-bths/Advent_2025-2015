import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = getFileData("src/data");

        System.out.println("Part one answer: " + getPartOneNumber(lines));
        System.out.println("Part two answer: " + getPartTwoNumber(lines));
    }


    public static int getPartOneNumber(ArrayList<String> lines) {
        Set<String> visited = new HashSet<>();

        int x = 0;
        int y = 0;
        visited.add(x + "," + y);

        for (String line : lines) {
            for (char move : line.toCharArray()) {
                switch (move) {
                    case '^': y++; break;
                    case 'v': y--; break;
                    case '<': x--; break;
                    case '>': x++; break;
                }
                visited.add(x + "," + y);
            }
        }

        return visited.size();
    }

    public static int getPartTwoNumber(ArrayList<String> lines) {
        Set<String> visited = new HashSet<>();
//        Set<String> visited2 = new HashSet<>();

        int x = 0;
        int y = 0;
        int x2 = 0;
        int y2 = 0;
        visited.add(x + "," + y);


        for (String line : lines) {
            for (int i = 0; i < line.length(); i++) {
                if (i % 2 == 0) {
                    char move = line.charAt(i);
                    switch (move) {
                        case '^': y++; break;
                        case 'v': y--; break;
                        case '<': x--; break;
                        case '>': x++; break;
                    }
                    visited.add(x + "," + y);
                } else {
                    char move = line.charAt(i);
                    switch (move) {
                        case '^': y2++; break;
                        case 'v': y2--; break;
                        case '<': x2--; break;
                        case '>': x2++; break;
                    }
                    visited.add(x2 + "," + y2);
                }
            }
        }


        return visited.size();
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

