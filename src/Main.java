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


        HashMap<String, Integer> map = new HashMap<>();


        map.put("a", 0);
        map.put("b", 0);
        map.put("c", 0);
        map.put("d", 0);


        int temp = 0;
        int jnz = 0;
        int i = 0;


        while (i < lines.size()) {
            String line = lines.get(i);
            String[] parts = line.split(" ");
            String op = parts[0];

            switch (op) {
                case "cpy": {
                    String x = parts[1];
                    String y = parts[2];
                    int value;

                    if (map.containsKey(x)) {
                        value = map.get(x);
                    } else {
                        value = Integer.parseInt(x);
                    }

                    map.put(y, value);
                    i++;
                    break;
                }

                case "inc": {
                    String r = parts[1];
                    map.put(r, map.get(r) + 1);
                    i++;
                    break;
                }

                case "dec": {
                    String r = parts[1];
                    map.put(r, map.get(r) - 1);
                    i++;
                    break;
                }

                case "jnz": {
                    String x = parts[1];
                    String y = parts[2];

                    int value = map.containsKey(x) ? map.get(x) : Integer.parseInt(x);
                    int offset = map.containsKey(y) ? map.get(y) : Integer.parseInt(y);

                    if (value != 0) {
                        i += offset;
                    } else {
                        i++;
                    }
                    break;
                }

                default:
                    i++;
            }
        }
        return map.get("a");
    }


    public static int getPartTwoNumber(ArrayList<String> lines) {


        HashMap<String, Integer> map = new HashMap<>();


        map.put("a", 0);
        map.put("b", 0);
        map.put("c", 1);
        map.put("d", 0);


        int temp = 0;
        int jnz = 0;
        int i = 0;


        while (i < lines.size()) {
            String line = lines.get(i);
            String[] parts = line.split(" ");
            String op = parts[0];

            switch (op) {
                case "cpy": {
                    String x = parts[1];
                    String y = parts[2];
                    int value;

                    if (map.containsKey(x)) {
                        value = map.get(x);
                    } else {
                        value = Integer.parseInt(x);
                    }

                    map.put(y, value);
                    i++;
                    break;
                }

                case "inc": {
                    String r = parts[1];
                    map.put(r, map.get(r) + 1);
                    i++;
                    break;
                }

                case "dec": {
                    String r = parts[1];
                    map.put(r, map.get(r) - 1);
                    i++;
                    break;
                }

                case "jnz": {
                    String x = parts[1];
                    String y = parts[2];

                    int value = map.containsKey(x) ? map.get(x) : Integer.parseInt(x);
                    int offset = map.containsKey(y) ? map.get(y) : Integer.parseInt(y);

                    if (value != 0) {
                        i += offset;
                    } else {
                        i++;
                    }
                    break;
                }

                default:
                    i++;
            }
        }
        return map.get("a");
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

