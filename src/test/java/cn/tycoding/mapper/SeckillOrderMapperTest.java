package cn.tycoding.mapper;

import cn.tycoding.entity.SeckillOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

/**
 * @auther TyCoding
 * @date 2018/10/8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SeckillOrderMapperTest {

    @Autowired
    private SeckillOrderMapper seckillOrderMapper;

    @Test
    public void insertOrder() {
        int i = seckillOrderMapper.insertOrder(1l, BigDecimal.valueOf(120.00), 12247047);
        System.out.println(i);
    }

    @Test
    public void findById() {
        SeckillOrder seckillOrder = seckillOrderMapper.findById(1l, 1278177);
        System.out.println(seckillOrder.getSeckillId() + ": " + seckillOrder.getSeckill().getTitle());
    }
}