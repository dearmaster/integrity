package com.mars.tea.springmvc.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

public class DataSourceSwitcher implements MethodInterceptor {
	
	private static final Logger logger = Logger.getLogger(DataSourceSwitcher.class);

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		DataSource dataSource = invocation.getMethod().getAnnotation(DataSource.class);
		String orgDataSource = DataSourceHolder.getDataSource() == null ? DataSource.core : DataSourceHolder.getDataSource(); //FIXME Not suggested
		DataSourceHolder.setDataSource(dataSource.name());
		Object obj = null;
		try {
			logger.info(">>>>>>>>>>swithing db from [" + orgDataSource + "] to [" + dataSource.name() + "] now");
			obj = invocation.proceed();
		} catch (Exception e) {
			logger.error(e);
			logger.error("Failed to process the request on db [" + dataSource.name() + "]");
		}
		logger.info(">>>>>>>>>>swithing back to [" + orgDataSource + "] now");
		DataSourceHolder.setDataSource(orgDataSource);
		return obj; //if exception throw in the method annotated, the corresponding method will get a null return object
	}

}
