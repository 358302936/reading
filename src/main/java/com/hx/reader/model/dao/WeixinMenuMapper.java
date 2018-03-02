package com.hx.reader.model.dao;

import com.hx.reader.model.pojo.WeixinMenu;
import com.hx.reader.model.vo.JyEnWordInfoVO;

import java.util.List;

public interface WeixinMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeixinMenu record);

    int insertSelective(WeixinMenu record);

    WeixinMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeixinMenu record);

    int updateByPrimaryKey(WeixinMenu record);

    /**
     * 添加单词信息
     * @param record
     * @return
     */
    int insertWordInfo(JyEnWordInfoVO record);

    /**
     * 查询所有单词
     * @return
     */
    List<JyEnWordInfoVO> selectAllWord();
}