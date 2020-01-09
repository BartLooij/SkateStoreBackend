package skateStore.DAO;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import skateStore.mapper.ProductMapper;
import skateStore.model.Product;


import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.SqlQuery;


import java.util.List;

public interface ProductDAO {

    @SqlQuery("SELECT * FROM Product")
    @Mapper(ProductMapper.class)
    public List<Product> getAll();

    @SqlUpdate("DELETE FROM Product WHERE Product_id = :id")
    public void delete(@Bind("id")int id);

    @SqlUpdate("INSERT INTO Product (Product_name, Product_id, Product_price, Product_description) " +
            "VALUES (:Product_name, :Product_id, :Product_price, :Product_description);")
    public void add(@BindBean Product newProduct);

    @SqlQuery("SELECT LAST_INSERT_ID();")
    public int lastInsert();
}
