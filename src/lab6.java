import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class lab6 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        CacheSimulator[] cache = new CacheSimulator[7];

        CacheSimulator cache1 = new OneWayCache(2, 1);
        CacheSimulator cache2 = new OneWayCache(2, 2);
        CacheSimulator cache3 = new OneWayCache(2, 4);
        CacheSimulator cache4 = new TwoWayCache(2, 1);
        CacheSimulator cache5 = new FourWayCache(2, 1);
        CacheSimulator cache6 = new FourWayCache(2,4);
        CacheSimulator cache7 = new OneWayCache(4, 1);

        cache[0] = cache1;
        cache[1] = cache2;
        cache[2] = cache3;
        cache[3] = cache4;
        cache[4] = cache5;
        cache[5] = cache6;
        cache[6] = cache7;

        int linenum = 0;

        Scanner scnr = new Scanner(file);
        while (scnr.hasNext()) {
            String line = scnr.nextLine();
            int address = Integer.parseInt(line, 16);
            for (CacheSimulator c : cache) {
                c.accessAddress(address, linenum);
            }
            linenum++;

        }

        //Printing out
        int count = 1;
        for (CacheSimulator item: cache) {
            DecimalFormat df = new DecimalFormat("0.00");
            String hit_rate = df.format(((float)item.getHits()/(float)linenum)*100);
            int size = item.getkb()*1024;
            System.out.println("Cache #" + count);
            System.out.println("Cache size: " + size + "B" + "     Associativity: " + item.getAssociativity()+ "     Block size: " + item.getWords());
            System.out.println("Hits: " + item.getHits() + "     Hit Rate: " + hit_rate + "%");
            System.out.println("----------------------------");
            count++;
        }

    }
}