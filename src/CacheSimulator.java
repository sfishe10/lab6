public class CacheSimulator {

    private int kb;
    private int association;
    private int wordblocks;

    public CacheSimulator (int kb, int association, int wordblocks) {
        this.kb = kb;
        // if association = 1, cache is direct mapped, otherwise set associative
        this.association = association;
        this.wordblocks = wordblocks;
    }
}
