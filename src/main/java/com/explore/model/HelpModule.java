package com.explore.model;

public class HelpModule {
	
	private Long id;
	
	private String pageTitle;
	private String helpMessage;
	
	public HelpModule() { }
	
	public Long getId() { return id; }
	
	public void setId(Long id) { this.id = id; }
	
	public String getPageTitle() { return pageTitle; }
	
	public void setPageTitle(String pageTitle) { this.pageTitle = pageTitle; }
	
	public String getHelpMessage() { return helpMessage; }
	
	public void setHelpMessage(String helpMessage) { this.helpMessage = helpMessage; }
	
}
