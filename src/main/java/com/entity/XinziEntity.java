package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 薪资
 *
 * @author 
 * @email
 */
@TableName("xinzi")
public class XinziEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XinziEntity() {

	}

	public XinziEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 员工
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 月份
     */
    @TableField(value = "month")

    private String month;


    /**
     * 工资
     */
    @TableField(value = "jiben_money")

    private Double jibenMoney;


    /**
     * 备注
     */
    @TableField(value = "xinzi_content")

    private String xinziContent;


    /**
     * 是否确认
     */
    @TableField(value = "xinzi_yesno_types")

    private Integer xinziYesnoTypes;


    /**
     * 发放时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：员工
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：员工
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：月份
	 */
    public String getMonth() {
        return month;
    }


    /**
	 * 获取：月份
	 */

    public void setMonth(String month) {
        this.month = month;
    }
    /**
	 * 设置：工资
	 */
    public Double getJibenMoney() {
        return jibenMoney;
    }


    /**
	 * 获取：工资
	 */

    public void setJibenMoney(Double jibenMoney) {
        this.jibenMoney = jibenMoney;
    }
    /**
	 * 设置：备注
	 */
    public String getXinziContent() {
        return xinziContent;
    }


    /**
	 * 获取：备注
	 */

    public void setXinziContent(String xinziContent) {
        this.xinziContent = xinziContent;
    }
    /**
	 * 设置：是否确认
	 */
    public Integer getXinziYesnoTypes() {
        return xinziYesnoTypes;
    }


    /**
	 * 获取：是否确认
	 */

    public void setXinziYesnoTypes(Integer xinziYesnoTypes) {
        this.xinziYesnoTypes = xinziYesnoTypes;
    }
    /**
	 * 设置：发放时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：发放时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Xinzi{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", month=" + month +
            ", jibenMoney=" + jibenMoney +
            ", xinziContent=" + xinziContent +
            ", xinziYesnoTypes=" + xinziYesnoTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
