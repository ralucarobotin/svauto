package api.utils.catalog;

import api.domain.catalog.product.Search;

public class ProductsUtils {

  public static Search defaultSearch(String query){
    Search search = new Search();
    search.setQuery(query);
    return search;
  }
}
