package learn.proxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 * Description: JdkProxy.java
 * Company:     中国移动通信集团设计院有限公司
 * Copyright:   CMDI. All Rights Reserved.
 * @author Administrator
 * @version 2.1

 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2018年11月1日 上午11:03:29          Administrator        2.1         To create
 * </p>
 * 2018年11月1日 上午11:03:29          Administrator        2.1         modify parameters
 *
 * @since 
 * @see     
 */
public class JdkProxy implements InvocationHandler {
    private Person person;

    public Object getInstance(Son target) {
        this.person = target;

        Class<?> clazz = target.getClass();

        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);

    }

    /* (non-Javadoc)
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK开始");
        method.invoke(this.person, args);
        System.out.println("JDK结束");
        return null;
    }

}
