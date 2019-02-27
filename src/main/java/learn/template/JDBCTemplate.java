package learn.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

/**
 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2018年11月29日 上午10:11:57          Administrator        2.1         To create
 * </p>
 * 2018年11月29日 上午10:11:57          Administrator        2.1         modify parameters
 *
 * @since 
 * @see     
 */
public class JDBCTemplate {

    private DataSource dataSource;

    public JDBCTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取连接
     * @return
     * @throws Exception
    	* @author tsj
    	* @Date 2018年11月29日上午10:51:54
     */
    private Connection getConnection() throws Exception {
        return this.dataSource.getConnection();
    }

    /**
     * 创建语句集
     * @param conn
     * @param sql
     * @return
     * @throws Exception
    	* @author tsj
    	* @Date 2018年11月29日上午10:52:01
     */
    private PreparedStatement createPreparedStatement(Connection conn, String sql) throws Exception {
        return conn.prepareStatement(sql);
    }

    /**
     * 获取结果集
     * @param pstm
     * @param values
     * @return
     * @throws Exception
    	* @author tsj
    	* @Date 2018年11月29日上午10:52:15
     */
    private ResultSet executeQuery(PreparedStatement pstm, Object[] values) throws Exception {
        for (int i = 0; i < values.length; i++) {
            pstm.setObject(i, values[i]);
        }
        return pstm.executeQuery();
    }

    /**
     * 关闭结果集
     * @param rs
     * @throws Exception
    	* @author tsj
    	* @Date 2018年11月29日上午10:54:04
     */
    private void closeResult(ResultSet rs) throws Exception {
        rs.close();
    }

    /**
     * 关闭语句集
     * @param stmt
     * @throws Exception
    	* @author tsj
    	* @Date 2018年11月29日上午10:52:25
     */
    private void closeStatement(Statement stmt) throws Exception {
        stmt.close();
    }

    /**
     * 关闭连接
     * @param conn
     * @throws Exception
    	* @author tsj
    	* @Date 2018年11月29日上午10:53:54
     */
    private void closeConnection(Connection conn) throws Exception {
        //通常会放回连接池中
        conn.close();
    }

    private List<?> parseResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<>();
        int rowNum = 1;
        while (rs.next()) {
            Object object = rowMapper.mapRow(rs, rowNum++);
            result.add(object);
        }
        return result;
    }

    /**
     * 执行sql 返回结果
     * @param sql
     * @param values
     * @return
    	* @author tsj
    	* @Date 2018年11月29日上午10:18:40
     */
    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) {
        try {
            //1、获取连接
            Connection conn = this.getConnection();
            //2、创建语句集
            PreparedStatement pstm = this.createPreparedStatement(conn, sql);
            //3、执行语句集，并获得结果集
            ResultSet rs = this.executeQuery(pstm, null);
            //4、解析语句集
            List<?> result = this.parseResultSet(rs, rowMapper);
            //5、关闭结果集
            this.closeResult(rs);
            //6、关闭语句集
            this.closeStatement(pstm);
            //7、关闭连接
            this.closeConnection(conn);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
