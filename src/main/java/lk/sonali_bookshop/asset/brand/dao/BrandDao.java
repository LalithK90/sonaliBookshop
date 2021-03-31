package lk.sonali_bookshop.asset.brand.dao;


;
import lk.sonali_bookshop.asset.brand.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandDao extends JpaRepository<Brand, Integer> {
}
