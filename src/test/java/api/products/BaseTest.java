package api.products;

import java.io.IOException;

import api.apiwrappers.ProductApiWrapper;
import api.domain.product.Content;
import org.testng.annotations.Test;


public class BaseTest {

    private static final ProductApiWrapper productApiWrapper = new ProductApiWrapper();

    @Test
    private void VerifyThatGetCallIsSuccessfullyPerformed() throws IOException {

        //Get products via GET call
        Content getResponseOrder = productApiWrapper.getProducts(new Content());
        System.out.println(getResponseOrder.getContent().toString());
    }
}
