import java.util.HashMap;

public class OneWayCache implements CacheSimulator {
    private int kb;
    private int words;
    private int hits;
    private HashMap<Integer, Data> data;
    private int indexbits;
    private int tagbits;
    private int blockoffset;
    private int indexmask = 1;

    public OneWayCache (int kb, int words) {
        this.kb = kb;
        this.words = words;
        this.indexbits = customLog(2, ((kb * (int)Math.pow(2, 10)) / (words*4)));
        this.blockoffset = customLog(2, (words*4));
        this.tagbits = 32-indexbits-blockoffset-2;

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
        return 1;
    }
    public int getWords() {
        return this.words;
    }
    public int getHits() {
        return this.hits;
    }
    public void accessAddress(int address, int linenum) {
        // see if tag is at calculated index
            // if yes, update hit count
        // replace current tag with new tag and linenum (if tag is the same, it will just update linenum)

        int index = (address >> (2+blockoffset)) & indexmask;
        int tag = address >> (2+blockoffset+indexbits);

        if (data.get(index).getTag() == tag) {
            hits++;
        }
        data.put(index, new Data(tag, linenum));

    }
}
