package learn.template;

import learn.template.dao.MemberDao;

/**
 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2018年11月29日 上午10:41:22          Administrator        2.1         To create
 * </p>
 * 2018年11月29日 上午10:41:22          Administrator        2.1         modify parameters
 *
 * @since 
 * @see     
 */
public class MemberDaoTest {
    public static void main(String[] args) {

        MemberDao memberDao = new MemberDao();
        memberDao.query();
    }
}
