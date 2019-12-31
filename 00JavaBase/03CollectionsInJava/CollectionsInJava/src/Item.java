public class Item implements Comparable<Item> {
    private int index;

    public Item(int index)
    {
        this.index=index;
    }

    @Override
    public int compareTo(Item other) {
        if(other==null){
            return 1;
        }

        if(this==other||this.index==other.index){
            return 0;
        }

        return Integer.compare(this.index, other.index);
    }

    @Override
    public int hashCode() {
        return index;
    }

    @Override
    public boolean equals(Object obj) {

        if(!(obj instanceof Item)) return false;
        return compareTo((Item) obj)==0;
    }
}
