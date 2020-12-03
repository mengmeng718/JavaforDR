package com.neusoft.springbootsell.controller;

import com.neusoft.springbootsell.dataobject.ProductCategory;
import com.neusoft.springbootsell.form.CategoryForm;
import com.neusoft.springbootsell.form.UserForm;
import com.neusoft.springbootsell.services.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/seller/logout")
public class SellerUserController {

    @GetMapping("/start")
    public ModelAndView list(Map<String, Object> map){

        return new ModelAndView("logout/start", map);
    }
    @PostMapping("/save")
    public ModelAndView save(@Valid UserForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map
    ){
        if (bindingResult.hasErrors()){
            // 返回错误页面
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/seller/logout/start");
            return new ModelAndView("common/error", map);
        }
        map.put("url","/seller/product/list");
        return new ModelAndView("common/success",map);
    }
}
