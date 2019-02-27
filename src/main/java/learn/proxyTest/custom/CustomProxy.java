package learn.proxyTest.custom;

import java.lang.reflect.Method;

import learn.proxyTest.Person;
import learn.proxyTest.Son;

/**
 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2018年11月15日 下午2:21:28          Administrator        2.1         To create
 * </p>
 * 2018年11月15日 下午2:21:28          Administrator        2.1         modify parameters
 *
 * @since 
 * @see     
 */
public class CustomProxy implements TestInvocationHandler {
    private Person person;

    public Object getInstance(Son target) {
        this.person = target;

        Class<?> clazz = target.getClass();

        return TestProxy.newProxyInstance(new TestClassloader(), clazz.getInterfaces(), this);

    }

    /* (non-Javadoc)
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("字节码重组后开始");
        method.invoke(this.person, args);
        System.out.println("字节码重组后结束");
        return null;
    }
}
