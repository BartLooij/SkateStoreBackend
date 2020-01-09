package skateStore.DAO;

import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import skateStore.mapper.UserMapper;
import skateStore.model.LoginUser;
import skateStore.model.RegistreerUser;
import skateStore.model.User;

public interface UserDAO {

    @SqlQuery("SELECT * FROM user WHERE email = :email AND password = :password")
    @Mapper(UserMapper.class)
    public User findUserByLoginCredentials(@BindBean LoginUser login);

    @SqlUpdate("INSERT INTO user (Email, Password, Name) " +
            "VALUES (:Email, :Password, :Name)")
    public void create(@BindBean RegistreerUser newUser);
}
