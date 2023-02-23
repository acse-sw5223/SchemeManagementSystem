package com.so.modules.plan.dao;

import com.so.modules.plan.bean.AuditRecordsBean;
import org.apache.commons.utils.IdUtils;
import org.apache.commons.utils.Page;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 审批记录
 *
 * @author admin
 * @version 2022-07-03 09:44:37
 */
public class AuditRecordsDao {
    /**
     * 添加 审批记录
     *
     * @param con              数据库链接
     * @param auditRecordsBean 审批记录
     * @return 操作行
     * @throws Exception 异常
     */
    public int add(Connection con, AuditRecordsBean auditRecordsBean) throws Exception {
        auditRecordsBean.setId(IdUtils.getSnowflakeID());
        PreparedStatement preparedStatement = con.prepareStatement("insert into plan_audit_records values(?,?,?,?,?,?)");
        preparedStatement.setString(1, auditRecordsBean.getId());
        preparedStatement.setLong(2, auditRecordsBean.getSchemeNo());
        preparedStatement.setDate(3, new Date(auditRecordsBean.getSchemeAuditDate().getTime()));
        preparedStatement.setString(4, auditRecordsBean.getCchemeReviewComments());
        preparedStatement.setString(5, auditRecordsBean.getSchemeReviewer());
        preparedStatement.setString(6, auditRecordsBean.getAuditStatus());
        return preparedStatement.executeUpdate();
    }

    /**
     * 删除 审批记录
     *
     * @param con 数据库链接
     * @param id  id
     * @return 删除行数
     * @throws Exception 异常
     */
    public int delete(Connection con, String id) throws Exception {
        PreparedStatement preparedStatement = con.prepareStatement("delete from plan_audit_records where id= ?");
        preparedStatement.setString(1, id);
        return preparedStatement.executeUpdate();
    }

    /**
     * 更新  审批记录
     *
     * @param con              数据库链接
     * @param auditRecordsBean 审批记录
     * @return 更新行数
     * @throws Exception 异常
     */
    public int update(Connection con, AuditRecordsBean auditRecordsBean) throws Exception {
        PreparedStatement preparedStatement = con.prepareStatement("update plan_audit_records set scheme_no=?,scheme_audit_date=?,ccheme_review_comments=?,scheme_reviewer=? where id = ?");
        preparedStatement.setString(5, auditRecordsBean.getId());
        preparedStatement.setLong(1, auditRecordsBean.getSchemeNo());
        preparedStatement.setString(3, auditRecordsBean.getCchemeReviewComments());
        preparedStatement.setString(4, auditRecordsBean.getSchemeReviewer());
        return preparedStatement.executeUpdate();
    }

    /**
     * 分页查询
     *
     * @param con              数据库链接
     * @param auditRecordsBean 审批记录
     * @return 分页集合
     * @throws Exception 异常
     */
    public List<AuditRecordsBean> list(Connection con, AuditRecordsBean auditRecordsBean, Page<AuditRecordsBean> page) throws Exception {
        List<AuditRecordsBean> list = new ArrayList<AuditRecordsBean>();
        AuditRecordsBean entity = null;
        StringBuffer sqlBuffer = new StringBuffer("select * from plan_audit_records a where 1=1");
        //拼接分页条件
        Long schemeNo = auditRecordsBean.getSchemeNo();
        if (Objects.nonNull(schemeNo)) {
            sqlBuffer.append(" and scheme_no = " + schemeNo);
        }
        String sql = Page.pageSql(sqlBuffer, page.getPageNo(), page.getPageSize());
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            entity = getDictFormDb(rs);
            list.add(entity);
        }
        return list;
    }

    /**
     * 根据条件查询所有满足条件的数据
     *
     * @param con              数据库链接
     * @param auditRecordsBean 查询条件
     * @return 所有审批记录
     * @throws Exception 异常
     */
    public List<AuditRecordsBean> findAll(Connection con, AuditRecordsBean auditRecordsBean) throws Exception {
        List<AuditRecordsBean> list = new ArrayList<AuditRecordsBean>();
        AuditRecordsBean entity;
        StringBuffer sqlBuffer = new StringBuffer("select * from plan_audit_records where 1=1");
        //拼接分页条件
		Long schemeNo = auditRecordsBean.getSchemeNo();
		if (Objects.nonNull(schemeNo)) {
			sqlBuffer.append(" and scheme_no = " + schemeNo);
		}
        String sql = sqlBuffer.toString();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            entity = getDictFormDb(rs);
            list.add(entity);
        }
        return list;
    }

    /**
     * 根据id查询
     *
     * @param con 数据库链接
     * @param id  id
     * @return 审批记录
     * @throws Exception 异常
     */
    public AuditRecordsBean getById(Connection con, String id) throws Exception {
        AuditRecordsBean auditRecordsBean = null;
        StringBuffer stringBuffer = new StringBuffer("select * from plan_audit_records where id = ?");
        PreparedStatement preparedStatement = con.prepareStatement(stringBuffer.toString());
        preparedStatement.setString(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            auditRecordsBean = getDictFormDb(rs);
        }
        return auditRecordsBean;
    }

    /**
     * 获取总数 分页查询计算分页信息用
     *
     * @param con              数据库链接
     * @param auditRecordsBean 查询条件
     * @return 总数
     * @throws Exception 异常
     */
    public int count(Connection con, AuditRecordsBean auditRecordsBean) throws Exception {
        int count = 0;
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append("select count(*) as count from plan_audit_records where 1=1");
        //拼接分页条件
		Long schemeNo = auditRecordsBean.getSchemeNo();
		if (Objects.nonNull(schemeNo)) {
			sqlBuffer.append(" and scheme_no = " + schemeNo);
		}
        String sql = sqlBuffer.toString();
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            count = rs.getInt("count");
        }
        return count;
    }

    /**
     * 映射数据库返回值到javaben对象
     */
    private AuditRecordsBean getDictFormDb(ResultSet rs) throws SQLException {
        AuditRecordsBean auditRecordsBean = new AuditRecordsBean();
        auditRecordsBean.setId(rs.getString("id"));
        auditRecordsBean.setSchemeNo(rs.getLong("scheme_no"));
        auditRecordsBean.setSchemeAuditDate(rs.getTimestamp("scheme_audit_date"));
        auditRecordsBean.setCchemeReviewComments(rs.getString("ccheme_review_comments"));
        auditRecordsBean.setSchemeReviewer(rs.getString("scheme_reviewer"));
        auditRecordsBean.setAuditStatus(rs.getString("audit_status"));
        return auditRecordsBean;
    }
}






































