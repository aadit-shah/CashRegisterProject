package cashdesk;

/**
 * The Data class, it can hold anything you want in your History View
 */
public class Data {

    /* This is the data, you can adapt it to your needs */
    private int id;
    private float value;
    private String time;
    private String payMethod;

    /**
     * Create data
     * @param id Set the id or -1 if it should actualized
     * @param value The value of the purchase (float)
     * @param time The time of the purchase
     * @param payMethod The pay method
     */
    public Data(int id, float value, String time, String payMethod) {
        this.id = id;
        this.value = value;
        this.time = time;
        this.payMethod = payMethod;
    }

    /* Getter methods */

    public int getId() {
        return this.id;
    }

    public float getValue() {
        return this.value;
    }

    public String getTime() {
        return this.time;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    /**
     * Get the amount of Data Parameters
     * @return the amount of Data Parameters
     */
    public static int getWidth() {
        /* Get the amount of data */
        return 4;
    }

    /**
     * Get the Data Parameters as String array
     * @return A string with the parameters
     */
    public static String[] getIndexes() {
        return new String[]{"ID", "Value", "Time", "Pay Method"};
    }

    /**
     * Get the data As a String array with the size from getWidth()
     * @return The data as a String array
     */
    public String[] toStringArray() {
        return new String[]{ Integer.toString(this.id), Float.toString(this.value), this.time, this.payMethod };
    }

    /**
     * Actualise the id
     * @param newId The new id this should be set to
     * @return True if successful
     */
    public boolean actualizeId(int newId) {
        /* If id was set to -1 then it can be updated */
        if (this.id == -1) {
            this.id = newId;
            return true;
        }

        return false;
    }
}
