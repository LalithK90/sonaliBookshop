package lk.sonali.bookshop.asset.supplier.dao;

import lk.sonali.bookshop.asset.supplier.entity.Supplier;
import lk.sonali.bookshop.asset.supplierItem.entity.Enum.ItemSupplierStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierDao extends JpaRepository< Supplier, Integer> {
    Supplier findFirstByOrderByIdDesc();

    Supplier findByIdAndItemSupplierStatus(Integer supplierId, ItemSupplierStatus itemSupplierStatus);
}
