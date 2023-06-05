public interface CacheSimulator {

    int kb = 0;
    int associativity = 0;
    int wordblocks = 0;
    int hits = 0;



    int getkb();
    int getAssociativity();
    int getWordblocks();
    int getHits();

    void storeAddress(int address, int linenum);


}
