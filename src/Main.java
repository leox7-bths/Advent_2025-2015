import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;




public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = getFileData("src/data");

        String[][] grid = get2DArray(lines);

        int partOneNumber = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                String e = grid[i][j];
                if (e.equals("@")) {
                    int count = getPartOneNumber(grid, i, j);
                    if (count < 4) {
                        partOneNumber++;
                    }
                }
            }
        }

        System.out.println("Part one answer: " + partOneNumber);

        int partTwoNumber = 0;
        while (true) {
            ArrayList<int[]> toRemove = new ArrayList<>();

            for (int i = 1; i < grid.length - 1; i++) {
                for (int j = 1; j < grid[0].length - 1; j++) {
                    if (grid[i][j].equals("@")) {
                        int count = getPartTwoNumber(grid, i, j);
                        if (count < 4) {
                            toRemove.add(new int[]{i, j});
                        }
                    }
                }
            }

            if (toRemove.isEmpty()) {
                break;
            }
            for (int[] pos : toRemove) {
                grid[pos[0]][pos[1]] = ".";
            }

            partTwoNumber += toRemove.size();
        }


        System.out.println("Part two answer: " + partTwoNumber);
    }



    public static int getPartOneNumber(String[][] grid, int row, int col) {
        int count = 0;
        if (grid[row-1][col].equals("@")) {
            count++;
        }
        if (grid[row+1][col].equals("@")) {
            count++;
        }
        if (grid[row][col-1].equals("@")) {
            count++;
        }
        if (grid[row][col+1].equals("@")) {
            count++;
        }
        if (grid[row-1][col+1].equals("@")) {
            count++;
        }
        if (grid[row-1][col-1].equals("@")) {
            count++;
        }
        if (grid[row+1][col-1].equals("@")) {
            count++;
        }
        if (grid[row+1][col+1].equals("@")) {
            count++;
        }


        return count;
    }



    public static int getPartTwoNumber(String[][] grid, int row, int col) {
        int count = 0;
        if (grid[row-1][col].equals("@")) count++;
        if (grid[row+1][col].equals("@")) count++;
        if (grid[row][col-1].equals("@")) count++;
        if (grid[row][col+1].equals("@")) count++;
        if (grid[row-1][col+1].equals("@")) count++;
        if (grid[row-1][col-1].equals("@")) count++;
        if (grid[row+1][col-1].equals("@")) count++;
        if (grid[row+1][col+1].equals("@")) count++;
            //remove
//            for (int i = 0; i < grid.length; i++) {
//                for (int j = 0; j < grid[i].length; j++) {
//                    System.out.print(grid[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("");
            //remove
        return count;
    }



    public static String[][] get2DArray(ArrayList<String> fileData) {

        String borderRow = "";
        for (int i = 0; i < fileData.get(0).length(); i++) {
            borderRow += ".";
        }

        fileData.add(0, borderRow);
        fileData.add(borderRow);

        for (int i = 0; i < fileData.size(); i++) {
            String s = fileData.get(i);
            s = "." + s + ".";
            fileData.set(i, s);
        }

        int rows = fileData.size();
        int cols = fileData.get(0).length();
        String[][] grid = new String[rows][cols];

        for (int i = 0; i < fileData.size(); i++) {
            String row = fileData.get(i);
            for (int j = 0; j < row.length(); j++) {
                String entry = row.substring(j, j+1);
                grid[i][j] = entry;
            }
        }

        return grid;
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