package fair.manage.dao;

import fair.manage.domain.User;

/**
 * @version v1.0
 * @package cn.itcast.travel.dao
 * @auther fair
 * @date 2020-02-07 下午 13:57
 */
public interface UserDao {
    public User findByUsername(String username);
    public void save(User user);

    public User findByCode(String code);

    public void updateStatus(User user);

    public User login(User user);
}
