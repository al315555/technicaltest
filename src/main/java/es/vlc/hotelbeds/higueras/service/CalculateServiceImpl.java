package es.vlc.hotelbeds.higueras.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculateServiceImpl implements CalculateService{

    @Override
    public BigDecimal calculateTotalAmount(String itemDescription,
                                           BigDecimal itemPrice,
                                           Integer numberOfItems,
                                           String state) {

        Float total = itemPrice.floatValue() * numberOfItems;
        //TODO put discount and tax for the specific state.
        return BigDecimal.valueOf(total);
    }
}
