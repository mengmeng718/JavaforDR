package com.neusoft.redbag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LuckyMoneyRepositoryTests {
    // 在有spring的地方我们这样创建对象，不用new
    @Autowired
    private LuckyMoneyRepository repository;

    @Test
    public void listAll() {
        List<LuckyMoney> list = repository.findAll();
        for (LuckyMoney luckyMoney : list) {
            System.out.println(luckyMoney);
        }
    }

    @Test
    public void getById() {
        Optional<LuckyMoney> optional = repository.findById(1);
        System.out.println(optional);
    }

    @Test
    public void save() {
        LuckyMoney luckyMoney = new LuckyMoney();
        luckyMoney.setConsumer("李四");
        luckyMoney.setMoney(new BigDecimal(11));
        luckyMoney.setProducer("张三");
//        repository.save(luckyMoney);
        //save正常的保存
        //saveAndFlush 是在同一事物下提交前就保存
        repository.saveAndFlush(luckyMoney);
    }

    @Test
    public void delete() {
        repository.deleteById(2);
    }

    @Test
    public void update() {
        LuckyMoney luckyMoney = new LuckyMoney();
        luckyMoney.setId(1);
        luckyMoney.setConsumer("我");
        luckyMoney.setMoney(new BigDecimal(999));
        luckyMoney.setProducer("伏黑惠");
        repository.save(luckyMoney);
    }

}
