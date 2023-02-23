package com.so.modules.plan.dao;

import com.so.modules.plan.bean.BookMakesBean;
import com.so.modules.plan.bean.PlanFixRecordsBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.utils.IdUtils;
import org.apache.commons.utils.Page;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 方案制定书
 *
 * @author admin
 * @version 2022-07-02 17:04:37
 */
public class BookMakesDao {
    /**
     * 添加 方案制定书
     *
     * @param con           数据库链接
     * @param bookMakesBean 方案制定书
     * @return 操作行
     * @throws Exception 异常
     */
    public int add(Connection con, BookMakesBean bookMakesBean) throws Exception {
        bookMakesBean.setId(IdUtils.getSnowflakeID());
        bookMakesBean.setSchemeNo(Long.valueOf(bookMakesBean.getId()));
        PreparedStatement preparedStatement = con.prepareStatement("insert into plan_book_makes values(?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1, bookMakesBean.getId());
        preparedStatement.setLong(2, bookMakesBean.getSchemeNo());
        preparedStatement.setString(3, bookMakesBean.getSchemeDescription());
        preparedStatement.setString(4, bookMakesBean.getSchemeProgramRules());
        preparedStatement.setString(5, bookMakesBean.getSchemeFormulator());
        preparedStatement.setDate(6, new Date(bookMakesBean.getCreateTime().getTime()));
        preparedStatement.setLong(7, bookMakesBean.getRequirementItemNo());
        preparedStatement.setString(8, bookMakesBean.getPlanStatus());
        return preparedStatement.executeUpdate();
    }

    /**
     * 添加 制定书修改记录
     *
     * @param con                数据库链接
     * @param planFixRecordsBean 制定书修改记录
     * @return 操作行
     * @throws Exception 异常
     */
    public int add(Connection con, PlanFixRecordsBean planFixRecordsBean) throws Exception {
        planFixRecordsBean.setId(IdUtils.getSnowflakeID());
        PreparedStatement preparedStatement = con.prepareStatement("insert into plan_fix_records values(?,?,?,?,?)");
        preparedStatement.setString(1, planFixRecordsBean.getId());
        preparedStatement.setLong(2, planFixRecordsBean.getSchemeNo());
        preparedStatement.setString(3, planFixRecordsBean.getSchemeModificationRecord());
        preparedStatement.setString(4, planFixRecordsBean.getSchemeRepairer());
        preparedStatement.setDate(5, new Date(planFixRecordsBean.getSchemeRepairDate().getTime()));
        return preparedStatement.executeUpdate();
    }

    public int deleteRecords(Connection con, String id) throws Exception {
        PreparedStatement preparedStatement = con.prepareStatement("delete from plan_fix_records where scheme_no= ?");
        preparedStatement.setString(1, id);
        return preparedStatement.executeUpdate();
    }

    /**
     * 删除 方案制定书
     *
     * @param con 数据库链接
     * @param id  id
     * @return 删除行数
     * @throws Exception 异常
     */
    public int delete(Connection con, String id) throws Exception {
        PreparedStatement preparedStatement = con.prepareStatement("delete from plan_book_makes where id= ?");
        preparedStatement.setString(1, id);
        return preparedStatement.executeUpdate();
    }

    /**
     * 更新  方案制定书
     *
     * @param con           数据库链接
     * @param bookMakesBean 方案制定书
     * @return 更新行数
     * @throws Exception 异常
     */
    public int update(Connection con, BookMakesBean bookMakesBean) throws Exception {
        PreparedStatement preparedStatement = con.prepareStatement("update plan_book_makes set scheme_no=?,scheme_description=?,scheme_program_rules=?,create_time=?,requirement_item_no=? where id = ?");
        preparedStatement.setString(6, bookMakesBean.getId());
        preparedStatement.setLong(1, bookMakesBean.getSchemeNo());
        preparedStatement.setString(2, bookMakesBean.getSchemeDescription());
        preparedStatement.setString(3, bookMakesBean.getSchemeProgramRules());
        preparedStatement.setDate(4, new Date(bookMakesBean.getCreateTime().getTime()));
        preparedStatement.setLong(5, bookMakesBean.getRequirementItemNo());
        return preparedStatement.executeUpdate();
    }

    /**
     * 更新审批状态
     *
     * @param con
     * @param bookMakesBean
     * @return
     * @throws Exception
     */
    public int updatePlanStatus(Connection con, BookMakesBean bookMakesBean) throws Exception {
        PreparedStatement preparedStatement = con.prepareStatement("update plan_book_makes set plan_status=? where id = ?");
        preparedStatement.setString(2, bookMakesBean.getId());
        preparedStatement.setString(1, bookMakesBean.getPlanStatus());
        return preparedStatement.executeUpdate();
    }

    /**
     * 分页查询
     *
     * @param con           数据库链接
     * @param bookMakesBean 方案制定书
     * @return 分页集合
     * @throws Exception 异常
     */
    public List<BookMakesBean> list(Connection con, BookMakesBean bookMakesBean, Page<BookMakesBean> page) throws Exception {
        List<BookMakesBean> list = new ArrayList<BookMakesBean>();
        BookMakesBean entity = null;
        StringBuffer sqlBuffer = new StringBuffer("select * from plan_book_makes a where 1=1");
        //拼接分页条件
        String schemeFormulator = bookMakesBean.getSchemeFormulator();
        if (schemeFormulator != null && schemeFormulator != "") {
            sqlBuffer.append(" and scheme_formulator = '" + schemeFormulator + "'");
        }
        String needAudits = bookMakesBean.getNeedAudits();
        if (StringUtils.isNotEmpty(needAudits)) {
            sqlBuffer.append(" and plan_status in (" + needAudits + ")");
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
     * @param con           数据库链接
     * @param bookMakesBean 查询条件
     * @return 所有方案制定书
     * @throws Exception 异常
     */
    public List<BookMakesBean> findAll(Connection con, BookMakesBean bookMakesBean) throws Exception {
        List<BookMakesBean> list = new ArrayList<BookMakesBean>();
        BookMakesBean entity;
        StringBuffer sqlBuffer = new StringBuffer("select * from plan_book_makes where 1=1");
        //拼接分页条件
        String schemeFormulator = bookMakesBean.getSchemeFormulator();
        if (schemeFormulator != null && schemeFormulator != "") {
            sqlBuffer.append(" and scheme_formulator = '" + schemeFormulator + "'");
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
     * @return 方案制定书
     * @throws Exception 异常
     */
    public BookMakesBean getById(Connection con, String id) throws Exception {
        BookMakesBean bookMakesBean = null;
        StringBuffer stringBuffer = new StringBuffer("select * from plan_book_makes where id = ?");
        PreparedStatement preparedStatement = con.prepareStatement(stringBuffer.toString());
        preparedStatement.setString(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            bookMakesBean = getDictFormDb(rs);
        }
        return bookMakesBean;
    }

    /**
     * 获取总数 分页查询计算分页信息用
     *
     * @param con           数据库链接
     * @param bookMakesBean 查询条件
     * @return 总数
     * @throws Exception 异常
     */
    public int count(Connection con, BookMakesBean bookMakesBean) throws Exception {
        int count = 0;
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append("select count(*) as count from plan_book_makes where 1=1");
        //拼接分页条件
        String schemeFormulator = bookMakesBean.getSchemeFormulator();
        if (schemeFormulator != null && schemeFormulator != "") {
            sqlBuffer.append(" and scheme_formulator = '" + schemeFormulator + "'");
        }
		String needAudits = bookMakesBean.getNeedAudits();
		if (StringUtils.isNotEmpty(needAudits)) {
			sqlBuffer.append(" and plan_status in (" + needAudits + ")");
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
    private BookMakesBean getDictFormDb(ResultSet rs) throws SQLException {
        BookMakesBean bookMakesBean = new BookMakesBean();
        bookMakesBean.setId(rs.getString("id"));
        bookMakesBean.setSchemeNo(rs.getLong("scheme_no"));
        bookMakesBean.setSchemeDescription(rs.getString("scheme_description"));
        bookMakesBean.setSchemeProgramRules(rs.getString("scheme_program_rules"));
        bookMakesBean.setSchemeFormulator(rs.getString("scheme_formulator"));
        bookMakesBean.setCreateTime(rs.getTimestamp("create_time"));
        bookMakesBean.setRequirementItemNo(rs.getLong("requirement_item_no"));
        bookMakesBean.setPlanStatus(rs.getString("plan_status"));
        return bookMakesBean;
    }


    /**
     * 查询修改记录
     *
     * @param con                数据库链接
     * @param planFixRecordsBean 制定书修改记录
     * @return 分页集合
     * @throws Exception 异常
     */
    public List<PlanFixRecordsBean> list(Connection con, PlanFixRecordsBean planFixRecordsBean) throws Exception {
        List<PlanFixRecordsBean> list = new ArrayList<PlanFixRecordsBean>();
        PlanFixRecordsBean entity = null;
        StringBuffer sqlBuffer = new StringBuffer("select * from plan_fix_records a where 1=1 and scheme_no = " + planFixRecordsBean.getSchemeNo());
        PreparedStatement pstmt = con.prepareStatement(sqlBuffer.toString());
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            entity = getPlanFixRecords(rs);
            list.add(entity);
        }
        return list;
    }

    /**
     * 映射数据库返回值到javaben对象
     */
    private PlanFixRecordsBean getPlanFixRecords(ResultSet rs) throws SQLException {
        PlanFixRecordsBean planFixRecordsBean = new PlanFixRecordsBean();
        planFixRecordsBean.setId(rs.getString("id"));
        planFixRecordsBean.setSchemeNo(rs.getLong("scheme_no"));
        planFixRecordsBean.setSchemeModificationRecord(rs.getString("scheme_modification_record"));
        planFixRecordsBean.setSchemeRepairer(rs.getString("scheme_repairer"));
        planFixRecordsBean.setSchemeRepairDate(rs.getTimestamp("scheme_repair_date"));
        return planFixRecordsBean;
    }
}






































