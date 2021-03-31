package lk.sonali_bookshop.asset.ledger.entity;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lk.sonali_bookshop.asset.common_asset.model.enums.LiveDead;
import lk.sonali_bookshop.asset.good_received_note.entity.GoodReceivedNote;
import lk.sonali_bookshop.asset.invoice_ledger.entity.InvoiceLedger;
import lk.sonali_bookshop.asset.item.entity.Item;
import lk.sonali_bookshop.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "Ledger" )
public class Ledger extends AuditEntity {

    @NotEmpty
    private String quantity;

    @Column( nullable = false, precision = 10, scale = 2 )
    private BigDecimal sellPrice;


    @Enumerated( EnumType.STRING)
    private LiveDead liveDead;

    @ManyToOne(fetch=FetchType.EAGER)
    private Item item;

    @ManyToOne
    @JsonIgnore
    private GoodReceivedNote goodReceivedNote;


    @OneToMany(mappedBy = "ledger")
    private List< InvoiceLedger > invoiceLedgers;


}
