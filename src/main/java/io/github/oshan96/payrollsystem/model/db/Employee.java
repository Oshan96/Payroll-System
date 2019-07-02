package io.github.oshan96.payrollsystem.model.db;

/**
 * @author oshan
 */
public class Employee extends DBModel{
    private String id;
    private String name;
    private String address;
    private String nic;
    private String dob;
    private Post post;

    public Employee() {
    }

    public Employee(String id, String name, String address, String nic, String dob) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.nic = nic;
        this.dob = dob;
    }

    public Employee(String id, String name, String address, String nic, String dob, Post post) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.nic = nic;
        this.dob = dob;
        this.post = post;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", nic='" + nic + '\'' +
                ", dob='" + dob + '\'' +
                ", post=" + post +
                '}';
    }
}
