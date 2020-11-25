package com.ups.retailstore;

import com.ups.retailstore.entity.CustomerType;
import com.ups.retailstore.model.Bill;
import com.ups.retailstore.service.RetailDiscountService;
import com.ups.retailstore.service.RetailDiscountServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RetailDiscountApplicationTests {

    @Autowired
    RetailDiscountService retailDiscountService;

    Double billAmount;
    Double groceriesCost;
    CustomerType customerType;

    @Test
    void contextLoads() {
    }

    @Test
    public void givenEmployeeCustomerWhenDiscountAppliedThen30PercentDiscountShouldBeApplied() throws Exception {
        //given
        billAmount = 1000.0;
        groceriesCost = 100.0;
        customerType = CustomerType.EMPLOYEE;

        // when
        Bill employeeBill = retailDiscountService.getBillDiscount(billAmount, groceriesCost, customerType);

        // then
        Assert.assertEquals((Object) 585.0, employeeBill.getBillAmount());
    }

    @Test
    public void givenAffiliateCustomerWhenDiscountAppliedThen10PercentDiscountShouldBeApplied() {
        //given
        billAmount = 1000.0;
        groceriesCost = 100.0;
        customerType = CustomerType.AFFILIATE;

        // when
        Bill affiliateBill = retailDiscountService.getBillDiscount(billAmount, groceriesCost, customerType);

        // then
        Assert.assertEquals((Object) 765.0, affiliateBill.getBillAmount());
    }

    @Test
    public void givenOldCustomerWhenDiscountAppliedThen5PercentDiscountShouldBeApplied() {
        //given
        billAmount = 1000.0;
        groceriesCost = 100.0;
        customerType = CustomerType.OLD_CUSTOMER;

        // when
        Bill oldBill = retailDiscountService.getBillDiscount(billAmount, groceriesCost, customerType);

        // then
        Assert.assertEquals((Object) 810.0, oldBill.getBillAmount());
    }
}
