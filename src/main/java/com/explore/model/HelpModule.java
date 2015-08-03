package com.explore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "helpmessage")
public class HelpModule {
	
	private Long id;
	private String pageTitle;
	private String helpMessage;
	
	public HelpModule() { }
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	public Long getId() { return id; }
	
	public void setId(Long id) { this.id = id; }
	
	public String getPageTitle() { return pageTitle; }
	
	public void setPageTitle(String pageTitle) { this.pageTitle = pageTitle; }
	
	public String getHelpMessage() { return helpMessage; }
	
	public void setHelpMessage(String helpMessage) { this.helpMessage = helpMessage; }
	
}
