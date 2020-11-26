package com.neusoft.view.impl;

import com.neusoft.dao.BusinessDao;
import com.neusoft.dao.impl.BusinessDaoImpl;
import com.neusoft.domain.Business;
import com.neusoft.view.BusinessView;

import java.util.List;
import java.util.Scanner;

public class BusinessViewImpl implements BusinessView {

    private Scanner input = new Scanner(System.in);

    @Override
    public void listAllBusinesses() {
        BusinessDao dao = new BusinessDaoImpl();
        List<Business> list = dao.listBusiness(null, null);
        System.out.println("商家编号" + "\t" + "商家名称" + "\t" + "商家地址" + "\t" + "商家备注" + "\t" + "商家起送费" + "\t" + "商家配送费");
        for (Business b : list) {
            System.out.println(b.getBusinessId() + "\t" + b.getBusinessName() + "\t" + b.getBusinessAddress() + "\t" + b.getBusinessExplain() + "\t" + b.getStartPrice() + "\t" + b.getDeliveryPrice());
        }

    }

    @Override
    public void selectBusinesses() {
        String businessName = "";
        String inputStr = "";
        String businessAddress = "";
        System.out.println("请输入是否输入商家名称关键词(y/n):");
        inputStr = input.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入商家名称关键词");
            businessName = input.next();
        }

        System.out.println("请输入是否输入商家地址关键词(y/n):");
        inputStr = input.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入商家地址关键词");
            businessAddress = input.next();
        }
        BusinessDaoImpl dao = new BusinessDaoImpl();
        List<Business> list = dao.listBusiness(businessName, businessAddress);
        System.out.println("商家编号" + "\t" + "商家名称" + "\t" + "商家地址" + "\t" + "商家备注" + "\t" + "商家起送费" + "\t" + "商家配送费");
        for (Business b : list) {
            System.out.println(b.getBusinessId() + "\t" + b.getBusinessName() + "\t" + b.getBusinessAddress() + "\t" + b.getBusinessExplain() + "\t" + b.getStartPrice() + "\t" + b.getDeliveryPrice());
        }
    }

    @Override
    public void saveBusiness() {
        System.out.println("请输入新商家的名称");
        String businessName = input.next();
        BusinessDao dao = new BusinessDaoImpl();
        int businessId = dao.saveBusiness(businessName);
        // 根据id进行查询， 然后进行回显
        if (businessId > 0) {
            System.out.println("保存成功");
            Business business = dao.getBusinessById(businessId);
            System.out.println(business);
        } else {
            System.out.println("新建商家失败");
        }

    }

    @Override
    public void removeBusiness() {
        System.out.println("请输入要删除的商家id");
        int id = input.nextInt();
        BusinessDao dao = new BusinessDaoImpl();
        System.out.println("确认要删除吗(y/n)");
        if (input.next().equals("y")) {
            int i = dao.removeBusiness(id);
            if (i == 1) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        }
    }

    @Override
    public Business login() {
        System.out.println("请输入商家编号");
        Integer businessId = input.nextInt();

        System.out.println("请输入密码");
        String password = input.next();

        BusinessDaoImpl dao = new BusinessDaoImpl();

        return dao.getBusinessByIdAndPassword(businessId, password);
    }

    @Override
    public void updatePassword(Integer businessId) {
        BusinessDao dao = new BusinessDaoImpl();
        Business business = dao.getBusinessById(businessId);
        new BusinessDaoImpl();
        System.out.println("请输入旧密码");
        String oldPass = input.next();
        // 进行密码校验
        if (!business.getPassword().equals(oldPass)) {
            System.out.println("你的密码蒙错了，请返回再试");
        } else {
            System.out.println("请输入新密码");
            String newPass = input.next();
            System.out.println("请再次输入新密码");
            String beginNewPass = input.next();
            if (!newPass.equals(beginNewPass)) {
                System.out.println("两次密码不一致请返回再试");
            } else {
                int res = dao.updateBusinessPassword(businessId, newPass);
                if (res > 0) {
                    System.out.println("修改密码成功！");
                } else {
                    System.out.println("修改密码失败！");
                }
            }
        }
    }

    @Override
    public void listBusinesses(Integer businessId) {
        BusinessDao dao = new BusinessDaoImpl();
        Business business = dao.getBusinessById(businessId);
        System.out.println("商家编号" + "\t" + "商家名称" + "\t" + "商家地址" + "\t" + "商家备注" + "\t" + "商家起送费" + "\t" + "商家配送费");
        System.out.println(business.getBusinessId() + "\t" + business.getBusinessName() + "\t" + business.getBusinessAddress() + "\t" + business.getBusinessExplain() + "\t" + business.getStartPrice() + "\t" + business.getDeliveryPrice());
    }

    @Override
    public void updateBusiness(Integer businessId) {
        BusinessDao dao = new BusinessDaoImpl();
        Business business = dao.getBusinessById(businessId);
        int menu = 0;
        int res = 0;
        while (menu != 6) {
            System.out.println(">>>二级菜单  1. 修改商家名称   2. 修改商家地址    3. 修改商家备注    4. 修改起送费   5. 修改配送费   6. 返回上一级菜单");
            System.out.println("请输入你要选择的序号：");
            menu = input.nextInt();
            System.out.println("请输入修改后的内容：");
            switch (menu) {
                case 1:
                    String businessName = input.next();
                    business.setBusinessName(businessName);
                    res = dao.updateBusiness(business);
                    break;
                case 2:
                    String businessAddress = input.next();
                    business.setBusinessAddress(businessAddress);
                    res = dao.updateBusiness(business);
                    break;
                case 3:
                    String businessExplain = input.next();
                    business.setBusinessExplain(businessExplain);
                    res = dao.updateBusiness(business);
                    break;
                case 4:
                    double starPrice = input.nextDouble();
                    business.setStartPrice(starPrice);
                    res = dao.updateBusiness(business);
                    break;
                case 5:
                    double deliveryPrice = input.nextDouble();
                    business.setDeliveryPrice(deliveryPrice);
                    res = dao.updateBusiness(business);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("没有这个选项");
                    break;

            }
            if (res > 0) {
                System.out.println("修改成功！");
            } else {
                System.out.println("修改失败！");
            }
        }
    }

}