package com.msb.bean;

import java.util.ArrayList;
import java.util.List;

import com.msb.model.Other;

public class SchoolDetailBean {

	private Integer points;

	private List<Other> toppers;

	public SchoolDetailBean() {
		toppers = new ArrayList<Other>();
		points = 0;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public List<Other> getToppers() {
		return toppers;
	}

	public void setToppers(List<Other> toppers) {
		this.toppers = toppers;
	}

}