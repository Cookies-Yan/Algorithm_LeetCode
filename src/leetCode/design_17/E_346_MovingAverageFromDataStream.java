package leetCode.design_17;

import java.util.LinkedList;
import java.util.Queue;

public class E_346_MovingAverageFromDataStream {

    /** Initialize your data structure here. */

    //Time O(n)
    //Space O(n)
    public double sum;
    public Queue<Integer> queue;
    public int size;

    public E_346_MovingAverageFromDataStream(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
    }

    public double next(int val) {
        if (queue.size() == size) { //==是因为 要加入下一个了 需要删除上一个
            sum -= queue.remove();
        }
        sum += val;
        queue.offer(val);
        return sum / queue.size();
    }

    /**
     * 特别慢
     */
//    public int size;
//    public List<Integer> tank;
//
//    public E_346_MovingAverageFromDataStream(int size) {
//        this.size = size;
//        this.tank = new ArrayList<>();
//    }
//
//    public double next(int val) {
//        tank.add(val);
//        double sum = 0;
//        if (tank.size() <= size) {
//            for (double num : tank) {
//                sum += num;
//            }
//            return sum / tank.size();
//        } else {
//            for (int i = tank.size() - size; i < tank.size(); i++) {
//                sum += tank.get(i);
//            }
//            return sum / size;
//
//        }
//
//    }
}
