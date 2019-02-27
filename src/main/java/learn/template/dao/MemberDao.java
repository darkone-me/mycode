package learn.template.dao;

import java.sql.ResultSet;
import java.util.List;

import learn.template.JDBCTemplate;
import learn.template.RowMapper;
import learn.template.entity.Member;

/**
 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2018年11月29日 上午10:34:34          Administrator        2.1         To create
 * </p>
 * 2018年11月29日 上午10:34:34          Administrator        2.1         modify parameters
 *
 * @since 
 * @see     
 */
public class MemberDao {

    private JDBCTemplate jdbc = new JDBCTemplate(null);

    public List<?> query() {
        String sql = "select * from t_member";
        return jdbc.executeQuery(sql, new RowMapper<Member>() {

            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws Exception {
                Member member = new Member();
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setAge(rs.getInt("age"));
                member.setAddr(rs.getString("addr"));
                return member;
            }

        }, null);
    }

}
