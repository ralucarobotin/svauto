package api.domain.product;

import java.util.List;

public class Variant {
    private String id;
    private String product_id;
    private String name;
    private Boolean visual;
    private List<Value> values;
    private Integer display_order;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
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

    public Integer getDisplay_order() {
        return display_order;
    }

    public void setDisplay_order(Integer display_order) {
        this.display_order = display_order;
    }
}
