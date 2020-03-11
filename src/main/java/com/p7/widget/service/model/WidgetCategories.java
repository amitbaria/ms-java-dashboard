package com.p7.widget.service.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.*;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class WidgetCategories {
	@JsonProperty("id")
	private String id;
	@JsonProperty("code")
	private String code;
	@JsonProperty("type")
	private String type;
	@JsonProperty("label")
	private String label;
	@JsonProperty("height")
	private String height;
	@JsonProperty("width")
	private String width;
	@JsonProperty("bar_chart")
	private String bar_chart;
	@JsonProperty("column_chart")
	private String column_chart;
	@JsonProperty("line_chart")
	private String line_chart;
	@JsonProperty("pie_chart")
	private String pie_chart;
	@JsonProperty("area_chart")
	private String area_chart;
	@JsonProperty("is_live")
	private String is_live;
	@JsonProperty("createdAt")
	private Date createdAt;
	@JsonProperty("updatedAt")
	private Date updatedAt;
}

