package com.hx.reader.components.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 获得数据源
 * @author chuhx
 * @version 2017年3月24日
 */
public class MultipleDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		return DynamicDataSourceHolder.getRouteKey();
	}

}
