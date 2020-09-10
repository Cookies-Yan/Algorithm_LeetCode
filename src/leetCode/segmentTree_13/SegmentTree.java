package leetCode.segmentTree_13;

import java.util.Scanner;

public class SegmentTree {
    static Node[] node;
    static int[] t;
    static int SUM;

    static void make(int l, int r, int idx) {
        node[idx] = new Node(l, r);
        if (l == r) {
            node[idx].sum = t[r];
        } else {
            int mid = (node[idx].l + node[idx].r) >> 1;
            make(l, mid, (idx << 1) + 1); // 构建左子树
            make(mid + 1, r, (idx << 1) + 2); //构建右子树
            /**
             * (idx << 1) | 1
             * 相当于
             * (idx * 2) + 1
             */
            node[idx].sum = node[(idx << 1) | 1].sum + node[(idx << 1) + 2].sum;

        }

    }
    static void query(int l, int r, int idx) {
        if (l <= node[idx].l && r >= node[idx].r) { //所查的区间完全包含了这个区间
            SUM += node[idx].sum;
        } else {
            int mid = (node[idx].l + node[idx].r) >> 1;
            if (r <= mid) {
                query(l, r, (idx << 1) | 1); //只在左边
            } else if(l > mid) {
                query(l, r, (idx << 1) + 2); //只在右边
            } else {                              //两遍都查
                query(l, r, (idx << 1) | 1);
                query(l, r, (idx << 1) + 2);
            }
        }
    }

    static class Node {
        int l;
        int r;
        int sum;
        Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        for (int p = 1; p <= T; p++) {
            int n = cin.nextInt(); //产生大有0小于cin的随机数
            t = new int[n + 1];
            node = new Node[n << 2]; //线段树需要是总长的4倍
            for (int i = 1; i <= n; i++) {
                t[i] = cin.nextInt();
            }
            make(1, n, 0);
            System.out.println();
            System.out.println("Case: " + p + ":");
            while(true) {
                String op = cin.next(); //next()遇到第一个分隔符停止，也就是说值2取到了End
                if("End".equals(op)) {
                    break;
                }
                if ("Query".equals(op)) {
                    SUM = 0;
                    int l = cin.nextInt();
                    int r = cin.nextInt();
                    query(l, r, 0);
                    System.out.println(SUM);
                } else if ("Sub".equals(op)) {
                    int i = cin.nextInt();
                    int val = cin.nextInt();
                    update(i, 0, -val);
                } else {                // Add
                    int i = cin.nextInt();
                    int val = cin.nextInt();
                    update(i, 0, val);
                }
            }
        }
    }

    static void update(int i, int idx, int val) { //单点更新
        node[idx].sum += val;
        if (node[idx].l == i && i == node[idx].r) {
            return;
        } else {
            int mid = (node[idx].l + node[idx].r) >> 1;
            if (i <= mid) {
                update(i, (idx << 1) | 1, val);
            } else {
                update(i, (idx << 1) + 2, val);
            }
        }
    }

}
/**
  1
  10
  1 2 3 4 5 6 7 8 9 10
  Query 1 3
  Add 3 6
  Query 2 7
  Sub 10 2
  Add 6 3
  Query 3 10
  End
 */
