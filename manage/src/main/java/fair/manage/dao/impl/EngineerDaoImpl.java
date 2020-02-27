package fair.manage.dao.impl;

import fair.manage.dao.EngineerDao;
import fair.manage.domain.Engineer;
import fair.manage.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @version v1.0
 * @package fair.manage.dao.impl
 * @auther fair
 * @date 2020-02-27 下午 16:45
 */
public class EngineerDaoImpl implements EngineerDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void save(Engineer engineer) {
        String sql = "insert into tab_engineer(username, password, name, birthday, sex, telephone, email, status, code) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    }

    @Override
    public Engineer find(String name) {
        return null;
    }

    @Override
    public void delete(String name) {

    }

    @Override
    public void update(Engineer engineer) {

    }
}
