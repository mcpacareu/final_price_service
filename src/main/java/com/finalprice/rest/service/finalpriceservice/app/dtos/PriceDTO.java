package com.finalprice.rest.service.finalpriceservice.app.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.finalprice.rest.service.finalpriceservice.app.enums.Currency;

public class PriceDTO {
	private Long id;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Long priceList;
	private Long productId;
	private Integer priority;
	private BigDecimal price;
	private Currency curr;
	private Long brandId;

	public PriceDTO() {
		this.id = null;
		this.startDate = null;
		this.endDate = null;
		this.priceList = null;
		this.productId = null;
		this.priority = null;
		this.price = null;
		this.curr = null;
		this.brandId = null;
	}

	public PriceDTO(Long id, LocalDateTime startDate, LocalDateTime endDate, Long priceList, Long productId,
			Integer priority, BigDecimal price, Currency curr, Long brandId) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceList = priceList;
		this.productId = productId;
		this.priority = priority;
		this.price = price;
		this.curr = curr;
		this.brandId = brandId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Long getPriceList() {
		return priceList;
	}

	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Currency getCurr() {
		return curr;
	}

	public void setCurr(Currency curr) {
		this.curr = curr;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

}