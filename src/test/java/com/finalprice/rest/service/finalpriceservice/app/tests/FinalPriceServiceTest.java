package com.finalprice.rest.service.finalpriceservice.app.tests;

import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

import com.finalprice.rest.service.finalpriceservice.app.FinalPriceService;
import com.finalprice.rest.service.finalpriceservice.app.dtos.PriceDTO;
import com.finalprice.rest.service.finalpriceservice.app.entities.Price;
import com.finalprice.rest.service.finalpriceservice.app.enums.Currency;
import com.finalprice.rest.service.finalpriceservice.app.entities.Brand;
import com.finalprice.rest.service.finalpriceservice.app.FinalPriceRepository;

@RunWith(JUnit4.class)
@SpringBootTest
public class FinalPriceServiceTest {

	@Mock
	private FinalPriceRepository finalPriceRepository;

	@InjectMocks
	private FinalPriceService finalPriceService;

	private List<Price> prices;
	private Price price1;
	private Price price2;
	private Price price3;
	private Price price4;
	private Long productId = 35455L;
	private Brand brand = new Brand();
	private DateTimeFormatter formatter;

	@BeforeEach
	public void setUp() {
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
		brand.setId(1L);
		prices = new ArrayList<>();

		price1 = new Price();
		price1.setCurr(Currency.EUR);
		price1.setStartDate(LocalDateTime.parse("2020-06-14-00.00.00", formatter));
		price1.setEndDate(LocalDateTime.parse("2020-12-31-23.59.59", formatter));
		price1.setProductId(productId);
		price1.setPriceList(1L);
		price1.setBrand(brand);
		price1.setPriority(0);
		price1.setPrice(new BigDecimal(35.50));

		price2 = new Price();
		price2.setCurr(Currency.EUR);
		price2.setStartDate(LocalDateTime.parse("2020-06-14-15.00.00", formatter));
		price2.setEndDate(LocalDateTime.parse("2020-06-14-18.30.00", formatter));
		price2.setProductId(productId);
		price2.setPriceList(2L);
		price2.setBrand(brand);
		price2.setPriority(1);
		price2.setPrice(new BigDecimal(25.45));

		price3 = new Price();
		price3.setCurr(Currency.EUR);
		price3.setStartDate(LocalDateTime.parse("2020-06-15-00.00.00", formatter));
		price3.setEndDate(LocalDateTime.parse("2020-06-15-11.00.00", formatter));
		price3.setProductId(productId);
		price3.setPriceList(3L);
		price3.setBrand(brand);
		price3.setPriority(1);
		price3.setPrice(new BigDecimal(30.50));

		price4 = new Price();
		price4.setCurr(Currency.EUR);
		price4.setStartDate(LocalDateTime.parse("2020-06-15-16.00.00", formatter));
		price4.setEndDate(LocalDateTime.parse("2020-12-31-23.59.59", formatter));
		price4.setProductId(productId);
		price4.setPriceList(4L);
		price4.setBrand(brand);
		price4.setPriority(1);
		price4.setPrice(new BigDecimal(38.95));
	}

	@Test
	public void testGetFinalPriceByDateAndProductIdAndBranchId_date2020_06_14_10() {
		prices.add(price1);

		when(finalPriceRepository.findPricesByProductIdAndBrandIdAndDateBetween(productId, brand.getId(),
				LocalDateTime.parse("2020-06-14-10.00.00", formatter))).thenReturn(prices);

		PriceDTO result = finalPriceService.getFinalPriceByDateAndProductIdAndBrandId("2020-06-14-10.00.00", productId,
				brand.getId());

		assertEquals(price1.getCurr(), result.getCurr());
		assertEquals(price1.getStartDate(), result.getStartDate());
		assertEquals(price1.getEndDate(), result.getEndDate());
		assertEquals(price1.getProductId(), result.getProductId());
		assertEquals(price1.getPriceList(), result.getPriceList());
		assertEquals(price1.getBrand().getId(), result.getBrandId());
		assertEquals(price1.getPriority(), result.getPriority());
		assertEquals(price1.getPrice(), result.getPrice());
	}

	@Test
	public void testGetFinalPriceByDateAndProductIdAndBranchId_date2020_06_14_16() {
		prices = List.of(price1, price2);

		when(finalPriceRepository.findPricesByProductIdAndBrandIdAndDateBetween(productId, brand.getId(),
				LocalDateTime.parse("2020-06-14-16.00.00", formatter))).thenReturn(prices);

		PriceDTO result = finalPriceService.getFinalPriceByDateAndProductIdAndBrandId("2020-06-14-16.00.00", productId,
				brand.getId());

		assertEquals(price2.getCurr(), result.getCurr());
		assertEquals(price2.getStartDate(), result.getStartDate());
		assertEquals(price2.getEndDate(), result.getEndDate());
		assertEquals(price2.getProductId(), result.getProductId());
		assertEquals(price2.getPriceList(), result.getPriceList());
		assertEquals(price2.getBrand().getId(), result.getBrandId());
		assertEquals(price2.getPriority(), result.getPriority());
		assertEquals(price2.getPrice(), result.getPrice());
	}

	@Test
	public void testGetFinalPriceByDateAndProductIdAndBranchId_date2020_06_14_21() {
		prices.add(price1);

		when(finalPriceRepository.findPricesByProductIdAndBrandIdAndDateBetween(productId, brand.getId(),
				LocalDateTime.parse("2020-06-14-21.00.00", formatter))).thenReturn(prices);

		PriceDTO result = finalPriceService.getFinalPriceByDateAndProductIdAndBrandId("2020-06-14-21.00.00", productId,
				brand.getId());

		assertEquals(price1.getCurr(), result.getCurr());
		assertEquals(price1.getStartDate(), result.getStartDate());
		assertEquals(price1.getEndDate(), result.getEndDate());
		assertEquals(price1.getProductId(), result.getProductId());
		assertEquals(price1.getPriceList(), result.getPriceList());
		assertEquals(price1.getBrand().getId(), result.getBrandId());
		assertEquals(price1.getPriority(), result.getPriority());
		assertEquals(price1.getPrice(), result.getPrice());
	}

	@Test
	public void testGetFinalPriceByDateAndProductIdAndBranchId_date2020_06_15_10() {
		prices = List.of(price1, price3);

		when(finalPriceRepository.findPricesByProductIdAndBrandIdAndDateBetween(productId, brand.getId(),
				LocalDateTime.parse("2020-06-15-10.00.00", formatter))).thenReturn(prices);

		PriceDTO result = finalPriceService.getFinalPriceByDateAndProductIdAndBrandId("2020-06-15-10.00.00", productId,
				brand.getId());

		assertEquals(price3.getCurr(), result.getCurr());
		assertEquals(price3.getStartDate(), result.getStartDate());
		assertEquals(price3.getEndDate(), result.getEndDate());
		assertEquals(price3.getProductId(), result.getProductId());
		assertEquals(price3.getPriceList(), result.getPriceList());
		assertEquals(price3.getBrand().getId(), result.getBrandId());
		assertEquals(price3.getPriority(), result.getPriority());
		assertEquals(price3.getPrice(), result.getPrice());
	}

	@Test
	public void testGetFinalPriceByDateAndProductIdAndBranchId_date2020_06_16_21() {
		prices = List.of(price1, price4);

		when(finalPriceRepository.findPricesByProductIdAndBrandIdAndDateBetween(productId, brand.getId(),
				LocalDateTime.parse("2020-06-16-21.00.00", formatter))).thenReturn(prices);

		PriceDTO result = finalPriceService.getFinalPriceByDateAndProductIdAndBrandId("2020-06-16-21.00.00", productId,
				brand.getId());

		assertEquals(price4.getCurr(), result.getCurr());
		assertEquals(price4.getStartDate(), result.getStartDate());
		assertEquals(price4.getEndDate(), result.getEndDate());
		assertEquals(price4.getProductId(), result.getProductId());
		assertEquals(price4.getPriceList(), result.getPriceList());
		assertEquals(price4.getBrand().getId(), result.getBrandId());
		assertEquals(price4.getPriority(), result.getPriority());
		assertEquals(price4.getPrice(), result.getPrice());
	}

	@Test
    public void testGetFinalPriceByDateAndProductIdAndBrandId_emptyList() {
        when(finalPriceRepository.findPricesByProductIdAndBrandIdAndDateBetween(productId, 1L,LocalDateTime.parse("2020-06-14-15.00.00", formatter)))
                .thenReturn(Collections.emptyList());

        PriceDTO result = finalPriceService.getFinalPriceByDateAndProductIdAndBrandId("2022-03-26-10.00.00", productId, 1L);

        assertEquals(null, result.getCurr());
        assertEquals(null, result.getStartDate());
        assertEquals(null, result.getEndDate());
        assertEquals(null, result.getProductId());
        assertEquals(null, result.getPriceList());
        assertEquals(null, result.getBrandId());
        assertEquals(null, result.getPriority());
        assertEquals(null, result.getPrice());
    }

}
