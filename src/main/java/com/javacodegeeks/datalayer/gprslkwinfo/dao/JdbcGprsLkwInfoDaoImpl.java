package com.javacodegeeks.datalayer.gprslkwinfo.dao;

import com.javacodegeeks.datalayer.gprslkwinfo.model.GprsLkwInfoParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.javacodegeeks.datalayer.gprslkwinfo.dao.GprsLkwInfoDAO;
import com.javacodegeeks.datalayer.gprslkwinfo.model.GprsLkwInfo;

/**
 * Created by osboxes on 28.11.16.
 */



public class JdbcGprsLkwInfoDaoImpl extends SimpleJdbcDaoSupport implements GprsLkwInfoDAO {
    public void insert(GprsLkwInfo gprsLkwInfo){

        String sql = "INSERT INTO GPRS_LKWINFO " +
                "(LKWID, KENNZEICHEN) VALUES ( ?, ?)";

        getJdbcTemplate().update(sql, new Object[] {
                gprsLkwInfo.getGprsLkwInfoLkwId(), gprsLkwInfo.getGprsLkwInfokennzeichen()
        });

    }

    public GprsLkwInfo findByGprsLkwInfoLkwId(long lkwid) {
        String sql = "SELECT lkwid,kennzeichen FROM GPRS_LKWINFO WHERE LKWID = ?";

        GprsLkwInfo gprsLkwInfo = getSimpleJdbcTemplate().queryForObject(
                sql, new GprsLkwInfoParameterizedRowMapper(), lkwid);


        return gprsLkwInfo;


    }


}
