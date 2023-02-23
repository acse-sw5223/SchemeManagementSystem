package com.so.modules.system.service.impl;

import com.so.modules.system.bean.DeptInfoBean;
import com.so.modules.system.dao.DeptInfoDao;
import com.so.modules.system.service.DeptInfoService;
import com.so.commons.utils.DbUtil;
import org.apache.commons.utils.Page;

import java.sql.Connection;
import java.util.List;

public class DeptInfoServiceImpl implements DeptInfoService {

  private DeptInfoDao deptInfoDao = new DeptInfoDao();
	
	@Override
	public int add(DeptInfoBean deptInfoBean) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			Integer result = deptInfoDao.add(con, deptInfoBean);
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
			int delete = deptInfoDao.delete(con, id);
			DbUtil.closeCon(con);
			return delete;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(DeptInfoBean deptInfoBean) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			int update = deptInfoDao.update(con, deptInfoBean);
			DbUtil.closeCon(con);
			return update;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Page<DeptInfoBean> page(DeptInfoBean deptInfoBean, Page<DeptInfoBean> page) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			int count = deptInfoDao.count(con, deptInfoBean);
			page.setCount(count);
			page.setPrev(page.getPageNo()-1);
			page.setNext(page.getPageNo() + 1);// 下一页
			page.setLast((count - 1) / page.getPageSize() + 1);// 总也数
			List<DeptInfoBean> list = deptInfoDao.list(con, deptInfoBean, page);
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
	public DeptInfoBean getById(String id) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			DeptInfoBean deptInfoBean = deptInfoDao.getById(con, id);
			DbUtil.closeCon(con);
			return deptInfoBean;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<DeptInfoBean> findAll(DeptInfoBean deptInfoBean) {
		try {
			Connection con = DbUtil.getDbUtil().getCon();
			List<DeptInfoBean> list = deptInfoDao.findAll(con, deptInfoBean);
			DbUtil.closeCon(con);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}






































