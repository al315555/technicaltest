package es.vlc.hotelbeds.higueras.service;

import es.vlc.hotelbeds.higueras.data.DtoOrderValue;
import es.vlc.hotelbeds.higueras.data.TaxesProvincia;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculateServiceImpl implements CalculateService{

    @Override
    public BigDecimal calculateTotalAmount(String itemDescription,
                                           BigDecimal itemPrice,
                                           Integer numberOfItems,
                                           String state) {

        double total = itemPrice.floatValue() * numberOfItems;

        // Discount
        if (total >= DtoOrderValue.V10000.getPricelimit()) {
            total = (1 - DtoOrderValue.V10000.getDto()) * total;
        } else if (total >= DtoOrderValue.V7500.getPricelimit()) {
            total = (1 - DtoOrderValue.V7500.getDto()) * total;
        } else if (total >= DtoOrderValue.V5000.getPricelimit()) {
            total = (1 - DtoOrderValue.V5000.getDto()) * total;
        } else if (total >= DtoOrderValue.V2000.getPricelimit()) {
            total = (1 - DtoOrderValue.V2000.getDto()) * total;
        } else if (total >= DtoOrderValue.V1000.getPricelimit()) {
            total = (1 - DtoOrderValue.V1000.getDto()) * total;
        }

        // Tax
        switch (state){
            case TaxesProvincia.PROVINCIA_CODE_TER:
                total = (1 + TaxesProvincia.TER.getTaxValue()) * total;
                break;
            case TaxesProvincia.PROVINCIA_CODE_RES:
                total = (1 + TaxesProvincia.RES.getTaxValue()) * total;
                break;
            case TaxesProvincia.PROVINCIA_CODE_BAL:
                total = (1 + TaxesProvincia.BAL.getTaxValue()) * total;
                break;
            case TaxesProvincia.PROVINCIA_CODE_CAN:
                total = (1 + TaxesProvincia.CAN.getTaxValue()) * total;
                break;
            case TaxesProvincia.PROVINCIA_CODE_CYM:
                total = (1 + TaxesProvincia.CYM.getTaxValue()) * total;
                break;

        }

        //Round type .3
        total = Math.round(total * 1000.0) / 1000.0;

        return BigDecimal.valueOf(total);
    }
}
