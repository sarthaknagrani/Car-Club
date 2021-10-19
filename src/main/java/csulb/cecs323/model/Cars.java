package csulb.cecs323.model;

/**
 * Individual, physical automobiles that someone can drive on land to transport
 * one or more passengers and a limited amount of cargo around. Cars have four
 * wheels and usually travel on paved roads.
 */
public class Cars {
    /** The Owner variable for Styling */
    private String Owner;
    /** The ReturnAutoBodyStyle variable for Styling. Limited to 30 */
    private String AutoBodyStyle;
    /** The unique ID of the vehicle. Limited to 17 characters. */
    private String VIN;

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getAutoBodyStyle() {
        return AutoBodyStyle;
    }

    public void setAutoBodyStyle(String autoBodyStyle) {
        AutoBodyStyle = autoBodyStyle;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String vIN) {
        VIN = vIN;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Cars() {
    }

    public Cars(String vin, String owner, String model) {
        this.VIN = vin;
        this.model = model;
        this.Owner = owner;
    }

    /**
     * The name of the corporation which manufactured the vehicle. Limited to 40
     * characters.
     */
    private String manufacturer;

    /**
     * The popular name of the vehicle, like the Prius for Toyota. Limited to 20
     * characters.
     */
    private String model;

    /**
     * The year that the vehicle was manufactured. For now, do not worry about
     * validating this #.
     */
    private int year;

    @Override
    public String toString() {
        return "Cars - VIN: " + this.getVIN() + " Model: " + this.getModel() + "AutoBody Style: "
                + this.getAutoBodyStyle() + " Who is Owner: " + this.getOwner();
    }
}
