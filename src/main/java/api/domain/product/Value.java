package api.domain.product;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Value {
    private String id;
    @JsonProperty("variant_id")
    private String variantId;
    private String name;
    @JsonProperty("display_order")
    private Integer displayOrder;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }
}
