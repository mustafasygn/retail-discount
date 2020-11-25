package com.ups.retailstore.service;

import com.ups.retailstore.entity.CustomerType;
import com.ups.retailstore.model.Bill;

public interface RetailDiscountService {

    Bill getBillDiscount(Double billAmount, Double groceriesCost, CustomerType customerType);
}
