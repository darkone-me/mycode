package learn.TestMybatis;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2019年1月11日 上午10:25:24          Administrator        2.1         To create
 * </p>
 * 2019年1月11日 上午10:25:24          Administrator        2.1         modify parameters
 *
 * @since 
 * @see     
 */
public class TestConfiguration {

    /**
     * @param clazz
    	* @author tsj
    	* @Date 2019年1月11日上午11:14:37
     */
    @SuppressWarnings("unchecked")
    public <T> T getMapper(Class<T> clazz, TestSqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[] { clazz }, new MapperProxy(sqlSession));
    }

    static class TestMapperXml {
        public static final String namespace = "learn.TestMybatis.TestMapper";

        public static final Map<String, String> methodSqlMapping = new HashMap<>();

        static {
            methodSqlMapping.put("selectById", "select * from test where id = %d");
        }
    }

}
