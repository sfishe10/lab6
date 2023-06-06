import java.util.HashMap;

public class TwoWayCache implements CacheSimulator {
    private int kb;
    private int words;
    private int hits;
    private int indexbits;
    private int blockoffset;
    private int indexmask = 1;

    private HashMap<Integer, Data> data1 = new HashMap<>();

    private HashMap<Integer, Data> data2 = new HashMap<>();

    public TwoWayCache (int kb,int words) {
        this.kb = kb;
        this.words = words;
        this.indexbits = customLog(2, (((kb/2) * (int)Math.pow(2, 10)) / (words*4)));
        this.blockoffset = customLog(2, words);

        int i = 0;
        while (i < indexbits) {
            indexmask = indexmask | (1 << i);
            i++;
        }
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
        int index = (address >> (2+blockoffset)) & indexmask;
        int tag = address >> (2+blockoffset+indexbits);


        if ((data1.get(index) != null && data1.get(index).getTag() == tag)) {
            hits++;
            data1.put(index, new Data(tag, linenum));
        }
        else if ((data2.get(index) != null && data2.get(index).getTag() == tag)) {
            hits++;
            data2.put(index, new Data(tag, linenum));
        }
        else if (data1.get(index) == null) {
            data1.put(index, new Data(tag, linenum));
        }
        else if (data2.get(index) == null) {
            data2.put(index, new Data(tag, linenum));
        }
        else {
            if (data1.get(index).getLinenum() < data2.get(index).getLinenum()) {
                data1.put(index, new Data(tag, linenum));
            }
            else {
                data2.put(index, new Data(tag, linenum));
            }
        }
    }
}
