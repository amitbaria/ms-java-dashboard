package com.p7.widget.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;

@Getter
@Setter
@Entity
@Table(name="p7_widget_payload")
public class WidgetPayloadEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long widgetpayloadid;
	
	@Column(name="PAYLOAD_KEY")
	private String payloadKey;
	@Column(name="PAYLOAD_VALUE")
	private String payloadValue;
	
	
	@ManyToOne
	@JoinColumn(name="WIDGET_ID")
    private  WidgetEntity widgetEntity;
	

}
