package fair.manage.dao;

import fair.manage.domain.Engineer;

/**
 * @version v1.0
 * @package fair.manage.dao
 * @auther fair
 * @date 2020-02-27 下午 16:45
 */
public interface EngineerDao {
    public void save(Engineer engineer);
    public Engineer find(String name);
    public void delete(String name);
    public void update(Engineer engineer);

}
