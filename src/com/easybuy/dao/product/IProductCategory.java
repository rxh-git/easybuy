package com.easybuy.dao.product;

import com.easybuy.entity.EasyBuyProductCategory;

import java.util.List;

public interface IProductCategory {
    //获得商品一级分类
    List<EasyBuyProductCategory> queryAllProductCatagory(String parentId);
}
