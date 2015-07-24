package com.explore.controller;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class DAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObj;
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
		this.jdbcTemplateObj = new JdbcTemplate(dataSource);
	}
	
	public void create(String name, int age){
		//String SQL = "insert into "
	}

}
