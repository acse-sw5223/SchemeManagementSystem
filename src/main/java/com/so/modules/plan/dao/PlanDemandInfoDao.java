package com.so.modules.plan.dao;

import com.so.modules.plan.bean.PlanDemandInfoBean;
import org.apache.commons.utils.IdUtils;
import org.apache.commons.utils.Page;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 方案需求
 *
 * @author admin
 * @version 2022-07-02 16:15:31
 */
public class PlanDemandInfoDao {
    /**
     * 添加 方案需求
     *
     * @param con                数据库链接
     * @param planDemandInfoBean 方案需求
     * @return 操作行
     * @throws Exception 异常
     */
    public int add(Connection con, PlanDemandInfoBean planDemandInfoBean) throws Exception {
        planDemandInfoBean.setId(IdUtils.getSnowflakeID());
        PreparedStatement preparedStatement = con.prepareStatement("insert into plan_demand_info values(?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1, planDemandInfoBean.getId());
        preparedStatement.setString(2, planDemandInfoBean.getId());
        preparedStatement.setString(3, planDemandInfoBean.getExperimentName());
        preparedStatement.setString(4, planDemandInfoBean.getExperimentalDescription());
        preparedStatement.setDate(5, new Date(planDemandInfoBean.getDateOfPreliminaryReview().getTime()));
        preparedStatement.setString(6, planDemandInfoBean.getPreliminaryExaminer());
        preparedStatement.setString(7, planDemandInfoBean.getApplicantDepartment());
        preparedStatement.setString(8, planDemandInfoBean.getNameOfApplicant());
        preparedStatement.setDate(9, new Date(planDemandInfoBean.getApplicationDate().getTime()));
        return preparedStatement.executeUpdate();
    }

    /**
     * 删除 方案需求
     *
     * @param con 数据库链接
     * @param id  id
     * @return 删除行数
     * @throws Exception 异常
     */
    public int delete(Connection con, String id) throws Exception {
        PreparedStatement preparedStatement = con.prepareStatement("delete from plan_demand_info where id= ?");
        preparedStatement.setString(1, id);
        return preparedStatement.executeUpdate();
    }

    /**
     * 更新  方案需求
     *
     * @param con                数据库链接
     * @param planDemandInfoBean 方案需求
     * @return 更新行数
     * @throws Exception 异常
     */
    public int update(Connection con, PlanDemandInfoBean planDemandInfoBean) throws Exception {
        PreparedStatement preparedStatement = con.prepareStatement("update plan_demand_info set requirement_item_no=?,experiment_name=?,experimental_description=?,preliminary_examiner=?,applicant_department=?,name_of_applicant=? where id = ?");
        preparedStatement.setString(7, planDemandInfoBean.getId());
        preparedStatement.setString(1, planDemandInfoBean.getId());
        preparedStatement.setString(2, planDemandInfoBean.getExperimentName());
        preparedStatement.setString(3, planDemandInfoBean.getExperimentalDescription());
        preparedStatement.setString(4, planDemandInfoBean.getPreliminaryExaminer());
        preparedStatement.setString(5, planDemandInfoBean.getApplicantDepartment());
        preparedStatement.setString(6, planDemandInfoBean.getNameOfApplicant());
        return preparedStatement.executeUpdate();
    }

    /**
     * 分页查询
     *
     * @param con                数据库链接
     * @param planDemandInfoBean 方案需求
     * @return 分页集合
     * @throws Exception 异常
     */
    public List<PlanDemandInfoBean> list(Connection con, PlanDemandInfoBean planDemandInfoBean, Page<PlanDemandInfoBean> page) throws Exception {
        List<PlanDemandInfoBean> list = new ArrayList<PlanDemandInfoBean>();
        PlanDemandInfoBean entity = null;
        StringBuffer sqlBuffer = new StringBuffer("select * from plan_demand_info a where 1=1");
        //拼接分页条件
        String requirementItemNo = planDemandInfoBean.getRequirementItemNo();
        if (requirementItemNo != null && requirementItemNo != "") {
            sqlBuffer.append(" and requirement_item_no = '" + requirementItemNo + "'");
        }
        String experimentName = planDemandInfoBean.getExperimentName();
        if (experimentName != null && experimentName != "") {
            sqlBuffer.append(" and experiment_name like '%" + experimentName + "%'");
        }
        String applicantDepartment = planDemandInfoBean.getApplicantDepartment();
        if (applicantDepartment != null && applicantDepartment != "") {
            sqlBuffer.append(" and applicant_department = '" + applicantDepartment + "'");
        }
        String nameOfApplicant = planDemandInfoBean.getNameOfApplicant();
        if (nameOfApplicant != null && nameOfApplicant != "") {
            sqlBuffer.append(" and name_of_applicant = '" + nameOfApplicant + "'");
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
     * @param con                数据库链接
     * @param planDemandInfoBean 查询条件
     * @return 所有方案需求
     * @throws Exception 异常
     */
    public List<PlanDemandInfoBean> findAll(Connection con, PlanDemandInfoBean planDemandInfoBean) throws Exception {
        List<PlanDemandInfoBean> list = new ArrayList<PlanDemandInfoBean>();
        PlanDemandInfoBean entity;
        StringBuffer sqlBuffer = new StringBuffer("select * from plan_demand_info where 1=1");
        //拼接分页条件
        String requirementItemNo = planDemandInfoBean.getRequirementItemNo();
        if (requirementItemNo != null && requirementItemNo != "") {
            sqlBuffer.append(" and requirement_item_no = '" + requirementItemNo + "'");
        }
        String experimentName = planDemandInfoBean.getExperimentName();
        if (experimentName != null && experimentName != "") {
            sqlBuffer.append(" and experiment_name = '" + experimentName + "'");
        }
        String applicantDepartment = planDemandInfoBean.getApplicantDepartment();
        if (applicantDepartment != null && applicantDepartment != "") {
            sqlBuffer.append(" and applicant_department = '" + applicantDepartment + "'");
        }
        String nameOfApplicant = planDemandInfoBean.getNameOfApplicant();
        if (nameOfApplicant != null && nameOfApplicant != "") {
            sqlBuffer.append(" and name_of_applicant = '" + nameOfApplicant + "'");
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
     * @return 方案需求
     * @throws Exception 异常
     */
    public PlanDemandInfoBean getById(Connection con, String id) throws Exception {
        PlanDemandInfoBean planDemandInfoBean = null;
        StringBuffer stringBuffer = new StringBuffer("select * from plan_demand_info where id = ?");
        PreparedStatement preparedStatement = con.prepareStatement(stringBuffer.toString());
        preparedStatement.setString(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            planDemandInfoBean = getDictFormDb(rs);
        }
        return planDemandInfoBean;
    }

    /**
     * 获取总数 分页查询计算分页信息用
     *
     * @param con                数据库链接
     * @param planDemandInfoBean 查询条件
     * @return 总数
     * @throws Exception 异常
     */
    public int count(Connection con, PlanDemandInfoBean planDemandInfoBean) throws Exception {
        int count = 0;
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append("select count(*) as count from plan_demand_info where 1=1");
        //拼接分页条件
        String requirementItemNo = planDemandInfoBean.getRequirementItemNo();
        if (requirementItemNo != null && requirementItemNo != "") {
            sqlBuffer.append(" and requirement_item_no = '" + requirementItemNo + "'");
        }
        String experimentName = planDemandInfoBean.getExperimentName();
        if (experimentName != null && experimentName != "") {
            sqlBuffer.append(" and experiment_name = '" + experimentName + "'");
        }
        String applicantDepartment = planDemandInfoBean.getApplicantDepartment();
        if (applicantDepartment != null && applicantDepartment != "") {
            sqlBuffer.append(" and applicant_department = '" + applicantDepartment + "'");
        }
        String nameOfApplicant = planDemandInfoBean.getNameOfApplicant();
        if (nameOfApplicant != null && nameOfApplicant != "") {
            sqlBuffer.append(" and name_of_applicant = '" + nameOfApplicant + "'");
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
    private PlanDemandInfoBean getDictFormDb(ResultSet rs) throws SQLException {
        PlanDemandInfoBean planDemandInfoBean = new PlanDemandInfoBean();
        planDemandInfoBean.setId(rs.getString("id"));
        planDemandInfoBean.setRequirementItemNo(rs.getString("requirement_item_no"));
        planDemandInfoBean.setExperimentName(rs.getString("experiment_name"));
        planDemandInfoBean.setExperimentalDescription(rs.getString("experimental_description"));
        planDemandInfoBean.setDateOfPreliminaryReview(rs.getTimestamp("date_of_preliminary_review"));
        planDemandInfoBean.setPreliminaryExaminer(rs.getString("preliminary_examiner"));
        planDemandInfoBean.setApplicantDepartment(rs.getString("applicant_department"));
        planDemandInfoBean.setNameOfApplicant(rs.getString("name_of_applicant"));
        planDemandInfoBean.setApplicationDate(rs.getTimestamp("application_date"));
        return planDemandInfoBean;
    }
}






































