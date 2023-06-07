public interface CacheSimulator {
    int getkb();
    int getAssociativity();
    int getWords();
    int getHits();

    void accessAddress(int address, int linenum);


}
