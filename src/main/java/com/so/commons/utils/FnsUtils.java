package com.so.commons.utils;

import com.so.commons.enums.DictEnums;
import com.so.commons.enums.RoleEnum;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.utils.FnsDao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class FnsUtils {
	
	/**
	 * 测试方法
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 * 根据字典名称获取字典列表
	 * @param dictName
	 * @return
	 */
	public static List<DictEnums> dictList(String dictName) {
		return DictEnums.getLabelsByName(dictName);
	}

	/**
	 * 根据字典名称，字典值获取对应的标签
	 * @param dictName
	 * @param dictValue
	 * @return
	 */
	public static String dictLabel(String dictName, String dictValue) {
		return DictEnums.getLabelsByNameAndValue(dictName, dictValue);
	}

	/**
	 * 获取所有的角色
	 * @return
	 */
	public static List<RoleEnum> roles() {
		return RoleEnum.getRoles();
	}

	/**
	 * 根据角色ID获取对应的角色
	 * @param roleId
	 * @return
	 */
	public static String roleName(String roleId) {
		return RoleEnum.getRoleName(roleId);
	}

	/**
	 * 自定义标签获取指定数据库表的数据
	 * @param tableName 数据库表名
	 * @param pkField 主键字段名
	 * @param pkValue 主键Value值
	 * @param showField 展示字段名
	 * @return
	 */
	public static String getTableDataByPk(String tableName, String pkField, String pkValue, String showField){
		Connection con = null;
		try {
			con = DbUtil.getDbUtil().getCon();
			return FnsDao.getTableDataByPk(con, tableName, pkField, pkValue, showField);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return StringUtils.EMPTY;
	}

	/**
	 * 自定义标签获取指定数据库表的数据
	 * @param tableName 数据库表名
	 * @param pkField 主键
	 * @param showField 展示字段
	 * @return
	 */
	public static List<Map<String, String>> getTableData(String tableName, String pkField, String showField){
		Connection con = null;
		try {
			con = DbUtil.getDbUtil().getCon();
			return FnsDao.getTableData(con, tableName, pkField, showField);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

}
