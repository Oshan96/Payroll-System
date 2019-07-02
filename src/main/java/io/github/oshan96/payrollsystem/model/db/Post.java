package io.github.oshan96.payrollsystem.model.db;

/**
 * @author oshan
 */
public class Post extends DBModel{
    private String id;
    private double basicSalary;
    private double hourlyRate;

    public Post() {
    }

    public Post(String id, double basicSalary, double hourlyRate) {
        this.id = id;
        this.basicSalary = basicSalary;
        this.hourlyRate = hourlyRate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", basicSalary=" + basicSalary +
                ", hourlyRate=" + hourlyRate +
                '}';
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
