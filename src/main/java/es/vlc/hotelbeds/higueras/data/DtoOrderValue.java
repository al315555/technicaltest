package es.vlc.hotelbeds.higueras.data;

public enum DtoOrderValue {

    V1000(3, 1000),
    V2000(7, 2000),
    V5000(15, 5000),
    V7500(19, 7500),
    V10000(25, 10000);

    private double dto;
    private int pricelimit;

    private DtoOrderValue(final double dto, final int priceLimit){
        this.dto = dto;
        this.pricelimit = priceLimit;
    }

    public double getDto() {
        return dto;
    }

    public void setDto(double dto) {
        this.dto = dto;
    }

    public int getPricelimit() {
        return pricelimit;
    }

    public void setPricelimit(int pricelimit) {
        this.pricelimit = pricelimit;
    }
}
