package com.hx.reader.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.hx.reader.model.pojo.TagTemperaturePojo;


public interface TagTemperature {

	public List<TagTemperaturePojo> selectTapt() throws SQLException;
}
