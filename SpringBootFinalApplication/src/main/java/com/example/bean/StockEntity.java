package com.example.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class StockEntity {

	@Id
	@GeneratedValue
	@Column(name = "stck_id")
	private Long stockId;

	@Column(name = "stock_code")
	private String stockCode;

	@Column(name = "stock_name")
	private String StockName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "stock_category", joinColumns = @JoinColumn(name = "stock_mapped_id", referencedColumnName = "stck_id"), inverseJoinColumns = @JoinColumn(name = "catogory_mapped_id", referencedColumnName = "category_id"))
	private List<Category> category;

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return StockName;
	}

	public void setStockName(String stockName) {
		StockName = stockName;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

}
