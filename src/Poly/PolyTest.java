package Poly;

/**
 * Created by vrit on 16-10-12.
 */
public class PolyTest {
    public static void main(String[] args) {
        //多项式p1
        PolyList p1=new PolyList();
        p1.insert(new PolyNode(2,2));
        p1.insert(new PolyNode(100,3));
        p1.insert(new PolyNode(45,5));
        p1.insert(new PolyNode(3,20));
        System.out.println("p1="+p1.toString());

        //多项式p2
        PolyList p2=new PolyList();
        p2.insert(new PolyNode(8,2));
        p2.insert(new PolyNode(7,3));
        p2.insert(new PolyNode(4,4));
        p2.insert(new PolyNode(6,18));
        p2.insert(new PolyNode(7,20));
        System.out.println("p2="+p2.toString());

        //相加
        PolyList resultList1= PolyList.addPoly(p1, p2);
        System.out.println("p1+p2="+resultList1.toString());
        System.out.println();

        PolyList resultList2= PolyList.subPoly(p1, p2);
        System.out.println("p1-p2="+resultList2.toString());
        System.out.println();
        //多项式p3
        PolyList p3=new PolyList();
        p3.insert(new PolyNode(2,1));
        p3.insert(new PolyNode(3,2));
        p3.insert(new PolyNode(4,3));
        System.out.println("p3="+p3.toString());


        //多项式p4
        PolyList p4=new PolyList();
        p4.insert(new PolyNode(5,1));
        p4.insert(new PolyNode(1,2));
        System.out.println("p4="+p4.toString());

        //相乘
        PolyList resuList2=PolyList.mulPoly(p3, p4);
        System.out.println("p3*p4="+resuList2.toString());
        //微分
        PolyList resuList=PolyList.diffPoly(p3);
        System.out.println("diff(p3)="+resuList.toString());
    }
}
