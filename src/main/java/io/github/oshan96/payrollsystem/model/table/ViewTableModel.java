package io.github.oshan96.payrollsystem.model.table;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author oshan
 */
public class ViewTableModel {
    private String id = "";
    private String name = "";
    private String nic= "";
    private String dob = "";
    private String address = "";

    public ViewTableModel() {
    }

    public ViewTableModel(String id, String name, String nic, String dob, String address) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.dob = dob;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
