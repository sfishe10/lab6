public class Data {
    private int tag;
    private int linenum;

    public Data(int tag, int linenum) {
        this.tag = tag;
        this.linenum = linenum;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null | o.getClass() != this.getClass()) {
            return false;
        }
        return (tag == ((Data)o).tag);
    }

    public int getTag() { return tag; }
    public int getLinenum() { return linenum; }

}
