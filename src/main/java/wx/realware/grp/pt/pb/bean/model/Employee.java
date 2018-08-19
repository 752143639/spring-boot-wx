package wx.realware.grp.pt.pb.bean.model;

import org.hibernate.validator.constraints.NotBlank;
import wx.realware.grp.pt.pb.common.avlid.group.AddGroup;
import wx.realware.grp.pt.pb.common.avlid.group.UpdateGroup;

import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String email;
  //  @NotBlank(message = "用户名不能为空")
    private String lastName;
    private int gender;
    private int  d_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", d_id=" + d_id +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
