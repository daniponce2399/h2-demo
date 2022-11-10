package h2demo.reporsitory;

import h2demo.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query(value = "Select  brand_id, start_date, end_date, price_list, product_id, price "+
            "from Products " +
            "where Brand_id = ?1 and product_id = ?2 and ?3 between start_date and End_date group by start_date order " +
            "by priority desc limit 1;" , nativeQuery = true)
    ProductEntity findByBrandIdAndProductIdAndDate(Integer brandId, Integer productId, String date);
}
