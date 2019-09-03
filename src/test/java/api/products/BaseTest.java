package api.products;

import java.io.IOException;

import org.testng.annotations.Test;

import api.apiwrappers.ProductApiWrapper;
import api.domain.catalog.product.Content;
import api.domain.catalog.product.Search;
import api.utils.catalog.ProductsUtils;


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

    @Test
    private void searchProduct(){
        Search payload = ProductsUtils.defaultSearch("Tartan");
    Content searchResponse = productApiWrapper.searchProduct(payload, page, size, Content.class);
    System.out.println(searchResponse.getContent().toString());
    }
}
