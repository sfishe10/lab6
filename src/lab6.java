import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class lab6 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        LinkedHashMap<Integer, Integer> addresses = new LinkedHashMap<>();

        CacheSimulator cache1 = new CacheSimulator(2, 1, 1);
        CacheSimulator cache2 = new CacheSimulator(2, 1, 2);
        CacheSimulator cache3 = new CacheSimulator(2, 1, 4);
        CacheSimulator cache4 = new CacheSimulator(2, 2, 1);
        CacheSimulator cache5 = new CacheSimulator(2, 4, 1);
        CacheSimulator cache6 = new CacheSimulator(2, 4, 4);
        CacheSimulator cache7 = new CacheSimulator(4, 1, 1);

        int linenum = 0;

        Scanner scnr = new Scanner(file);
        while (scnr.hasNext()) {
            String line = scnr.nextLine();
            int address = Integer.decode(line);
            addresses.put(address, linenum);
            linenum++;
        }


    }
}