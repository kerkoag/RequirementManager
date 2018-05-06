package geuylq.mobsoft.requirementmanager.model;

import com.orm.dsl.Table;

@Table
public class Account {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName = null;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password = null;
}
