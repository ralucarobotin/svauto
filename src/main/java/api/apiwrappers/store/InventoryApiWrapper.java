package api.apiwrappers.store;

import java.io.IOException;

import api.CommonApiWrapper;

public class InventoryApiWrapper  extends CommonApiWrapper {

  private final String inventoryPath = "/v2/store/inventory/";

  public void getInventory() throws IOException {
    String endpoint = baseUrl + inventoryPath;

    //return get(endpoint);
  }
}