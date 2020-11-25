package com.neusoft.redbag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class LuckyMoneyController {
    @Autowired
    private LuckyMoneyRepository repository;
    //获取红包列表
//    @GetMapping("/list")
    @RequestMapping("/list")
    public List<LuckyMoney> list(){
        return repository.findAll();
    }
//发红包
    @PostMapping("/post")
    public LuckyMoney possRedBag(@RequestParam(value = "producer",required = true)String producer, @RequestParam(value = "money",required = true)BigDecimal money){
        LuckyMoney luckyMoney =new LuckyMoney();
        luckyMoney.setProducer(producer);
        luckyMoney.setMoney(money);
        return  repository.save(luckyMoney);
    }
}
