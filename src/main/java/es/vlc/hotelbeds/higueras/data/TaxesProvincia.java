package es.vlc.hotelbeds.higueras.data;

public enum TaxesProvincia {
    BAL("Baleares", TaxesProvincia.PROVINCIA_CODE_BAL, 0.183),
    CAN("Canarias", TaxesProvincia.PROVINCIA_CODE_CAN, 0.047),
    CYM("Ceuta y Melilla", TaxesProvincia.PROVINCIA_CODE_CYM, 0.081),
    TER("Teruel", TaxesProvincia.PROVINCIA_CODE_TER, 0.005),
    RES("Resto", TaxesProvincia.PROVINCIA_CODE_RES, 0.215);

    public static final String PROVINCIA_CODE_TER = "TER";
    public static final String PROVINCIA_CODE_RES = "RES";
    public static final String PROVINCIA_CODE_CYM = "CYM";
    public static final String PROVINCIA_CODE_CAN = "CAN";
    public static final String PROVINCIA_CODE_BAL = "BAL";

    private String descTax;
    private String code;
    private double taxValue;

    TaxesProvincia(final String descTax, final String code, final double taxValue ) {
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
