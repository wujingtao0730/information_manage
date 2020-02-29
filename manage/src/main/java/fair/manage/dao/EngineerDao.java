package fair.manage.dao;

import fair.manage.domain.Engineer;

import java.util.List;

/**
 * @version v1.0
 * @package fair.manage.dao
 * @auther fair
 * @date 2020-02-27 下午 16:45
 */
public interface EngineerDao {
    /**
     * 保存信息
     * @param engineer
     */
    void save(Engineer engineer);

    /**
     * 根据id删除信息
     * @param id
     */
    void delete(String id);

    /**
     * 根据Id更新信息
     * @param engineer
     */
    void update(Engineer engineer);

    /**
     * 通过id查找信息
     * @param id
     * @return
     */
    Engineer findById(String id);

    /**
     * 查找所以信息
     * @return
     */
    List<Engineer> findAll();

    /**
     * 分页查询
     * @param start
     * @param pageSize
     * @return
     */
    List<Engineer> findByPage(int start, int pageSize);

    /**
     * 查询总记录数
     * @return
     */
    int findTotalCount();

    /**
     * 根据name排序
     * @return
     */
    List<Engineer> findOrderByName(int start, int pageSize);

    /**
     * 根据工龄排序
     * @return
     */
    List<Engineer> findOrderByYears(int start, int pageSize);

    /**
     * 跟新工作信息
     * @param id
     * @param salary
     */
    void updateSalary(String id, double salary);

    /**
     * 根据薪水排序
     * @param start
     * @param pageSize
     * @return
     */
    List<Engineer> findOrderBySalary(int start, int pageSize);
}
