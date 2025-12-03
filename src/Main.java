import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;




public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = getFileData("src/data");
        System.out.println("Part one answer: " + getPartOneNumber("2558912-2663749,1-19,72-85,82984-100358,86-113,193276-237687,51-69,779543-880789,13004-15184,2768-3285,4002-4783,7702278-7841488,7025-8936,5858546565-5858614010,5117615-5149981,4919-5802,411-466,126397-148071,726807-764287,7454079517-7454227234,48548-61680,67606500-67729214,9096-10574,9999972289-10000034826,431250-455032,907442-983179,528410-680303,99990245-100008960,266408-302255,146086945-146212652,9231222-9271517,32295166-32343823,32138-36484,4747426142-4747537765,525-652,333117-414840,13413537-13521859,1626-1972,49829276-50002273,69302-80371,8764571787-8764598967,5552410836-5552545325,660-782,859-1056"));
        System.out.println("Part two answer: " + getPartTwoNumber("2558912-2663749,1-19,72-85,82984-100358,86-113,193276-237687,51-69,779543-880789,13004-15184,2768-3285,4002-4783,7702278-7841488,7025-8936,5858546565-5858614010,5117615-5149981,4919-5802,411-466,126397-148071,726807-764287,7454079517-7454227234,48548-61680,67606500-67729214,9096-10574,9999972289-10000034826,431250-455032,907442-983179,528410-680303,99990245-100008960,266408-302255,146086945-146212652,9231222-9271517,32295166-32343823,32138-36484,4747426142-4747537765,525-652,333117-414840,13413537-13521859,1626-1972,49829276-50002273,69302-80371,8764571787-8764598967,5552410836-5552545325,660-782,859-1056"));
    }



    public static long getPartOneNumber(String lines) {
        long count = 0;
        String[] productsID = lines.split(",");
        for (int i = 0; i < productsID.length; i++ ) {
            String[] num = productsID[i].split("-");
//            System.out.println(productsID[i]);
            long a = Long.parseLong(num[0]);
            long b = Long.parseLong(num[1]);
            for (long j = a; j < b+1; j++) {
                long current = j;
                String why = String.valueOf(current);
//                System.out.println(why);
//                System.out.println(why.length());
                if (why.length()%2 == 0) {
                    String part1 = why.substring(0, why.length()/2);
                    long valid = Long.parseLong(part1 + part1);
                    if (valid == current) {
                        count += valid;
//                        System.out.println(valid);
                    }


                }
            }
        }
        return count;
    }



    public static long getPartTwoNumber(String lines) {
        long sum = 0;

        String[] ranges = lines.split(",");
        for (String r : ranges) {
            String[] parts = r.split("-");

            long start = Long.parseLong(parts[0]);
            long end   = Long.parseLong(parts[1]);

            for (long id = start; id <= end; id++) {
                String s = Long.toString(id);
                int len = s.length();
                boolean invalid = false;

                // Try every possible pattern length
                for (int pat = 1; pat <= len / 2; pat++) {

                    // length must divide evenly
                    if (len % pat != 0) continue;

                    // pattern must repeat at least 2 times
                    int repeats = len / pat;
                    if (repeats < 2) continue;

                    String sub = s.substring(0, pat);

                    // Build repeated version
                    StringBuilder test = new StringBuilder();
                    for (int t = 0; t < repeats; t++) {
                        test.append(sub);
                    }

                    if (test.toString().equals(s)) {
                        invalid = true;
                        break;
                    }
                }

                if (invalid) {
                    sum += id;
                }
            }
        }

        return sum;
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
