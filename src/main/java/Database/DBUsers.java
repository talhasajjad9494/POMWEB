package Database;

import Base.BaseDriver;

import java.sql.SQLException;

public class DBUsers extends BaseDriver {
    public String userEmail() throws SQLException {
        String getUserEmail = "SELECT * FROM fantacy4.fc_users WHERE username = 'demoAlmas101';";
        return dbQuery(getUserEmail,"email");
    }
}
