package fair.manage.domain;

/**
 * @version v1.0
 * @package fair.manage.domain
 * @auther fair
 * @date 2020-02-29 上午 9:22
 */
public class Salary {
    private int sid;
    private double base_pay;
    private int working_days;
    private double insurance;
    private double salary;
    private String id;

    @Override
    public String toString() {
        return "Salary{" +
                "sid=" + sid +
                ", base_pay=" + base_pay +
                ", working_days=" + working_days +
                ", insurance=" + insurance +
                ", salary=" + salary +
                ", id='" + id + '\'' +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public double getBase_pay() {
        return base_pay;
    }

    public void setBase_pay(double base_pay) {
        this.base_pay = base_pay;
    }

    public int getWorking_days() {
        return working_days;
    }

    public void setWorking_days(int working_days) {
        this.working_days = working_days;
    }

    public double getInsurance() {
        return insurance;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
