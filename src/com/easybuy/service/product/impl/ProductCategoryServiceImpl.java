package com.easybuy.service.product.impl;

import com.easybuy.dao.product.IProductCategory;
import com.easybuy.dao.product.impl.ProductCategoryImpl;
import com.easybuy.entity.EasyBuyProductCategory;
import com.easybuy.service.product.IProductCategoryService;

import java.util.List;

public class ProductCategoryServiceImpl implements IProductCategoryService {
    IProductCategory iProductCategory=new ProductCategoryImpl();
    @Override
    public List<EasyBuyProductCategory> queryAllProductCatagory(String parentId) {
        parentId="0";
        return iProductCategory.queryAllProductCatagory(parentId);
    }
}
