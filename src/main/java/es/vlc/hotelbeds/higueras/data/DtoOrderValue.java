package es.vlc.hotelbeds.higueras.data;

public enum DtoOrderValue {

    V1000(0.03, 1000),
    V2000(0.07, 2000),
    V5000(0.15, 5000),
    V7500(0.19, 7500),
    V10000(0.25, 10000);

    private double dto;
    private int pricelimit;

    DtoOrderValue(final double dto, final int priceLimit){
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
