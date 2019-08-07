package api.apiwrappers;

import api.CommonApiWrapper;
import api.domain.product.Content;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.message.BasicHeader;

public class ProductApiWrapper extends CommonApiWrapper {

    public Content getProducts(Content content) {
        Header[] headers = {
                new BasicHeader("X-Violet-App-Secret", "60159de73a794d4089b0aabee2836891")
                , new BasicHeader("X-Violet-App-Id", "10062")
                , new BasicHeader("X-Violet-Token", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJxYXdvcmtzaG9wc3ZAZ21haWwuY29tIiwic2NvcGVzIjpbIlJPTEVfREVWRUxPUEVSIl0sInVzZXJfaWQiOjEwMTUxLCJ1c2VyX3R5cGUiOiJERVZFTE9QRVIiLCJtZXJjaGFudF9pZHMiOltdLCJkZXZlbG9wZXJfaWQiOjEwMDcxLCJhcHBfaWQiOiIxMDA2MiIsImlzcyI6Imh0dHBzOi8vdmlvbGV0LmlvIiwiaWF0IjoxNTY1MTczNDcyLCJleHAiOjE1NjUyNTk4NzJ9.k9CGBV6TRW4ne7UuluGaj0yCcTx2qg9MxuTLTp0qP7dO19NSesntSybpaIJXmjffbbE9uEjZwx-waU4ReBItiw")
                , new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json")
        };
        String endpoint = "https://sandbox-api.violet.io/v1/catalog/products?page=1&size=20";
        return (Content) get(content, endpoint, headers);
    }
}
