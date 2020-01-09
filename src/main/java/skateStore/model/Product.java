package skateStore.model;

import javax.validation.constraints.NotNull;

public class Product {

    @NotNull
    private int Product_id;

    @NotNull
    private String Product_name;

    @NotNull
    private float Product_price;

    @NotNull
    private String Product_description;

    public int getProduct_id(){
        return Product_id;
    }

    public String getProduct_name(){
        return Product_name;
    }

    public float getProduct_price(){
        return Product_price;
    }

    public String getProduct_description(){
        return Product_description;
    }

    public void setProduct_id(int setAccount_id){
        this.Product_id = Product_id;
    }

    public void setProduct_name(String experiment_naam){
        this.Product_name = Product_name;
    }

    public void setProduct_price(String wijziging_datum){
        this.Product_price = Product_price;
    }

    public void setProduct_description(String fase){
        this.Product_description = Product_description;
    }

}
