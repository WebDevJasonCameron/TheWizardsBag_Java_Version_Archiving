package com.gui.javaFXTest;

public class Item {

    // ATTs
    private final String sku;
    private final String descr;
    private final Float price;
    private final Boolean taxable;

    // CONs
    public Item(String sku, String descr, Float price, Boolean taxable) {
        this.sku = sku;
        this.descr = descr;
        this.price = price;
        this.taxable = taxable;
    }

    // GETs
    public String getSku() {
        return sku;
    }

    public String getDescr() {
        return descr;
    }

    public Float getPrice() {
        return price;
    }

    public Boolean getTaxable() {
        return taxable;
    }

    // OVRs
    @Override
    public String toString() {
        return "Item{" +
                "sku='" + sku + '\'' +
                ", descr='" + descr + '\'' +
                ", price=" + price +
                ", taxable=" + taxable +
                '}';
    }
}
