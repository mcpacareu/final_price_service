package com.finalprice.rest.service.finalpriceservice.app;

import org.springframework.stereotype.Repository;

import com.finalprice.rest.service.finalpriceservice.app.entities.Price;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface FinalPriceRepository extends JpaRepository<Price, Long> {

	@Query("SELECT p FROM Price p JOIN p.brand b  WHERE p.productId = :productId AND b.id = :brandId AND p.startDate <= :date AND p.endDate >= :date")
	List<Price> findPricesByProductIdAndBrandIdAndDateBetween(@Param("productId") Long productId,
			@Param("brandId") Long brandId, @Param("date") LocalDateTime date);

}
