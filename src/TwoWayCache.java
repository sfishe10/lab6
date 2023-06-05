import java.util.HashMap;

public class TwoWayCache implements CacheSimulator {
    private int kb;
    private int words;
    private int hits;
    private int indexbits;

    private HashMap<Integer, Data> data1;

    private HashMap<Integer, Data> data2;

    public TwoWayCache (int kb,int words) {
        this.kb = kb;
        this.words = words;
        this.indexbits = customLog(2, (((kb/2) * (int)Math.pow(2, 10)) / (words*4)));
    }
    private int customLog(int base, int lognum) {
        return (int)(Math.log(lognum)/Math.log(base));
    }

    public int getkb() {
        return this.kb;
    }
    public int getAssociativity() {
        return 2;
    }
    public int getWords() {
        return this.words;
    }
    public int getHits() {
        return this.hits;
    }
    public void accessAddress(int address, int linenum) {
        // see if tag is at calculated index - check both arrays
        // if yes, update hit count
        // if no, replace LRU tag with new tag and linenum
    }
}
