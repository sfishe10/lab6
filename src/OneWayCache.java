public class OneWayCache implements CacheSimulator {
    private int kb;
    private int words;
    private int hits;

    public OneWayCache (int kb,int words, int hits) {
        this.kb = kb;
        this.words = words;
        this.hits = hits;
    }

    public int getkb() {
        return this.kb;
    }
    public int getAssociativity() {
        return this.associativity;
    }
    public int getWordblocks() {
        return this.wordblocks;
    }
    public int getHits() {
        return this.hits;
    }
}
