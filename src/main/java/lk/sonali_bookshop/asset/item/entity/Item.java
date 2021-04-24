package lk.sonali_bookshop.asset.item.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import lk.sonali_bookshop.asset.author.entity.Author;
import lk.sonali_bookshop.asset.brand.entity.Brand;
import lk.sonali_bookshop.asset.category.entity.Category;
import lk.sonali_bookshop.asset.item_color.entity.ItemColor;
import lk.sonali_bookshop.asset.common_asset.model.enums.LiveDead;
import lk.sonali_bookshop.asset.item.entity.enums.ItemStatus;
import lk.sonali_bookshop.asset.ledger.entity.Ledger;
import lk.sonali_bookshop.asset.purchase_order_item.entity.PurchaseOrderItem;
import lk.sonali_bookshop.asset.supplier_item.entity.SupplierItem;
import lk.sonali_bookshop.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("Item")
public class Item extends AuditEntity {

    @Size( min = 5, message = "Your name cannot be accepted" )
    private String name;

    @NotEmpty
    private String rop;

    @Column( unique = true )
    private String code;

    @Column( unique = true )
    private String isbn;

    @Column( nullable = false, precision = 10, scale = 2 )
    private BigDecimal sellPrice;

    @Enumerated( EnumType.STRING )
    private ItemStatus itemStatus;

    @Enumerated(EnumType.STRING)
    private LiveDead liveDead;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private ItemColor itemColor;

    @OneToMany( mappedBy = "item" )
    private List< SupplierItem > supplierItem;

    @OneToMany( mappedBy = "item" )
    @JsonBackReference
    private List< Ledger > ledgers;

    @OneToMany( mappedBy = "item" )
    private List< PurchaseOrderItem > purchaseOrderItems;

    @ManyToMany
    @JoinTable(name = "item_author",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;
}
