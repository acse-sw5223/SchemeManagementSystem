package com.so.modules.plan.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 制定书修改记录
 * @author admin
 * @version 2022-07-02 20:36:23
 */
public class PlanFixRecordsBean implements Serializable  {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String id;
    /**
     * 方案编号
     */
    private Long schemeNo;
    /**
     * 方案修改记录
     */
    private String schemeModificationRecord;
    /**
     * 返修人
     */
    private String schemeRepairer;
    /**
     * 返修日期
     */
    private Date schemeRepairDate;

    public void setId(String id) {
        this.id = id;
    };

    public String getId(){
        return this.id;
    };
    public void setSchemeNo(Long schemeNo) {
        this.schemeNo = schemeNo;
    };

    public Long getSchemeNo(){
        return this.schemeNo;
    };
    public void setSchemeModificationRecord(String schemeModificationRecord) {
        this.schemeModificationRecord = schemeModificationRecord;
    };

    public String getSchemeModificationRecord(){
        return this.schemeModificationRecord;
    };
    public void setSchemeRepairer(String schemeRepairer) {
        this.schemeRepairer = schemeRepairer;
    };

    public String getSchemeRepairer(){
        return this.schemeRepairer;
    };
    public void setSchemeRepairDate(Date schemeRepairDate) {
        this.schemeRepairDate = schemeRepairDate;
    };

    public Date getSchemeRepairDate(){
        return this.schemeRepairDate;
    };
}




































