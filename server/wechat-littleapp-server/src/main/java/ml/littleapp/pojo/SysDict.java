package ml.littleapp.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_dict")
public class SysDict extends BaseEntity {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 数据值
     */
    private String value;

    /**
     * 标签名
     */
    @Column(name = "label_name")
    private String labelName;

    /**
     * 类型
     */
    private String type;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序（升序）
     */
    private Long sort;

    /**
     * 父级编号
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 最近修改时间
     */
    @Column(name = "gmt_modified")
    private Date gmtModified;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 是否删除
     */
    @Column(name = "is_deleted")
    private Boolean isDeleted;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取数据值
     *
     * @return value - 数据值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置数据值
     *
     * @param value 数据值
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取标签名
     *
     * @return label_name - 标签名
     */
    public String getLabelName() {
        return labelName;
    }

    /**
     * 设置标签名
     *
     * @param labelName 标签名
     */
    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    /**
     * 获取类型
     *
     * @return type - 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取排序（升序）
     *
     * @return sort - 排序（升序）
     */
    public Long getSort() {
        return sort;
    }

    /**
     * 设置排序（升序）
     *
     * @param sort 排序（升序）
     */
    public void setSort(Long sort) {
        this.sort = sort;
    }

    /**
     * 获取父级编号
     *
     * @return parent_id - 父级编号
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父级编号
     *
     * @param parentId 父级编号
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取创建时间
     *
     * @return gmt_create - 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置创建时间
     *
     * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取最近修改时间
     *
     * @return gmt_modified - 最近修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置最近修改时间
     *
     * @param gmtModified 最近修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取备注
     *
     * @return remarks - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取是否删除
     *
     * @return is_deleted - 是否删除
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置是否删除
     *
     * @param isDeleted 是否删除
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}