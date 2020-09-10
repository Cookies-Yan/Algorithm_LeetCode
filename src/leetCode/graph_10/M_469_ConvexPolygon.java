package leetCode.graph_10;

import java.util.List;

/**
 *
 * 解题思路：
 * 判断所有的点不在任意一条边的同侧，既点到直线的垂直矢量应一致。
 * 角度法：判断每个顶点所对应的内角是否小于180度，如果小于180度，则是凸的，如果大于180度，则是凹多边形
 * 叉乘法：即利用两条向量叉乘的结果，来判断。根据向量的叉积我们就可以判断这个多边形的内角是否均小于180度，相邻两条边的向量均保持顺时针或逆时针旋转才符合条件。
 *
 *
 * Time O(n)
 * Space O(1)
 * 求三点的法向量：如果方向不一致，那么就不是凸边型
 *    。
 *   / \
 *  。  。
 * /    \
 *
 * 对于向量（x1,y1）,（x2,y2） 这两点可以是点坐标，也可以是向量
 * 叉积运算结果为x1*y2-x2*y1
 *
 * 两点的法向量求法：
 * A(a1,b1),B(a2,b2,),则向量AB为B点坐标减A点坐标,即向量AB=(a2-a1,b2-b1)
 *
 * 所以：点 p1 p2 p3:
 *                      ①                   ②
 * 向量：p2p3 (p3.get(0) - p2.get(0),  p3.get(1) - p2.get(1))
 *                      ③           ×       ④
 * 向量：p1p2 (p2.get(0) - p1.get(0),  p2.get(1) - p1.get(1))
 * 叉乘得到三点向量方向：①×④ - ②×③
 *
 * (p3.get(0) - p2.get(0)) * (p2.get(1) - p1.get(1)) -
 *                 (p2.get(0) - p1.get(0)) * (p3.get(1) - p2.get(1));
 *
 * 向量点积：
 * 如果等于90度, 两向量乘积等于0
 * 向量a、向量b，若a*b<0，则表示向量a与向量b的夹角w的范围是：(90°，180°]
 * 向量a、向量b，若a*b>0，则表示向量a与向量b的夹角w的范围是：< 90°
 *
 * 叉积：（右手定则）
 * A,B同为向量，|A×B|=AxBy-AyBx，
 * 若这个值大于0，则说明B指向A逆时针旋转0到180的方向，
 * 若这个值小于0，则说明B指向A顺时针旋转0到180的方向，
 * 若等于0，则两向量共线，可能反向
 * 叉积的方向与进行叉积的两个向量都垂直，所以叉积向量即为这两个向量构成平面的法向量。
 * 两个向量平行时，其向量叉积为零
 */
public class M_469_ConvexPolygon {

    public boolean isConvex(List<List<Integer>> points) {
        int size = points.size();
        int flag = 0; //向量的方向
        for (int i = 0; i < points.size(); i++) {
            //我们不能漏掉每一个点，所以我们用%去重新循环：123412
            int ori = helper(points.get(i % size), points.get((i + 1) % size), points.get((i + 2) % size));
            if (ori == 0) {
                continue;
            }
            if(flag == 0){ //因为flag初始化就是0,如果不相等，我们判断跟原来是不是相等
                flag = ori;
            } else {
                if (flag != ori) {
                    return false;
                }
            }
        }
        return true;
    }

    public int helper(List<Integer> p1, List<Integer> p2, List<Integer> p3) {
        int val = (p3.get(0) - p2.get(0)) * (p2.get(1) - p1.get(1)) -
                (p2.get(0) - p1.get(0)) * (p3.get(1) - p2.get(1));
        if (val < 0){
            return 2;
        } else if (val == 0) {
            return 0;
        }
        return 1;
    }
}
