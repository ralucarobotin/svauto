package api.domain.pets;

import com.sun.org.apache.xml.internal.resolver.Catalog;

import java.math.BigDecimal;
import java.util.List;

public class Pet {
    private BigDecimal id;
    private List<Category> category;
    private String name;
    private List<Tags> tags;
    private String status;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}