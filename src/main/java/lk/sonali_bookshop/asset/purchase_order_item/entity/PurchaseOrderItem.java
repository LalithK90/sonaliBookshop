package lk.sonali_bookshop.asset.purchase_order_item.entity;


import com.fasterxml.jackson.annotation.JsonFilter;
import lk.sonali_bookshop.asset.common_asset.model.enums.LiveDead;
import lk.sonali_bookshop.asset.item.entity.Item;
import lk.sonali_bookshop.asset.purchase_order.entity.PurchaseOrder;
import lk.sonali_bookshop.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "PurchaseOrderItem" )
public class PurchaseOrderItem extends AuditEntity {

    @Column( nullable = false )
    private String quantity;

    @Column( nullable = false, precision = 10, scale = 2 )
    private BigDecimal buyingPrice;

    @Column( nullable = false, precision = 10, scale = 2 )
    private BigDecimal lineTotal;

    @Enumerated( EnumType.STRING)
    private LiveDead liveDead;

    @ManyToOne
    private PurchaseOrder purchaseOrder;

    @ManyToOne
    private Item item;

}
