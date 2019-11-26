package api.products;

import api.domain.product.Content;
import api.domain.product.Products;
import api.wrappers.ProductApiWrapper;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetProductsTests {

    private static final ProductApiWrapper productApiWrapper = new ProductApiWrapper();
    private String page = "1";
    private String size = "20";

    @Test
    public void getAllProducts() {
        Content getResponseOrder = productApiWrapper.getProducts(new Content(), page, size);
        Assert.assertTrue(!getResponseOrder.getContent().isEmpty(), "response body is empty");
        Assert.assertEquals(productApiWrapper.statusCode, HttpStatus.SC_OK, "incorrect error code");
    }

    @Test
    public void getProductById() {
        Content getResponseOrder  = productApiWrapper.getProducts(new Content(), page, size);
        String productId = getResponseOrder.getContent().get(0).getId();
        productApiWrapper.getProductsById(new Products(), productId);
        Assert.assertEquals(productApiWrapper.statusCode, HttpStatus.SC_OK, "incorrect error code");
    }
}
