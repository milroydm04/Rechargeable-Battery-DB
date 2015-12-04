package model;

import java.io.Serializable;

/**
 *
 * @author Dylan Lozo
 */
public class Batt implements Serializable {

    private String Manufacturer;
    private String dateBought;
    private String numberMarriedto;
    private String ampLimits;
    private int batteryType;

    public Batt() {
    }

    public Batt(String bookName, String bookAuthor, String bookSection, 
            String iSBN, int copyrightYear) {
        this.Manufacturer = bookName;
        this.dateBought = bookAuthor;
        this.numberMarriedto = bookSection;
        this.ampLimits = iSBN;
        this.batteryType = copyrightYear;
    }

    public String inHTMLRowFormat() {
        return "<tr><td>" + Manufacturer + "</td>"
                + "<td>" + dateBought + "</td>"
                + "<td>" + numberMarriedto + "</td>"
                + "<td>" + ampLimits + "</td>"
                + "<td>" + batteryType + "</td></tr>\n";
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String Manufacturer) {
        this.Manufacturer = Manufacturer;
    }

    public String getDateBought() {
        return dateBought;
    }

    public void setDateBought(String dateBought) {
        this.dateBought = dateBought;
    }

    public String getNumberMarriedto() {
        return numberMarriedto;
    }

    public void setNumberMarriedto(String numberMarriedto) {
        this.numberMarriedto = numberMarriedto;
    }

    public String getAmpLimits() {
        return ampLimits;
    }

    public void setAmpLimits(String ampLimits) {
        this.ampLimits = ampLimits;
    }

    public int getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(int batteryType) {
        this.batteryType = batteryType;
    }

    @Override
    public String toString() {
        return "Book{" + "bookName=" + Manufacturer + ", bookAuthor=" + dateBought 
                + ", bookSection=" + numberMarriedto + ", ISBN=" 
                + ampLimits + ", Copyright Year=" + batteryType + '}';
    }

    
}
