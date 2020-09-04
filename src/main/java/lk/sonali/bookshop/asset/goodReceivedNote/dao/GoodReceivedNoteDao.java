package lk.sonali.bookshop.asset.goodReceivedNote.dao;

import lk.sonali.bookshop.asset.PurchaseOrder.entity.PurchaseOrder;
import lk.sonali.bookshop.asset.goodReceivedNote.entity.GoodReceivedNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodReceivedNoteDao extends JpaRepository< GoodReceivedNote, Integer> {
    GoodReceivedNote findByPurchaseOrder(PurchaseOrder purchaseOrder);
}
