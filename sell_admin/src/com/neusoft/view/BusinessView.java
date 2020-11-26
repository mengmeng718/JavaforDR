package com.neusoft.view;

import com.neusoft.domain.Business;

public interface BusinessView {
    public void listAllBusinesses();

    public void selectBusinesses();

    public void saveBusiness();

    public void removeBusiness();

    public Business login();

    public void updatePassword(Integer businessId);

    public void listBusinesses(Integer businessId);//商家查看自己商家信息

    public void updateBusiness(Integer businessId);//商家更新修改自己信息
}

