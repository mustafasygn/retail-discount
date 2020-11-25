package com.ups.retailstore.service;

import com.ups.retailstore.constants.Constants;
import com.ups.retailstore.entity.CustomerType;
import com.ups.retailstore.model.Bill;
import org.springframework.stereotype.Service;

@Service
public class RetailDiscountServiceImpl implements RetailDiscountService {

    @Override
    public Bill getBillDiscount(Double billAmount, Double groceriesCost, CustomerType customerType) {
        double discountAmount;
        double billWithoutGroceriesCost;
        Bill customerBill = new Bill();
        int discountPercentage = customerType.getDiscPercentage();

        billWithoutGroceriesCost = (billAmount - groceriesCost);
        discountAmount = ((billWithoutGroceriesCost * discountPercentage) / 100);
        if (billAmount >= Constants.AMOUNT_FOR_AMOUNT_BASED_DISCOUNT) {
            customerBill.setBillAmount(billWithoutGroceriesCost - discountAmount - getMoreDiscount(billWithoutGroceriesCost));
        } else {
            customerBill.setBillAmount(billWithoutGroceriesCost - discountAmount);
        }

        customerBill.setDiscount(discountPercentage + "%");

        return customerBill;
    }

    private Double getMoreDiscount(Double billAmount) {
        return ((Math.floor(Math.floor(billAmount) / 100)
                * Constants.AMOUNT_BASED_DISCOUNT_VALUE));
    }
}
