package Poly;

/**
 * Created by vrit on 16-10-12.
 */
public class PolyList {
    PolyNode head;
    PolyNode current;

    public PolyList() {
        head = new PolyNode();
        current = head;
        head.next = null;
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    public void insert(PolyNode node) {
        current.next = node;
        current = node;
    }

    /**
     * 粗略打印，不考虑正负一输出的情况
     *
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        PolyNode node = head.next;
        while (node != null) {
            if (node.getCoef() > 0)
                sb.append(" + ");
            sb.append(node.getCoef() + "x^" + node.getExpn());

            node = node.next;
        }
        return sb.substring(0, sb.length());
    }

    /**
     * 多项式相加
     *
     * @param p
     * @param q
     * @return
     */
    public static PolyList addPoly(PolyList p, PolyList q) {
        PolyNode pnext = p.head.next;
        PolyNode qnext = q.head.next;
        PolyList result = new PolyList();

        while (pnext != null && qnext != null) {
            int pexpn = pnext.getExpn();
            int qexpn = qnext.getExpn();
            double pcoef = pnext.getCoef();
            double qcoef = qnext.getCoef();
            if (pexpn == qexpn) {
                if (pcoef + qcoef != 0) {
                    PolyNode node = new PolyNode(pcoef + qcoef, pexpn);
                    result.insert(node);
                }
                pnext = pnext.next;
                qnext = qnext.next;
            } else if (pexpn < qexpn) {
                PolyNode node = new PolyNode(pnext.getCoef(), pnext.getExpn());
                result.insert(node);
                pnext = pnext.next;
            } else {
                PolyNode node = new PolyNode(qnext.getCoef(), qnext.getExpn());
                result.insert(node);
                qnext = qnext.next;
            }
        }
        //q多项式已经完成
        while (pnext != null) {
            PolyNode node = new PolyNode(pnext.getCoef(), pnext.getExpn());
            result.insert(node);
            pnext = pnext.next;
        }
        //p多项式已经完成
        while (qnext != null) {
            PolyNode node = new PolyNode(qnext.getCoef(), qnext.getExpn());
            result.insert(node);
            qnext = qnext.next;
        }
        return result;
    }

    /**
     * 多项式相减
     *
     * @param p
     * @param q
     * @return
     */

    public static PolyList subPoly(PolyList p, PolyList q) {
        PolyNode pnext = p.head.next;
        PolyNode qnext = q.head.next;
        PolyList result = new PolyList();

        while (pnext != null && qnext != null) {
            int pexpn = pnext.getExpn();
            int qexpn = qnext.getExpn();
            double pcoef = pnext.getCoef();
            double qcoef = qnext.getCoef();
            if (pexpn == qexpn) {
                if (pcoef - qcoef != 0) {
                    PolyNode node = new PolyNode(pcoef - qcoef, pexpn);
                    result.insert(node);
                }
                pnext = pnext.next;
                qnext = qnext.next;
            } else if (pexpn < qexpn) {
                PolyNode node = new PolyNode(pnext.getCoef(), pnext.getExpn());
                result.insert(node);
                pnext = pnext.next;
            } else {
                PolyNode node = new PolyNode(-qnext.getCoef(), qnext.getExpn());
                result.insert(node);
                qnext = qnext.next;
            }
        }
        //q多项式已经完成
        while (pnext != null) {
            PolyNode node = new PolyNode(pnext.getCoef(), pnext.getExpn());
            result.insert(node);
            pnext = pnext.next;
        }
        //p多项式已经完成
        while (qnext != null) {
            PolyNode node = new PolyNode(-qnext.getCoef(), qnext.getExpn());
            result.insert(node);
            qnext = qnext.next;
        }
        return result;
    }

    /**
     * 多项式相乘
     *
     * @param p 多项式
     * @param q 多项式
     * @return 乘积
     */
    public static PolyList mulPoly(PolyList p, PolyList q) {
        PolyNode pnext = p.head.next;
        PolyNode qnext = q.head.next;
        PolyList result = new PolyList();
        while (qnext != null) {
            while (pnext != null) {
                double coef = pnext.getCoef() * qnext.getCoef();
                int expn = pnext.getExpn() + qnext.getExpn();
                result.insert(new PolyNode(coef, expn));
                pnext = pnext.next;
            }
            qnext = qnext.next;
            pnext = p.head.next;//复位
        }
        //合并同类项
        PolyNode current = result.head.next;
        PolyNode preCurrent = result.head;
        while (current != null) {
            PolyNode nextNode = current.next;
            PolyNode preNode = current;
            while (nextNode != null) {
                if (nextNode.getExpn() == current.getExpn()) {
                    current.setCoef(current.getCoef() + nextNode.getCoef());
                    nextNode = nextNode.next;
                    preNode.next = nextNode;
                } else {
                    preNode = preNode.next;
                    nextNode = nextNode.next;
                }
            }
            //删除系数为0的项
            if (current.getCoef() == 0) {
                preCurrent.next = current.next;
            }
            current = current.next;
        }
        return result;
    }

    /**
     * 多项式微分
     *
     * @param p
     * @return
     */
    public static PolyList diffPoly(PolyList p) {
        PolyNode pnext = p.head.next;
        PolyList result = new PolyList();
        while (pnext != null) {
            PolyNode node = new PolyNode(pnext.getCoef()*pnext.getExpn(), pnext.getExpn()-1);
            result.insert(node);
            pnext = pnext.next;
        }
        return result;
    }
}
