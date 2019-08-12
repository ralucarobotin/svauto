package api.products;

import api.apiwrappers.ProductApiWrapper;
import api.domain.product.Content;
import org.testng.annotations.Test;

import java.io.IOException;


public class BaseTest {

    private static final ProductApiWrapper productApiWrapper = new ProductApiWrapper();
    String page = "1";
    String size = "20";

    @Test
    private void VerifyThatGetCallIsSuccessfullyPerformed() throws IOException {

        //Get products via GET call
        Content getResponseOrder = productApiWrapper.getProducts(new Content(), page,size);
        System.out.println(getResponseOrder.getContent().toString());
    }
}
