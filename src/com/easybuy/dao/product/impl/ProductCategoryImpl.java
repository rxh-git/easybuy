package com.easybuy.dao.product.impl;

import com.easybuy.dao.product.IProductCategory;
import com.easybuy.entity.EasyBuyProductCategory;
import com.easybuy.util.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryImpl implements IProductCategory {
    @Override
    public List<EasyBuyProductCategory> queryAllProductCatagory(String parentId) {
        List<EasyBuyProductCategory> productCategories=new ArrayList<EasyBuyProductCategory>();
        EasyBuyProductCategory productCategory=null;
        try {
        StringBuffer sql=new StringBuffer();
        sql.append("select * from easybuy_product_category where 1=1");
        //判断parentId的值，如果为0，显示的是一级分类
        if (!"".equals(parentId)||null!=parentId){
         parentId="0";
          sql.append(" and parentId= "+parentId);
        }

            Connection connection= DataSourceUtil.getConn();
            PreparedStatement pstmt=connection.prepareStatement(sql.toString());
            ResultSet rs=pstmt.executeQuery();
            while (rs.next()){
                productCategory=new EasyBuyProductCategory();
                productCategory.setId(rs.getInt(1));
                productCategory.setName(rs.getString(2));
                productCategory.setParentId(rs.getInt(3));
                productCategory.setType(rs.getInt(4));
                productCategory.setIconClass(rs.getString(5));
                productCategories.add(productCategory);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return productCategories;
    }
}
