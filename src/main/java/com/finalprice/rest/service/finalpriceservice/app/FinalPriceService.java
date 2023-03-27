package com.finalprice.rest.service.finalpriceservice.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalprice.rest.service.finalpriceservice.app.entities.Price;
import com.finalprice.rest.service.finalpriceservice.app.dtos.PriceDTO;

@Service
public class FinalPriceService {

	@Autowired
	private FinalPriceRepository finalPriceRepository;

	public PriceDTO getFinalPriceByDateAndProductIdAndBrandId(String date, Long productId, Long brandId) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
		LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

		List<Price> prices = finalPriceRepository.findPricesByProductIdAndBrandIdAndDateBetween(productId, brandId,
				dateTime);
		PriceDTO maxPriorityPriceObject = new PriceDTO();

		if (prices.size() > 0) {
			Optional<Price> maxPriorityPrice = prices.stream().max(Comparator.comparingLong(Price::getPriority));
			if (maxPriorityPrice.isPresent()) {
				maxPriorityPriceObject = mapPriceToPriceDTO(maxPriorityPrice.get());
			}
		}
		return maxPriorityPriceObject;
	}

	private PriceDTO mapPriceToPriceDTO(Price price) {
		return new PriceDTO(price.getId(), price.getStartDate(), price.getEndDate(), price.getPriceList(),
				price.getProductId(), price.getPriority(), price.getPrice(), price.getCurr(), price.getBrand().getId());
	}
}
