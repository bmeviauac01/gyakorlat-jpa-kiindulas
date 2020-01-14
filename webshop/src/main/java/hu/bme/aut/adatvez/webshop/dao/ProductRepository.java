package hu.bme.aut.adatvez.webshop.dao;

import hu.bme.aut.adatvez.webshop.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom{

	@Query("SELECT p FROM Product p WHERE p.category.name=:categoryName")
	List<Product> findByCategoryName(@Param("categoryName") String categoryName);
	
	List<Product> findByPriceGreaterThan(double limit);
}
