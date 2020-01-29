package es.vlc.hotelbeds.higueras.data;

public enum TaxesProvincia {
    BAL("Baleares", "BAL", 18.3),
    CAN("Canarias", "CAN", 4.7),
    CYM("Ceuta y Melilla", "CYM", 8.1),
    TER("Teruel", "TER", 0.5),
    RES("Resto", "RES", 21.5);

    private String descTax;
    private String code;
    private double taxValue;

    private TaxesProvincia(final String descTax, final String code, final double taxValue ) {
        this.code = code;
        this.descTax = descTax;
        this.taxValue = taxValue;
    }

    public String getDescTax() {
        return descTax;
    }

    public void setDescTax(String descTax) {
        this.descTax = descTax;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(double taxValue) {
        this.taxValue = taxValue;
    }
}
