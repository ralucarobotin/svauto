package api.domain.product;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Variant {
    private String id;
    @JsonProperty("product_id")
    private String productId;
    private String name;
    private Boolean visual;
    private List<Value> values;
    @JsonProperty("display_order")
    private Integer displayOrder;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getVisual() {
        return visual;
    }

    public void setVisual(Boolean visual) {
        this.visual = visual;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }
}
