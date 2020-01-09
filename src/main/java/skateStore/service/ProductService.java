package skateStore.service;

import skateStore.DAO.ProductDAO;
import skateStore.model.Product;

import javax.inject.Inject;
import java.util.List;

public class ProductService extends BaseService<Product>{

    private final ProductDAO dao;

    @Inject
    public ProductService(ProductDAO dao) {
        this.dao = dao;
    }

    public List<Product> getAll() {
        System.out.println("getting");
        List<Product> productList = dao.getAll();
        System.out.println(productList.toString());
        return productList;
    }

    public int add(Product product) {
        dao.add(product);
        return dao.lastInsert();
    }

    public void delete(int id) {
        dao.delete(id);
    }

}
