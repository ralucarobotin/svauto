package api.domain.store;

import java.math.BigDecimal;

public class Order {
    private BigDecimal id;
    private BigDecimal petId;
    private BigDecimal quantity;
    private String shipDate;
    private String status;
    private Boolean complete;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getPetId() {
        return petId;
    }

    public void setPetId(BigDecimal petId) {
        this.petId = petId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }
}