package com.onlinetutorialspoint.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.onlinetutorialspoint.model.HealthUnit;

import java.util.List;
public class HealthUnitResponse {
	private int currentPage;
	private int perPage;
	private Long totalEntries;
	private List<HealthUnit> entries;
	
	public HealthUnitResponse() {}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public Long getTotalEntries() {
		return totalEntries;
	}
	public void setTotalEntries(Long totalEntries) {
		this.totalEntries = totalEntries;
	}
	public List<HealthUnit> getEntries() {
		return entries;
	}
	public void setEntries(List<HealthUnit> entries) {
		this.entries = entries;
	}

	
	
	
	
}