public class CacheSimulator {

    private int kb;
    private int association;
    private int wordblocks;
    private int hits;


    public CacheSimulator (int kb, int association, int wordblocks, int hits) {
        this.kb = kb;
        // if association = 1, cache is direct mapped, otherwise set associative
        this.association = association;
        this.wordblocks = wordblocks;
        this.hits = hits;
    }
    public int getkb() {
        return this.kb;
    }
    public int getAssociation() {
        return this.association;
    }
    public int getWordblocks() {
        return this.wordblocks;
    }
    public int getHits() {
        return this.hits;
    }
}
