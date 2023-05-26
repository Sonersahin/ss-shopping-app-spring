package com.sonersahin.shoppingapp.product.service;

import com.sonersahin.shoppingapp.product.domain.MoneyTypes;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductDeliveryService {
    public String getDeliveryInfo(String productId){
        //TODO
        return "Tomorrow";
    }

    public static boolean freeDeliveryCheck(String productId, BigDecimal price, MoneyTypes moneyType){
        //  TODO
        return true;
    }
}
