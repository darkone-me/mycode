package learn.proxyTest.custom;

import learn.proxyTest.Person;
import learn.proxyTest.Son;

/**
 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2018年11月15日 下午2:20:15          Administrator        2.1         To create
 * </p>
 * 2018年11月15日 下午2:20:15          Administrator        2.1         modify parameters
 *
 * @since 
 * @see     
 */
public class ProxyTest {
    public static void main(String[] args) {
        Person son = (Person) new CustomProxy().getInstance(new Son());
        son.findLove();
    }
}
