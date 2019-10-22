package com.yangy.manage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品信息
 *
 * @author yang yang
 * @email m17610912950@163.com
 * @time 2019年09月06日 15:21
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String productId;
    private String productName;
    private String price;

}
