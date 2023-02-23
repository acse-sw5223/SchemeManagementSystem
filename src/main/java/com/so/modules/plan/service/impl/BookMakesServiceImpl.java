package com.so.modules.plan.service.impl;

import com.so.commons.enums.DictEnums;
import com.so.commons.utils.DbUtil;
import com.so.modules.plan.bean.BookMakesBean;
import com.so.modules.plan.bean.PlanFixRecordsBean;
import com.so.modules.plan.dao.BookMakesDao;
import com.so.modules.plan.service.BookMakesService;
import org.apache.commons.utils.IdUtils;
import org.apache.commons.utils.Page;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class BookMakesServiceImpl implements BookMakesService {

  private BookMakesDao bookMakesDao = new BookMakesDao();
	
	@Override
	public int add(BookMakesBean bookMakesBean) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			bookMakesBean.setPlanStatus(DictEnums.PLAN_STATUS_0.getDictValue());
			Integer result = bookMakesDao.add(con, bookMakesBean);
			bookMakesDao.add(con, addFixRecords(bookMakesBean));
			DbUtil.closeCon(con);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	private PlanFixRecordsBean addFixRecords(BookMakesBean bookMakesBean) {
		PlanFixRecordsBean planFixRecordsBean = new PlanFixRecordsBean();
		planFixRecordsBean.setId(IdUtils.getSnowflakeID());
		planFixRecordsBean.setSchemeModificationRecord(bookMakesBean.getSchemeProgramRules());
		planFixRecordsBean.setSchemeNo(bookMakesBean.getSchemeNo());
		planFixRecordsBean.setSchemeRepairer(bookMakesBean.getCreateUser());
		planFixRecordsBean.setSchemeRepairDate(new Date());
		return planFixRecordsBean;
	}

	@Override
	public int delete(String id) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			int delete = bookMakesDao.delete(con, id);
			bookMakesDao.deleteRecords(con, id);
			DbUtil.closeCon(con);
			return delete;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(BookMakesBean bookMakesBean) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			int update = bookMakesDao.update(con, bookMakesBean);
			bookMakesDao.add(con, addFixRecords(bookMakesBean));
			DbUtil.closeCon(con);
			return update;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 更新审批状态
	 * @param bookMakesBean
	 * @return
	 */
	@Override
	public int updatePlanStatus(BookMakesBean bookMakesBean) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			int update = bookMakesDao.updatePlanStatus(con, bookMakesBean);
			DbUtil.closeCon(con);
			return update;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Page<BookMakesBean> page(BookMakesBean bookMakesBean, Page<BookMakesBean> page) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			int count = bookMakesDao.count(con, bookMakesBean);
			page.setCount(count);
			page.setPrev(page.getPageNo()-1);
			page.setNext(page.getPageNo() + 1);// 下一页
			page.setLast((count - 1) / page.getPageSize() + 1);// 总也数
			List<BookMakesBean> list = bookMakesDao.list(con, bookMakesBean, page);
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
	public BookMakesBean getById(String id) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			BookMakesBean bookMakesBean = bookMakesDao.getById(con, id);
			DbUtil.closeCon(con);
			return bookMakesBean;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<BookMakesBean> findAll(BookMakesBean bookMakesBean) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			List<BookMakesBean> list = bookMakesDao.findAll(con, bookMakesBean);
			DbUtil.closeCon(con);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<PlanFixRecordsBean> fixList(PlanFixRecordsBean planFixRecordsBean) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			List<PlanFixRecordsBean> list = bookMakesDao.list(con, planFixRecordsBean);
			DbUtil.closeCon(con);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}






































