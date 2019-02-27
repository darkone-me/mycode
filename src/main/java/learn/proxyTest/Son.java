package learn.proxyTest;

/**
 * <p>
 * Description: Son.java
 * Company:     中国移动通信集团设计院有限公司
 * Copyright:   CMDI. All Rights Reserved.
 * @author Administrator
 * @version 2.1

 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2018年11月1日 上午11:02:44          Administrator        2.1         To create
 * </p>
 * 2018年11月1日 上午11:02:44          Administrator        2.1         modify parameters
 *
 * @since 
 * @see     
 */
public class Son implements Person {

    /* (non-Javadoc)
     * @see learn.proxyTest.Person#findLove()
     */
    @Override
    public void findLove() {
        System.out.println("肤白貌美大长腿！");
    }

}
