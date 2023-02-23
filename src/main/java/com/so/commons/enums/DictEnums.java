package com.so.commons.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 字典枚举类
 * @author Administrator
 * @version 2021-07-18
 */
public enum DictEnums {

    /**
     * 性别字典
     */
    SELECT_SEX_0("sex", "0", "男"),
    SELECT_SEX_1("sex", "1", "女"),
    PLAN_STATUS_0("plan_status", "0", "已制定"),
    PLAN_STATUS_1("plan_status", "1", "已制定并提交"),
    PLAN_STATUS_2("plan_status", "2", "待修改"),
    PLAN_STATUS_3("plan_status", "3", "已修改并重新提交"),
    PLAN_STATUS_4("plan_status", "4", "已通过的历史方案"),
    AUDIT_STATUS_0("audit_status", "0", "不通过"),
    AUDIT_STATUS_1("audit_status", "1", "通过"),

    ;

    private String dictName;

    private String dictValue;

    private String dictLabel;

    DictEnums(String dictName, String dictValue, String dictLabel) {
        this.dictName = dictName;
        this.dictValue = dictValue;
        this.dictLabel = dictLabel;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictLabel() {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    /**
     * 根据字典名称获取所有字典值
     * @param dictName
     * @return
     */
    public static List<DictEnums> getLabelsByName(String dictName) {
        List<DictEnums> dictEnums = new ArrayList<>();
        DictEnums[] values = DictEnums.values();
        for (DictEnums dictEnum : values) {
            if (dictEnum.dictName.equals(dictName)) {
                dictEnums.add(dictEnum);
            }
        }
        return dictEnums;
    }

    /**
     * 根据字典名称和字典值获取字典标签
     * @param dictName
     * @param dictValue
     * @return
     */
    public static String getLabelsByNameAndValue(String dictName, final String dictValue) {
        List<DictEnums> dictEnums = getLabelsByName(dictName);
        List<DictEnums> collect = dictEnums.stream().filter(item -> item.dictValue.equals(dictValue)).collect(Collectors.toList());
        if (collect != null && collect.size() > 0) {
            return collect.get(0).getDictLabel();
        }
        return StringUtils.EMPTY;
    }

    /**
     * 测试方法
     * @param args
     */
    public static void main(String[] args) {
        List<DictEnums> sex = getLabelsByName("sex");
        for (DictEnums dictEnums : sex) {
            System.out.println(dictEnums.getDictLabel());
        }

        System.out.println(getLabelsByNameAndValue("sex", "0"));
    }
}
