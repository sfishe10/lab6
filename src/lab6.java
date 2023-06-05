import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class lab6 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        LinkedHashMap<Integer, Integer> addresses = new LinkedHashMap<>();
        CacheSimulator cache[] = new CacheSimulator[7];
        int index = 0;
        int tag = 0;
        int count = 1;
        int hit_rate = 0;
        int size = 0;


//        CacheSimulator cache1 = new CacheSimulator(2, 1, 1, 0);
//        CacheSimulator cache2 = new CacheSimulator(2, 1, 2, 0);
//        CacheSimulator cache3 = new CacheSimulator(2, 1, 4, 0);
//        CacheSimulator cache4 = new CacheSimulator(2, 2, 1, 0);
//        CacheSimulator cache5 = new CacheSimulator(2, 4, 1, 0);
//        CacheSimulator cache6 = new CacheSimulator(2, 4, 4, 0);
//        CacheSimulator cache7 = new CacheSimulator(4, 1, 1, 0);

//        cache[0] = cache1;
//        cache[1] = cache2;
//        cache[2] = cache3;
//        cache[3] = cache4;
//        cache[4] = cache5;
//        cache[5] = cache6;
//        cache[6] = cache7;





        // LOGIC
        // read in address
        // calculate tag and index
        // create block w/ tag, put in array at index
        // for every address, calculate index and see if current tag at index matches new tag
            // if tags match, count as a hit, otherwise miss

        int linenum = 0;

        Scanner scnr = new Scanner(file);
        while (scnr.hasNext()) {
            String line = scnr.nextLine();
            int address = Integer.parseInt(line, 16);
            addresses.put(address, linenum);
            linenum++;

            //cache 1
           // index = address % 4;
            tag = address >>>11;

        }

        //Printing out
        for (CacheSimulator item: cache) {
            hit_rate = item.getHits()/linenum;
            size = item.getkb()*1024;
            System.out.println("Cache #" + count);
            System.out.println("Cache size: " + size + "B" + "     Associativity: " + item.getAssociativity()+ "     Block size: " + item.getWords());
            System.out.println("Hits: " + item.getHits() + "     Hit Rate: " + hit_rate + "%");
            System.out.println("----------------------------");
            count++;
        }





    }
}