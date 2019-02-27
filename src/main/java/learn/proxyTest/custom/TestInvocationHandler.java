package learn.proxyTest.custom;

import java.lang.reflect.Method;

/**
 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2018年11月12日 下午3:31:39          Administrator        2.1         To create
 * </p>
 * 2018年11月12日 下午3:31:39          Administrator        2.1         modify parameters
 *
 * @since 
 * @see     
 */
public interface TestInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
