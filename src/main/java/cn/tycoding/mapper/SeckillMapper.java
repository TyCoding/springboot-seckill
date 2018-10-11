package cn.tycoding.mapper;

import cn.tycoding.entity.Seckill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @auther TyCoding
 * @date 2018/10/6
 */
@Mapper
public interface SeckillMapper {

    /**
     * 查询符合条件的秒杀商品ID
     *
     * @param nowTime 封装的秒杀条件，如：
     *                1.商品开始秒杀的时间要小于当前时间；
     *                2.商品结束秒杀的时间要大于当前时间；
     *                3.商品的库存数量要>0。只有符合了这些条件，才应该被查询出来
     * @return
     */
    List<Seckill> findSeckillList(String nowTime);

    /**
     * 查询所有秒杀商品的记录信息（包括不符合秒杀条件的）
     *
     * @return
     */
    List<Seckill> findAll();

    /**
     * 根据主键查询当前秒杀商品的数据
     *
     * @param id
     * @return
     */
    Seckill findById(long id);

    /**
     * 减库存。
     * 对于Mapper映射接口方法中存在多个参数的要加@Param()注解标识字段名称，不然Mabatis不能识别出来哪个字段相互对应
     *
     * @param seckillId 秒杀商品ID
     * @param killTime  秒杀时间
     * @return 返回此SQL更新的记录数，如果>=1表示更新成功
     */
    int reduceStock(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);
}
