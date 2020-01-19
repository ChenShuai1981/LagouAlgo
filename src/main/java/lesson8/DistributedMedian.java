package lesson8;

/**
 * 有一万台服务器，每台服务器上存储了十亿个没有排好序的数，应该如何找出中位数？
 *
 * 两点注意事项：
 * 1. 每台服务器进行算法计算的复杂度限制，包括时间和空间复杂度
 * 10亿个数，每个数占4字节，共需要4GB内存
 * 使用快速排序，大约需要30次压栈操作
 *
 * 2. 服务器与服务器之间进行通信的网络带宽限制
 *
 * 思路:
 * 1. 从一万台服务器当中选取其中一台作为主机
 * 2. 从主机上随机选择一个基准值，广播到其他各台服务器
 * 3. 每台服务器执行快速选择算法，小于基准值的数放在数组左边，大于基准值的数放在数组右边
 * 4. 每台服务器将less count, equal count和greater count发回到主机上
 * 5. 主机统计所有的less count, equal count和greater count，得到各数总和。接下来判断：
 *   5.1 如果 total less count + total equal count >= totalcount/2，表明基准值即是所求结果
 *   5.2 如果 total less count >= totalcount/2，表明基准值过大
 *   5.3 如果 total less count + total equal count < totalcount/2，表明基准值过小
 * 6. 如果为后两种情况，主机会将新基准值广播到各服务器，服务器根据新基准值的大小判断快速选择方向直到最后找到中位数
 *
 * 总体时间复杂度是 O(nlogn)
 * 主机与各服务器之间通信次数共nlogn次，每次通信需要传递一个基准值和三个计数值
 *
 *
 */
public class DistributedMedian {


}
