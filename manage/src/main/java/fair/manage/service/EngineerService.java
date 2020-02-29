package fair.manage.service;

import fair.manage.domain.Engineer;
import fair.manage.domain.PageBean;

import java.util.List;

/**
 * @version v1.0
 * @package fair.manage.service
 * @auther fair
 * @date 2020-02-27 下午 16:46
 */
public interface EngineerService {
    /**
     * 保存数据
     * @param engineer
     * @return
     */
    boolean save(Engineer engineer);

    /**
     * 按照工号修改数据
     * @param engineer
     * @return
     */
    boolean update(Engineer engineer);

    /**
     * 删除数据
     * @param id
     * @return
     */
    boolean delete(String id);

    /**
     * 通过id查找数据
     * @param id
     * @return
     */
    Engineer findById(String id);

    /**
     * 查找所有的数据
     * @return
     */
    List<Engineer> findAll();

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<Engineer> pageQuery(int currentPage, int pageSize);

    /**
     * 根据名称分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<Engineer> pageQueryByName(int currentPage, int pageSize);

    /**
     * 根据工龄分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<Engineer> pageQueryByYears(int currentPage, int pageSize);

    /**
     * 跟新工资信息
     * @param id
     * @param salary
     */
    void updateSalary(String id, double salary);

    /**
     * 根据工资分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<Engineer> pageQueryBySalary(int currentPage, int pageSize);
}
