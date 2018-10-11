package cn.tycoding.exception;

/**
 * 重复执行秒杀的异常（运行期异常）
 *
 * @auther TyCoding
 * @date 2018/10/8
 */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
