package learn.TestMybatis;

/**
 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2019年1月11日 上午10:25:47          Administrator        2.1         To create
 * </p>
 * 2019年1月11日 上午10:25:47          Administrator        2.1         modify parameters
 *
 * @since 
 * @see     
 */
public interface TestExecutor {

    /**
     * @param sql
     * @param params
     * @return
    	* @author tsj
    	* @Date 2019年1月11日上午11:22:41
     */
    public <T> T query(String sql, String params);

}
