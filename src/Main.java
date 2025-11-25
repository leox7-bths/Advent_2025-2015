import java.io.File;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.math.BigInteger;


public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = getFileData("src/data");
        System.out.println("Part one answer: " + getPartOneNumber("bgvyzdsv"));
        System.out.println("Part two answer: " + getPartTwoNumber("bgvyzdsv"));
    }


    public static int getPartOneNumber(String key) {
        int answer = 0;
        boolean yes = false;
        while (!yes) {
            String input = getMd5(key + answer);
//            System.out.println(answer);
            yes = input.startsWith("00000");
            answer++;
        }
        return answer - 1;
    }

    public static int getPartTwoNumber(String key) {
        int answer = 0;
        boolean yes = false;
        while (!yes) {
            String input = getMd5(key + answer);
//            System.out.println(answer);
            yes = input.startsWith("000000");
            answer++;
        }
        return answer - 1;
    }

    public static String getMd5(String input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
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

