import java.util.HashMap;

public class FourWayCache implements CacheSimulator {
    private int kb;
    private int words;
    private int hits;
    private int indexbits;

    private HashMap<Integer, Data> data1;
    private HashMap<Integer, Data> data2;
    private HashMap<Integer, Data> data3;
    private HashMap<Integer, Data> data4;



    public FourWayCache (int kb,int words) {
        this.kb = kb;
        this.words = words;
        this.indexbits = customLog(2, (((kb/4) * (int)Math.pow(2, 10)) / (words*4)));
    }

    private int customLog(int base, int lognum) {
        return (int)(Math.log(lognum)/Math.log(base));
    }

    public int getkb() {
        return this.kb;
    }
    public int getAssociativity() {
        return 4;
    }
    public int getWords() {
        return this.words;
    }
    public int getHits() {
        return this.hits;
    }
    public void accessAddress(int address, int linenum) {
        // see if tag is at calculated index - check all 4 arrays
        // if yes, update hit count
        // if no, replace LRU tag (one with lowest linenum) with new tag and linenum
    }

}
