package com.easybuy.test;

import com.easybuy.dao.product.IProductCategory;
import com.easybuy.dao.product.impl.ProductCategoryImpl;
import com.easybuy.entity.EasyBuyProductCategory;

import java.util.List;

public class TestProductCategory {
    public  void testProductCategory(){
        IProductCategory iProductCategory=new ProductCategoryImpl();
      List<EasyBuyProductCategory> list= iProductCategory.queryAllProductCatagory("0");
        for (EasyBuyProductCategory e:list
             ) {
            System.out.print(e.getName());
        }
    }
}
