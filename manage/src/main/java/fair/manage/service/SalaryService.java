package fair.manage.service;

import fair.manage.domain.Engineer;
import fair.manage.domain.EngineerSalary;
import fair.manage.domain.PageBean;
import fair.manage.domain.Salary;

/**
 * @version v1.0
 * @package fair.manage.service
 * @auther fair
 * @date 2020-02-29 上午 9:45
 */
public interface SalaryService {
    /**
     * 计算工资
     * @param id
     * @return
     */
    double calculate(Salary id);

    /**
     * 保存工资信息
     * @param salary
     */
    void save(Salary salary);

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<EngineerSalary> pageQuery(int currentPage, int pageSize);

    /**
     * 通过engineer的信息在数据库中创建基本工资信息
     * @param engineer
     */
    void create(Engineer engineer);

    /**
     * 删除信息
     * @param id
     */
    void delete(String id);

    /**
     * 更新信息
     * @param engineer
     */
    void update(Engineer engineer);
}
