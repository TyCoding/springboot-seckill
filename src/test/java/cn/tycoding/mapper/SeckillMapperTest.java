package cn.tycoding.mapper;

import cn.tycoding.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
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
    public void findSeckillGoodsList() {
        /**
         * 查询符合条件的秒杀商品列表：
         *  1.秒杀开始时间小于当前时间
         *  2.秒杀结束时间大于当前时间
         *  3.商品的库存量大于0
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDate = sdf.format(new Date());
        List<Seckill> seckillGoodsList = seckillMapper.findSeckillList(nowDate);
        for (Seckill seckill : seckillGoodsList) {
            System.out.println(seckill.getTitle());
        }
    }

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