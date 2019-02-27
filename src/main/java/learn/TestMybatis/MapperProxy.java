package learn.TestMybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2019年1月11日 下午2:44:58          Administrator        2.1         To create
 * </p>
 * 2019年1月11日 下午2:44:58          Administrator        2.1         modify parameters
 *
 * @since 
 * @see     
 */
public class MapperProxy implements InvocationHandler {

    private TestSqlSession sqlSession;

    /**
     * @param sqlSession
     */
    public MapperProxy(TestSqlSession sqlSession) {
        super();
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass().getName().equals(TestConfiguration.TestMapperXml.namespace)) {
            String sql = TestConfiguration.TestMapperXml.methodSqlMapping.get(method.getName());
            return sqlSession.selectOne(sql, String.valueOf(args[0]));
        }
        return method.invoke(this, args);
    }

}
