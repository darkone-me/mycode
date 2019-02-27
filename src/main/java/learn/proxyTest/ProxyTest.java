package learn.proxyTest;

/**
 * <p>
 * Description: ProxyTest.java
 * Company:     中国移动通信集团设计院有限公司
 * Copyright:   CMDI. All Rights Reserved.
 * @author Administrator
 * @version 2.1

 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2018年11月1日 上午11:09:49          Administrator        2.1         To create
 * </p>
 * 2018年11月1日 上午11:09:49          Administrator        2.1         modify parameters
 *
 * @since 
 * @see     
 */
public class ProxyTest {
    /*public static void main(String[] args) {
        Person son = (Person) new JdkProxy().getInstance(new Son());
        son.findLove();
        System.out.println();
    }*/

    public static void main(String[] args) {
        Son obj = (Son) new CglibProxy().getInstance(Son.class);
        obj.findLove();
    }
}
