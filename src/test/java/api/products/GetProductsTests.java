package api.products;

import api.domain.product.Content;
import api.wrappers.ProductApiWrapper;
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
    }
}
