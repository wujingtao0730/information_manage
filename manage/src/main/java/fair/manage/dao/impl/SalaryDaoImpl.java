package fair.manage.dao.impl;

import fair.manage.dao.SalaryDao;
import fair.manage.domain.Engineer;
import fair.manage.domain.Salary;
import fair.manage.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @version v1.0
 * @package fair.manage.dao.impl
 * @auther fair
 * @date 2020-02-29 上午 10:18
 */
public class SalaryDaoImpl implements SalaryDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void save(Salary salary) {
        String sql = "insert into tab_salary (base_pay, working_days, insurance, salary, id) values(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,salary.getBase_pay(),
                salary.getWorking_days(),
                salary.getInsurance(),
                salary.getSalary(),
                salary.getId());
    }

    @Override
    public Salary findById(String id) {
        Salary salary = null;
        try {
            String sql = "select * from tab_salary where id = ?";
            salary = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Salary>(Salary.class), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return salary;
    }

    @Override
    public void update(Salary salary) {
        String sql = "update tab_salary set base_pay = ?, working_days = ?, insurance = ? , salary = ? where id = ?";
        jdbcTemplate.update(sql, salary.getBase_pay(),
                salary.getWorking_days(),
                salary.getInsurance(),
                salary.getSalary(),
                salary.getId());
    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from tab_salary where 1 = 1";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public List<Salary> findByPage(int start, int pageSize) {
        String sql ="select * from tab_salary order by id asc limit ?, ?";
        List<Salary> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Salary>(Salary.class), start, pageSize);
        return list;
    }

    @Override
    public void delete(String id) {
        String sql = "delete from tab_salary where id = ?";
        jdbcTemplate.update(sql, id);
    }
}
