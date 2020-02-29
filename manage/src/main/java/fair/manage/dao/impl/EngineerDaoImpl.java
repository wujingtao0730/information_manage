package fair.manage.dao.impl;

import fair.manage.dao.EngineerDao;
import fair.manage.domain.Engineer;
import fair.manage.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

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
        String sql = "insert into tab_engineer(id, name, sex, birthday, address, education, telephone, working_years, salary) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, engineer.getId(),
                engineer.getName(),
                engineer.getSex(),
                engineer.getBirthday(),
                engineer.getAddress(),
                engineer.getEducation(),
                engineer.getTelephone(),
                engineer.getWorking_years(),
                engineer.getSalary()
        );
    }

    @Override
    public void delete(String id) {
        String sql = "delete from tab_engineer where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(Engineer engineer) {
        String sql = "update tab_engineer set name = ?, sex = ?, birthday = ?, address = ?, education = ?, telephone = ?, working_years = ?, salary = ? where id = ?";
        jdbcTemplate.update(sql, engineer.getName(),
                engineer.getSex(),
                engineer.getBirthday(),
                engineer.getAddress(),
                engineer.getEducation(),
                engineer.getTelephone(),
                engineer.getWorking_years(),
                engineer.getSalary(),
                engineer.getId()
        );
    }

    @Override
    public Engineer findById(String id) {
        Engineer engineer = null;
        try {
            String sql = "select * from tab_engineer where id = ?";
            engineer = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Engineer>(Engineer.class), id);
        } catch (DataAccessException e) {
        }
        return engineer;
    }

    @Override
    public List<Engineer> findAll() {
        String sql = "select * from tab_engineer";
        List<Engineer> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Engineer>(Engineer.class));
        return list;
    }

    @Override
    public List<Engineer> findByPage(int start, int pageSize) {
        String sql ="select * from tab_engineer limit ?, ?";
        List<Engineer> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Engineer>(Engineer.class), start, pageSize);
        return list;
    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from tab_engineer where 1 = 1";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public List<Engineer> findOrderByName(int start, int pageSize) {
        String sql ="select * from tab_engineer order by name desc limit ?, ?";
        List<Engineer> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Engineer>(Engineer.class), start, pageSize);
        return list;
    }

    @Override
    public List<Engineer> findOrderByYears(int start, int pageSize) {
        String sql ="select * from tab_engineer order by working_years desc limit ?, ?";
        List<Engineer> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Engineer>(Engineer.class), start, pageSize);
        return list;
    }

    @Override
    public void updateSalary(String id, double salary) {
        String sql = "update tab_engineer set salary = ? where id = ?";
        jdbcTemplate.update(sql, salary, id);
    }

    @Override
    public List<Engineer> findOrderBySalary(int start, int pageSize) {
        String sql ="select * from tab_engineer order by salary desc limit ?, ?";
        List<Engineer> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Engineer>(Engineer.class), start, pageSize);
        return list;
    }
}
