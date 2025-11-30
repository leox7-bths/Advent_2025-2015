import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    static Map<String, String> instructions = new HashMap<>();
    static Map<String, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        ArrayList<String> lines = getFileData("src/data");
        System.out.println("Part one answer: " + getPartOneNumber(lines));
        int partOne = getPartOneNumber(lines);
        System.out.println("Part two answer: " + getPartTwoNumber(lines, partOne));
    }


    public static int getPartOneNumber(ArrayList<String> lines) {
        instructions.clear();
        cache.clear();
        for (String l : lines) {
            String[] parts = l.split(" -> ");
            instructions.put(parts[1], parts[0]);
        }
        return getSignal("a");
    }

    private static int getSignal(String wire) {
        if (wire.matches("\\d+")) return Integer.parseInt(wire);
        if (cache.containsKey(wire)) return cache.get(wire);
        String expr = instructions.get(wire);
        int result;
        if (expr.contains("AND")) {
            String[] parts = expr.split(" AND ");
            result = getSignal(parts[0]) & getSignal(parts[1]);
        } else if (expr.contains("OR")) {
            String[] parts = expr.split(" OR ");
            result = getSignal(parts[0]) | getSignal(parts[1]);
        } else if (expr.contains("LSHIFT")) {
            String[] parts = expr.split(" LSHIFT ");
            result = (getSignal(parts[0]) << Integer.parseInt(parts[1])) & 0xFFFF;
        } else if (expr.contains("RSHIFT")) {
            String[] parts = expr.split(" RSHIFT ");
            result = getSignal(parts[0]) >>> Integer.parseInt(parts[1]);
        } else if (expr.startsWith("NOT")) {
            String operand = expr.substring(4);
            result = ~getSignal(operand) & 0xFFFF;
        } else {
            result = getSignal(expr);
        }
        cache.put(wire, result);
        return result;
    }


    public static int getPartTwoNumber(ArrayList<String> lines, int overrideB) {
        instructions.clear();
        cache.clear();
        for (String l : lines) {
            String[] parts = l.split(" -> ");
            instructions.put(parts[1], parts[0]);
        }
        instructions.put("b", String.valueOf(overrideB));
        cache.clear();
        return getSignal("a");
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

