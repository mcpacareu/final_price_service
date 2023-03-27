package com.finalprice.rest.service.finalpriceservice.app.tests;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.finalprice.rest.service.finalpriceservice.app.FinalPriceController;
import com.finalprice.rest.service.finalpriceservice.app.FinalPriceService;
import com.finalprice.rest.service.finalpriceservice.app.dtos.PriceDTO;
import com.finalprice.rest.service.finalpriceservice.app.enums.Currency;

@RunWith(JUnit4.class)
@SpringBootTest
public class FinalPriceControllerTest {

	@Mock
	private FinalPriceService finalPriceService;

	@InjectMocks
	private FinalPriceController finalPriceController;

	@ParameterizedTest
	@ValueSource(strings = { "2020-06-14-10.00.00", "2020-06-14-16.00.00", "2020-06-14-21.00.00", "2020-06-15-10.00.00",
			"2020-06-16-21.00.00" })
	public void testGetFinalPrice(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
		LocalDateTime startDate = LocalDateTime.parse("2020-06-14-00.00.00", formatter);
		LocalDateTime endDate = LocalDateTime.parse("2020-12-31-23.59.59", formatter);
		long productId = 35455L;
		long brandId = 1L;
		PriceDTO expectedPrice = new PriceDTO(1L, startDate, endDate, 1L, productId, 0, new BigDecimal(35.50),
				Currency.EUR, brandId);

		when(finalPriceService.getFinalPriceByDateAndProductIdAndBrandId(date, productId, brandId))
				.thenReturn(expectedPrice);

		ResponseEntity<PriceDTO> response = finalPriceController.getFinalPrice(date, productId, brandId);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(expectedPrice, response.getBody());
	}
}
