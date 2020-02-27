package fair.manage.dao.impl;

import fair.manage.dao.UserDao;
import fair.manage.domain.User;
import fair.manage.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * @version v1.0
 * @package cn.itcast.travel.dao.impl
 * @auther fair
 * @date 2020-02-07 下午 13:57
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 通过用户名查找用户信息
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            String sql = "select * from tab_user where username = ?";
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (DataAccessException e) {
        }
        return user;
    }

    /**
     * 存储用户信息
     * @param user
     */
    @Override
    public void save(User user) {
        String sql = "insert into tab_user(username, password, name, birthday, sex, telephone, email, status, code) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getBirthday(),
                user.getSex(),
                user.getTelephone(),
                user.getEmail(),
                user.getStatus(),
                user.getCode()
        );
    }

    /**
     * 根据激活码查询用户对象
     * @param code
     * @return
     */
    @Override
    public User findByCode(String code) {
        User user = null;
        try {
            String sql = "select * from tab_user where code = ?";
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), code);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 修改指定用户激活状态
     * @param user
     */
    @Override
    public void updateStatus(User user) {
        String sql = "update tab_user set status = 'Y' where uid = ?";
        jdbcTemplate.update(sql, user.getUid());
    }

    /**
     * 判断用户是否登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        User u = null;
        try {
            String sql = "select * from tab_user where username = ? and password = ?";
            u = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
        } catch (DataAccessException e) {
        }
        return u;
    }


}
