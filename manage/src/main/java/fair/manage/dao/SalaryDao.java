package fair.manage.dao;

import fair.manage.domain.Salary;

import java.util.List;

/**
 * @version v1.0
 * @package fair.manage.dao
 * @auther fair
 * @date 2020-02-29 上午 10:17
 */
public interface SalaryDao {
    /**
     * 保存工资信息
     * @param salary
     */
    void save(Salary salary);

    /**
     * 根据id查找工资记录
     * @param id
     * @return
     */
    Salary findById(String id);

    /**
     * 跟新工资信息
     * @param salary
     */
    void update(Salary salary);

    /**
     * 查找总记录数
     * @return
     */
    int findTotalCount();

    /**
     * 分页查找
     * @param start
     * @param pageSize
     * @return
     */
    List<Salary> findByPage(int start, int pageSize);

    /**
     * 根据Id删除
     * @param id
     */
    void delete(String id);
}
