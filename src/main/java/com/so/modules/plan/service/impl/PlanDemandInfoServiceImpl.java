package com.so.modules.plan.service.impl;

import com.so.modules.plan.bean.PlanDemandInfoBean;
import com.so.modules.plan.dao.PlanDemandInfoDao;
import com.so.modules.plan.service.PlanDemandInfoService;
import com.so.commons.utils.DbUtil;
import org.apache.commons.utils.Page;

import java.sql.Connection;
import java.util.List;

public class PlanDemandInfoServiceImpl implements PlanDemandInfoService {

  private PlanDemandInfoDao planDemandInfoDao = new PlanDemandInfoDao();
	
	@Override
	public int add(PlanDemandInfoBean planDemandInfoBean) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			Integer result = planDemandInfoDao.add(con, planDemandInfoBean);
			DbUtil.closeCon(con);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(String id) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			int delete = planDemandInfoDao.delete(con, id);
			DbUtil.closeCon(con);
			return delete;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(PlanDemandInfoBean planDemandInfoBean) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			int update = planDemandInfoDao.update(con, planDemandInfoBean);
			DbUtil.closeCon(con);
			return update;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Page<PlanDemandInfoBean> page(PlanDemandInfoBean planDemandInfoBean, Page<PlanDemandInfoBean> page) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			int count = planDemandInfoDao.count(con, planDemandInfoBean);
			page.setCount(count);
			page.setPrev(page.getPageNo()-1);
			page.setNext(page.getPageNo() + 1);// 下一页
			page.setLast((count - 1) / page.getPageSize() + 1);// 总也数
			List<PlanDemandInfoBean> list = planDemandInfoDao.list(con, planDemandInfoBean, page);
			page.setList(list);
			page.setRainbow(page);
			DbUtil.closeCon(con);
			return page;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PlanDemandInfoBean getById(String id) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			PlanDemandInfoBean planDemandInfoBean = planDemandInfoDao.getById(con, id);
			DbUtil.closeCon(con);
			return planDemandInfoBean;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<PlanDemandInfoBean> findAll(PlanDemandInfoBean planDemandInfoBean) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			List<PlanDemandInfoBean> list = planDemandInfoDao.findAll(con, planDemandInfoBean);
			DbUtil.closeCon(con);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}






































