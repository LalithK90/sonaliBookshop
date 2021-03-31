package lk.sonali_bookshop.asset.ledger.dao;


import lk.sonali_bookshop.asset.item.entity.Item;
import lk.sonali_bookshop.asset.ledger.entity.Ledger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LedgerDao extends JpaRepository< Ledger, Integer > {
  List< Ledger > findByItem(Item item);

  List< Ledger > findByCreatedAtBetween(LocalDateTime form, LocalDateTime to);

  Ledger findByItemAndSellPrice(Item item, BigDecimal sellPrice);
}
