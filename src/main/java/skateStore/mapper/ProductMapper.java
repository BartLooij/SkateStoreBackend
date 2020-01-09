package skateStore.mapper;

import skateStore.model.Product;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements ResultSetMapper<Product> {

    @Override
    public Product map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        Product mappedProduct = new Product();
        mappedProduct.setProduct_id(resultSet.getInt("Product_id"));
        mappedProduct.setProduct_name(resultSet.getString("Product_name"));
        mappedProduct.setProduct_price(resultSet.getString("Product_price"));
        mappedProduct.setProduct_description(resultSet.getString("Product_description"));
        return mappedProduct;
    }
}
