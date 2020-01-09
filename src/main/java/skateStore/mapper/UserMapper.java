package skateStore.mapper;

import skateStore.model.User;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper  implements ResultSetMapper<User>{
    @Override
    public User map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        User mappedUser = new User();
        mappedUser.setAccount_id(resultSet.getInt("Account_id"));
        mappedUser.setName(resultSet.getString("Name"));
        mappedUser.setEmail(resultSet.getString("Email"));
        mappedUser.setPassword(resultSet.getString("Password"));
        mappedUser.setAdmin_account(resultSet.getBoolean("Admin_account"));
        return mappedUser;
    }
}
