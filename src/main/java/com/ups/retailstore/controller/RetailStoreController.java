package com.ups.retailstore.controller;

import com.ups.retailstore.entity.CustomerType;
import com.ups.retailstore.model.Bill;
import com.ups.retailstore.service.RetailDiscountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@RestController
@RequestMapping("/bill")
@Validated
public class RetailStoreController {

    @Autowired
    RetailDiscountServiceImpl retailDiscountService;

    @RequestMapping(value = "/getBillDetails", method = RequestMethod.GET)
    public ResponseEntity getBillDetails(
            @Valid @RequestParam @Max(value = 3, message = "1 for EMPLOYEE customer , 2 for AFFILIATE  and 3 OLD_CUSTOMER")
            @Min(value = 1, message = "1 for EMPLOYEE customer , 2 for AFFILIATE  and 3 OLD_CUSTOMER") int customerTypeValue,
            @RequestParam double billAmount,
            @RequestParam(required = false) double groceriesAmount) {
        if (validCustomerType(customerTypeValue)) {
            CustomerType customerType = CustomerType.valueOf(String.valueOf(customerTypeValue));
            Bill customerBill = retailDiscountService.getBillDiscount(billAmount, groceriesAmount, customerType);
            if (customerBill != null) {
                return new ResponseEntity(customerBill, HttpStatus.OK);
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Please choose customer Type 1 for EMPLOYEE customer , 2 for AFFILIATE  and 3 OLD_CUSTOMER");
    }

    private boolean validCustomerType(int customerType) {
        if (4 > customerType && customerType > 0) {
            return true;
        }
        return false;
    }

}
