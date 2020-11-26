package com.neusoft;

import com.neusoft.dao.impl.BusinessDaoImpl;
import com.neusoft.domain.Business;

import java.util.List;

public class Text {
    //    public static void main(String[] args) { BusinessDaoImpl dao = new BusinessDaoImpl();//所有商家列表（只能显示店名）
//        List<Business> businessList = dao.listBusiness();
//        for(Business b : businessList){
//            System.out.println(b);
//        }
//    }
//

//    public static void main(String[] args) {//插入
//        BusinessDaoImpl dao = new BusinessDaoImpl();
//        int businessid = dao.saveBusiness("江科大食堂");
//        System.out.println("id" + businessid);
//    }

    //    public static void main(String[] args) {//删除
//        BusinessDaoImpl dao = new BusinessDaoImpl();
//        dao.removeBusiness(10013);
//    }
    public static void main(String[] args) {
        BusinessDaoImpl dao = new BusinessDaoImpl();
//        int businessid = dao.saveBusiness("江科大食堂");
//        System.out.println("id" + businessid);
//更新数据
//        dao.removeBusiness(10016);
//        Business business = new Business();
//        business.setBusinessName("真好吃");
//        business.setBusinessAddress("dasdas");
//        business.setBusinessExplain("dasdas");
//        business.setDeliveryPrice(5.);
//        business.setStartPrice(2.);
//        business.setBusinessId(10012);
//        dao.updateBusiness(business);
        Business b = dao.getBusinessById(10005);
        System.out.println(b);
    }
}
