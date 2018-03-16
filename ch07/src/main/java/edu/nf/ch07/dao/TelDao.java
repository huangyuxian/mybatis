package edu.nf.ch07.dao;

import edu.nf.ch07.entity.Tel;

public interface TelDao {

    /**
     * 根据电话号码查询
     * @param tel
     * @return
     */
    Tel findTelByTelNumber(String tel);
}
