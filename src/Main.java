import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = getFileData("src/data");
        System.out.println("Part one answer: " + getPartOneNumber(lines));
        System.out.println("Part two answer: " + getPartTwoNumber(lines));
    }

    public static long getPartOneNumber(ArrayList<String> lines) {
        Map<String, Map<String, Integer>> distances = parseDistances(lines);
        Set<String> cities = distances.keySet();
        ArrayList<String> cityList = new ArrayList<>(cities);
        return permuteAndFindDistance(cityList, distances, true);
    }

    public static long getPartTwoNumber(ArrayList<String> lines) {
        Map<String, Map<String, Integer>> distances = parseDistances(lines);
        Set<String> cities = distances.keySet();
        ArrayList<String> cityList = new ArrayList<>(cities);
        return permuteAndFindDistance(cityList, distances, false);
    }

    public static Map<String, Map<String, Integer>> parseDistances(ArrayList<String> lines) {
        Map<String, Map<String, Integer>> distances = new HashMap<>();
        for (String line : lines) {
            String[] parts = line.split(" ");
            String from = parts[0];
            String to = parts[2];
            int distance = Integer.parseInt(parts[4]);
            distances.putIfAbsent(from, new HashMap<>());
            distances.putIfAbsent(to, new HashMap<>());
            distances.get(from).put(to, distance);
            distances.get(to).put(from, distance);
        }
        return distances;
    }

    public static long permuteAndFindDistance(ArrayList<String> cities, Map<String, Map<String, Integer>> distances, boolean findShortest) {
        return permuteHelper(cities, 0, distances, findShortest, findShortest ? Long.MAX_VALUE : Long.MIN_VALUE);
    }

    public static long permuteHelper(ArrayList<String> cities, int start, Map<String, Map<String, Integer>> distances, boolean findShortest, long bestDistance) {
        if (start == cities.size() - 1) {
            long totalDistance = 0;
            for (int i = 0; i < cities.size() - 1; i++) {
                totalDistance += distances.get(cities.get(i)).get(cities.get(i + 1));
            }
            return findShortest ? Math.min(bestDistance, totalDistance) : Math.max(bestDistance, totalDistance);
        }
        for (int i = start; i < cities.size(); i++) {
            swap(cities, start, i);
            bestDistance = permuteHelper(cities, start + 1, distances, findShortest, bestDistance);
            swap(cities, start, i);
        }
        return bestDistance;
    }

    public static void swap(ArrayList<String> list, int i, int j) {
        String temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            s.close();
        } catch (FileNotFoundException e) {}
        return fileData;
    }
}
