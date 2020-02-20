package com.easybuy.test;

import com.easybuy.entity.EasyBuyProductCategory;
import com.easybuy.service.product.IProductCategoryService;
import com.easybuy.service.product.impl.ProductCategoryServiceImpl;
import com.easybuy.util.DataSourceUtil;

import java.util.List;

public class main {
    public static void main(String[] args) {
//       TestProductCategory testProductCategory=new TestProductCategory();
//       testProductCategory.testProductCategory();
//
        IProductCategoryService iProductCategoryService=new ProductCategoryServiceImpl();
    List<EasyBuyProductCategory> list= iProductCategoryService.queryAllProductCatagory("0");
        System.out.println(list.size());
    }
}
