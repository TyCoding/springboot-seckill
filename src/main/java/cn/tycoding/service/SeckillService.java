package cn.tycoding.service;

import cn.tycoding.dto.Exposer;
import cn.tycoding.dto.SeckillExecution;
import cn.tycoding.entity.Seckill;
import cn.tycoding.exception.RepeatKillException;
import cn.tycoding.exception.SeckillCloseException;
import cn.tycoding.exception.SeckillException;

import java.math.BigDecimal;
import java.util.List;

/**
 * 业务接口：应该站在"使用者"的角度设计，比如：
 * 1.定义方法的颗粒度要细
 * 2.方法的参数要明确且简练，不建议用类似Map这种让使用者封装一堆参数传递过来
 * 3.方法的return类型，除了要明确返回值类型，还应该指定该方法可能抛出的异常
 *
 * @auther TyCoding
 * @date 2018/10/6
 */
public interface SeckillService {

    /**
     * 获取所有的秒杀商品列表
     *
     * @return
     */
    List<Seckill> findAll();

    /**
     * 获取某一条商品秒杀信息
     *
     * @param seckillId
     * @return
     */
    Seckill findById(long seckillId);

    /**
     * 秒杀开始时输出暴露秒杀的地址
     * 否者输出系统时间和秒杀时间
     *
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀的操作
     *
     * @param seckillId
     * @param userPhone
     * @param money
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId, BigDecimal money, long userPhone, String md5)
            throws SeckillException, RepeatKillException, SeckillCloseException;


}
