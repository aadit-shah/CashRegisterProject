package cashdesk;

import java.util.ArrayList;
import java.util.List;

/**
 * The Data Holder class
 */
public class DataHolder {
    private List<Data> dataList;
    private int id;

    /**
     * Initialize the DataHolder
     */
    public DataHolder() {
        this.dataList = new ArrayList<>();
        this.id = 0;
    }

    /**
     * Insert a new data entry point
     * @param data The data to insert
     */
    public void insert(Data data) {
        data.actualizeId(this.id);

        this.id += 1;
        this.dataList.add(data);
    }

    /* Getter methods */

    public int getLength() {
        return this.dataList.size();
    }

    public Data getData(int index) {
        return this.dataList.get(index);
    }
}
