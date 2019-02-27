package learn.template;

import java.sql.ResultSet;

/**
 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2018年11月29日 上午10:58:32          Administrator        2.1         To create
 * </p>
 * 2018年11月29日 上午10:58:32          Administrator        2.1         modify parameters
 *
 * @since 
 * @see     
 */
public interface RowMapper<T> {
    public T mapRow(ResultSet rs, int rowNum) throws Exception;
}
