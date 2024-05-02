package com.entity.model;

import com.entity.XinziEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 薪资
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XinziModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 员工
     */
    private Integer yonghuId;


    /**
     * 月份
     */
    private String month;


    /**
     * 工资
     */
    private Double jibenMoney;


    /**
     * 备注
     */
    private String xinziContent;


    /**
     * 是否确认
     */
    private Integer xinziYesnoTypes;


    /**
     * 发放时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：员工
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：员工
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：月份
	 */
    public String getMonth() {
        return month;
    }


    /**
	 * 设置：月份
	 */
    public void setMonth(String month) {
        this.month = month;
    }
    /**
	 * 获取：工资
	 */
    public Double getJibenMoney() {
        return jibenMoney;
    }


    /**
	 * 设置：工资
	 */
    public void setJibenMoney(Double jibenMoney) {
        this.jibenMoney = jibenMoney;
    }
    /**
	 * 获取：备注
	 */
    public String getXinziContent() {
        return xinziContent;
    }


    /**
	 * 设置：备注
	 */
    public void setXinziContent(String xinziContent) {
        this.xinziContent = xinziContent;
    }
    /**
	 * 获取：是否确认
	 */
    public Integer getXinziYesnoTypes() {
        return xinziYesnoTypes;
    }


    /**
	 * 设置：是否确认
	 */
    public void setXinziYesnoTypes(Integer xinziYesnoTypes) {
        this.xinziYesnoTypes = xinziYesnoTypes;
    }
    /**
	 * 获取：发放时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：发放时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
