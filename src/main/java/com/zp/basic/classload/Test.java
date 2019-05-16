package com.zp.basic.classload;

/**
 * @Auther: zhengpeng
 * @Date: 2019/4/5 18:03
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
//        Map<String,Object> map = new HashMap<>();
//        ISimpleA iSimpleA = new SimpleA();
//        map.put("a",iSimpleA);
//        ISimpleA iSimpleB = new SimpleB();
//        ISimpleA iSimpleA1 = (ISimpleA)map.get("a");
//        System.out.println(iSimpleA1.add(1,1));
//        iSimpleA1 = iSimpleB;
//        System.out.println(iSimpleA1.add(1,1));
////        map.put("a",iSimpleA1);
//        ISimpleA iSimpleA2 = (ISimpleA)map.get("a");
//        System.out.println(iSimpleA2.add(1,1));
        ISimpleA iSimpleA = new SimpleA();
        System.out.println(iSimpleA.add(1,1));
        ISimpleA iSimpleB = new SimpleB();
        iSimpleA = iSimpleB;
        System.out.println(iSimpleA.add(1,1));
        ISimpleA iSimpleC = new SimpleC();
        iSimpleB = iSimpleC;
        System.out.println(iSimpleA.add(1,1));

    }
}
