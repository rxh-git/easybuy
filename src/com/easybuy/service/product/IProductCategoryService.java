package com.easybuy.service.product;

import com.easybuy.entity.EasyBuyProductCategory;

import java.util.List;

public interface IProductCategoryService {
    List<EasyBuyProductCategory> queryAllProductCatagory(String parentId);

}
