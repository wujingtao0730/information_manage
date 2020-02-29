package fair.manage.domain;

/**
 * @version v1.0
 * @package fair.manage.domain
 * @auther fair
 * @date 2020-02-29 上午 11:14
 */
public class EngineerSalary {
    private String id; //工程师工号
    private String name; //工程师姓名
    private String education; //学历
    private String telephone; //电话号码
    private int working_years; //工龄
    private double salary; //薪水
    private double base_pay; //基本工资
    private int working_days; //工作天数
    private double insurance; //保险金

    @Override
    public String toString() {
        return "EngineerSalary{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", education='" + education + '\'' +
                ", telephone='" + telephone + '\'' +
                ", working_years=" + working_years +
                ", salary=" + salary +
                ", base_pay=" + base_pay +
                ", working_days=" + working_days +
                ", insurance=" + insurance +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getWorking_years() {
        return working_years;
    }

    public void setWorking_years(int working_years) {
        this.working_years = working_years;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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
}
