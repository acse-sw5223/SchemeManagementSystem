package com.so.modules.plan.service.impl;

import com.so.modules.plan.bean.AuditRecordsBean;
import com.so.modules.plan.dao.AuditRecordsDao;
import com.so.modules.plan.service.AuditRecordsService;
import com.so.commons.utils.DbUtil;
import org.apache.commons.utils.Page;

import java.sql.Connection;
import java.util.List;

public class AuditRecordsServiceImpl implements AuditRecordsService {

  private AuditRecordsDao auditRecordsDao = new AuditRecordsDao();
	
	@Override
	public int add(AuditRecordsBean auditRecordsBean) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			Integer result = auditRecordsDao.add(con, auditRecordsBean);
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
			int delete = auditRecordsDao.delete(con, id);
			DbUtil.closeCon(con);
			return delete;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(AuditRecordsBean auditRecordsBean) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			int update = auditRecordsDao.update(con, auditRecordsBean);
			DbUtil.closeCon(con);
			return update;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Page<AuditRecordsBean> page(AuditRecordsBean auditRecordsBean, Page<AuditRecordsBean> page) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			int count = auditRecordsDao.count(con, auditRecordsBean);
			page.setCount(count);
			page.setPrev(page.getPageNo()-1);
			page.setNext(page.getPageNo() + 1);// 下一页
			page.setLast((count - 1) / page.getPageSize() + 1);// 总也数
			List<AuditRecordsBean> list = auditRecordsDao.list(con, auditRecordsBean, page);
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
	public AuditRecordsBean getById(String id) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			AuditRecordsBean auditRecordsBean = auditRecordsDao.getById(con, id);
			DbUtil.closeCon(con);
			return auditRecordsBean;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<AuditRecordsBean> findAll(AuditRecordsBean auditRecordsBean) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			List<AuditRecordsBean> list = auditRecordsDao.findAll(con, auditRecordsBean);
			DbUtil.closeCon(con);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}






































