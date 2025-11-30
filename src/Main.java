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


    public static int getPartOneNumber(ArrayList<String> line) {
        boolean[][] grid = new boolean[1000][1000];
        for (String lines : line) {
            String[] parts = lines.split(" ");
            if (parts.length == 4) {
                String first = parts[1];
                String second = parts[3];
                String[] cord1 = first.split(",");
                String cord11 = cord1[0];
                String cord12 = cord1[1];
                String[] cord2 = second.split(",");
                String cord21 = cord2[0];
                String cord22 = cord2[1];
                for (int x = Integer.parseInt(cord11); x <= Integer.parseInt(cord21); x++) {
                    for (int y = Integer.parseInt(cord12); y <= Integer.parseInt(cord22); y++) {
                        if (grid[x][y]) {
//                            System.out.println(x + "," + y);
                            grid[x][y] = false;
                        } else {
//                            System.out.println(x + "," + y);
                            grid[x][y] = true;
                        }
                    }
                }
            } else {
                String onOff = parts[1];
                String first = parts[2];
                String second = parts[4];
                String[] cord1 = first.split(",");
                String cord11 = cord1[0];
                String cord12 = cord1[1];
                String[] cord2 = second.split(",");
                String cord21 = cord2[0];
                String cord22 = cord2[1];
//                System.out.println(onOff);
//                System.out.println(first);
//                System.out.println(second);
//                System.out.println(cord11);
//                System.out.println(cord12);
//                System.out.println(cord21);
//                System.out.println(cord22);

                for (int x = Integer.parseInt(cord11); x <= Integer.parseInt(cord21); x++) {
                    for (int y = Integer.parseInt(cord12); y <= Integer.parseInt(cord22); y++) {
                        if (onOff.equals("on")) {
//                            System.out.println(x + "," + y);
                            grid[x][y] = true;
                        } else {
//                            System.out.println(x + "," + y);
                            grid[x][y] = false;
                        }
                    }
                }
            }
        }

        int count = 0;
        for (int a = 0; a < 1000; a++) {
            for (int b = 0; b < 1000; b++) {
                if (grid[a][b] == true) {
                    count++;
                }
            }
        }

        return count;
    }


    public static int getPartTwoNumber(ArrayList<String> line) {
        int[][] grid = new int[1000][1000];
        for (String lines : line) {
            String[] parts = lines.split(" ");
            if (parts.length == 4) {
                String first = parts[1];
                String second = parts[3];
                String[] cord1 = first.split(",");
                String cord11 = cord1[0];
                String cord12 = cord1[1];
                String[] cord2 = second.split(",");
                String cord21 = cord2[0];
                String cord22 = cord2[1];
                for (int x = Integer.parseInt(cord11); x <= Integer.parseInt(cord21); x++) {
                    for (int y = Integer.parseInt(cord12); y <= Integer.parseInt(cord22); y++) {
                        grid[x][y] += 2;
                    }
                }
            } else {
                String onOff = parts[1];
                String first = parts[2];
                String second = parts[4];
                String[] cord1 = first.split(",");
                String cord11 = cord1[0];
                String cord12 = cord1[1];
                String[] cord2 = second.split(",");
                String cord21 = cord2[0];
                String cord22 = cord2[1];
//                System.out.println(onOff);
//                System.out.println(first);
//                System.out.println(second);
//                System.out.println(cord11);
//                System.out.println(cord12);
//                System.out.println(cord21);
//                System.out.println(cord22);

                for (int x = Integer.parseInt(cord11); x <= Integer.parseInt(cord21); x++) {
                    for (int y = Integer.parseInt(cord12); y <= Integer.parseInt(cord22); y++) {
                        if (onOff.equals("on")) {
//                            System.out.println(x + "," + y);
                            grid[x][y]++;
                        } else {
//                            System.out.println(x + "," + y);
                            if (grid[x][y] != 0) {
                                grid[x][y]--;
                            }
                        }
                    }
                }
            }
        }

        int count = 0;
        for (int a = 0; a < 1000; a++) {
            for (int b = 0; b < 1000; b++) {
                count += grid[a][b];
            }
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

