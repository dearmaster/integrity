package com.mars.tea.springmvc.aop;

public class DataSourceHolder {
	
	private static final ThreadLocal<String> dataSource = new ThreadLocal<String>();
	
	public static void setDataSource(String type) {
		dataSource.set(type);
	}
	
	public static String getDataSource() {
		return dataSource.get();
	}
	
	public static void clear() {
		dataSource.remove();
	}

}
