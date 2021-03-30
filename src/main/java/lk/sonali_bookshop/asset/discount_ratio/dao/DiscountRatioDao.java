package lk.sonali_bookshop.asset.discount_ratio.dao;


import lk.sonali_bookshop.asset.discount_ratio.entity.DiscountRatio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRatioDao extends JpaRepository< DiscountRatio, Integer > {
}
