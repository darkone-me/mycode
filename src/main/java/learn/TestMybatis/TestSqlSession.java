package learn.TestMybatis;

/**
 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2019年1月11日 上午10:24:53          Administrator        2.1         To create
 * </p>
 * 2019年1月11日 上午10:24:53          Administrator        2.1         modify parameters
 *
 * @since 
 * @see     
 */
public class TestSqlSession {
    TestConfiguration configuration;
    TestExecutor executor;

    /**
     * @return the configuration
     */
    public TestConfiguration getConfiguration() {
        return configuration;
    }

    /**
     * @param configuration the configuration to set
     */
    public void setConfiguration(TestConfiguration configuration) {
        this.configuration = configuration;
    }

    /**
     * @return the executor
     */
    public TestExecutor getExecutor() {
        return executor;
    }

    /**
     * @param executor the executor to set
     */
    public void setExecutor(TestExecutor executor) {
        this.executor = executor;
    }

    /**
     * @param configuration
     * @param executor
     */
    public TestSqlSession(TestConfiguration configuration, TestExecutor executor) {
        super();
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class<T> clazz) {
        return configuration.getMapper(clazz, this);
    }

    public <T> T selectOne(String sql, String params) {
        return executor.query(sql, params);
    }

}
