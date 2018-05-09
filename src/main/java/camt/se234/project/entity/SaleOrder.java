package camt.se234.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String saleOrderId;

    public SaleOrder(long id, String saleOrderId){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SaleOrder)) return false;
        if (!super.equals(o)) return false;

        SaleOrder saleOrder = (SaleOrder) o;

        if (getId() != null ? !getId().equals(saleOrder.getId()) : saleOrder.getId() != null) return false;
        if (getSaleOrderId() != null ? !getSaleOrderId().equals(saleOrder.getSaleOrderId()) : saleOrder.getSaleOrderId() != null)
            return false;
        return getTransactions() != null ? getTransactions().equals(saleOrder.getTransactions()) : saleOrder.getTransactions() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getSaleOrderId() != null ? getSaleOrderId().hashCode() : 0);
        result = 31 * result + (getTransactions() != null ? getTransactions().hashCode() : 0);
        return result;
    }

    @Builder.Default
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<SaleTransaction> transactions = new ArrayList<>();
    public double getTotalPrice(){
        double totalPrice = 0;
        for (SaleTransaction transaction :
                transactions) {
            totalPrice += transaction.getAmount() * transaction.getProduct().getPrice();
        }
        return totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(String saleOrderId) {
        this.saleOrderId = saleOrderId;
    }
}
