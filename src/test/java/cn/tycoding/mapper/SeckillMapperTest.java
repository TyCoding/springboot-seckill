package cn.tycoding.mapper;

import cn.tycoding.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * @auther TyCoding
 * @date 2018/10/8
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:application.yml")
@SpringBootTest
public class SeckillMapperTest {

    @Autowired
    private SeckillMapper seckillMapper;

    @Test
    public void findAll() {
        List<Seckill> all = seckillMapper.findAll();
        for (Seckill seckill : all) {
            System.out.println(seckill.getTitle());
        }
    }

    @Test
    public void findById() {
        Seckill seckill = seckillMapper.findById(1l);
        System.out.println(seckill.getTitle());
    }

    @Test
    public void reduceStock() {
        int row = seckillMapper.reduceStock(1l, new Date());
        System.out.println(row);
    }
}