package api.products;

import api.wrappers.ProductApiWrapper;
import api.domain.product.Content;
import api.domain.product.Search;
import api.utils.ProductsUtils;
import org.testng.annotations.Test;

public class SearchProductsTests {

    private static final ProductApiWrapper productApiWrapper = new ProductApiWrapper();
    private String page = "1";
    private String size = "20";

    @Test
    public void searchOneProduct() {
        Search payload = ProductsUtils.defaultSearch("Tartan");
        Content searchResponse = productApiWrapper.searchProduct(payload, page, size);
        System.out.println(searchResponse.getContent().toString());
    }
}
