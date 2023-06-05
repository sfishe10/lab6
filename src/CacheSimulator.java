public interface CacheSimulator {

    int kb = 0;
    int wordblocks = 0;
    int hits = 0;



    int getkb();
    int getAssociativity();
    int getWords();
    int getHits();

    void accessAddress(int address, int linenum);


}
