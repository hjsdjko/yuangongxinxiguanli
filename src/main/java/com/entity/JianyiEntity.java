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
 * 建议
 *
 * @author 
 * @email
 */
@TableName("jianyi")
public class JianyiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JianyiEntity() {

	}

	public JianyiEntity(T t) {
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
     * 建议名称
     */
    @TableField(value = "jianyi_name")

    private String jianyiName;


    /**
     * 建议类型
     */
    @TableField(value = "jianyi_types")

    private Integer jianyiTypes;


    /**
     * 建议时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 建议详情
     */
    @TableField(value = "jianyi_content")

    private String jianyiContent;


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
	 * 设置：建议名称
	 */
    public String getJianyiName() {
        return jianyiName;
    }


    /**
	 * 获取：建议名称
	 */

    public void setJianyiName(String jianyiName) {
        this.jianyiName = jianyiName;
    }
    /**
	 * 设置：建议类型
	 */
    public Integer getJianyiTypes() {
        return jianyiTypes;
    }


    /**
	 * 获取：建议类型
	 */

    public void setJianyiTypes(Integer jianyiTypes) {
        this.jianyiTypes = jianyiTypes;
    }
    /**
	 * 设置：建议时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：建议时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：建议详情
	 */
    public String getJianyiContent() {
        return jianyiContent;
    }


    /**
	 * 获取：建议详情
	 */

    public void setJianyiContent(String jianyiContent) {
        this.jianyiContent = jianyiContent;
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
        return "Jianyi{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", jianyiName=" + jianyiName +
            ", jianyiTypes=" + jianyiTypes +
            ", insertTime=" + insertTime +
            ", jianyiContent=" + jianyiContent +
            ", createTime=" + createTime +
        "}";
    }
}
