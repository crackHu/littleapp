package ml.littleapp.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "gen_form_item")
public class GenFormItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 表单id
     */
    @Column(name = "form_id")
    private Long formId;

    /**
     * 字典类型
     */
    @Column(name = "dict_type")
    private Long dictType;

    /**
     * 名称
     */
    @Column(name = "label_name")
    private String labelName;

    /**
     * 描述
     */
    private String description;

    /**
     * 正则表达式
     */
    private String regex;

    /**
     * 是否不能为空
     */
    @Column(name = "is_mandatory")
    private Boolean isMandatory;

    /**
     * 是否非数字
     */
    @Column(name = "is_nan")
    private Boolean isNan;

    /**
     * 排序（升序）
     */
    private Long sort;

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
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取表单id
     *
     * @return form_id - 表单id
     */
    public Long getFormId() {
        return formId;
    }

    /**
     * 设置表单id
     *
     * @param formId 表单id
     */
    public void setFormId(Long formId) {
        this.formId = formId;
    }

    /**
     * 获取字典类型
     *
     * @return dict_type - 字典类型
     */
    public Long getDictType() {
        return dictType;
    }

    /**
     * 设置字典类型
     *
     * @param dictType 字典类型
     */
    public void setDictType(Long dictType) {
        this.dictType = dictType;
    }

    /**
     * 获取名称
     *
     * @return label_name - 名称
     */
    public String getLabelName() {
        return labelName;
    }

    /**
     * 设置名称
     *
     * @param labelName 名称
     */
    public void setLabelName(String labelName) {
        this.labelName = labelName;
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
     * 获取正则表达式
     *
     * @return regex - 正则表达式
     */
    public String getRegex() {
        return regex;
    }

    /**
     * 设置正则表达式
     *
     * @param regex 正则表达式
     */
    public void setRegex(String regex) {
        this.regex = regex;
    }

    /**
     * 获取是否不能为空
     *
     * @return is_mandatory - 是否不能为空
     */
    public Boolean getIsMandatory() {
        return isMandatory;
    }

    /**
     * 设置是否不能为空
     *
     * @param isMandatory 是否不能为空
     */
    public void setIsMandatory(Boolean isMandatory) {
        this.isMandatory = isMandatory;
    }

    /**
     * 获取是否非数字
     *
     * @return is_nan - 是否非数字
     */
    public Boolean getIsNan() {
        return isNan;
    }

    /**
     * 设置是否非数字
     *
     * @param isNan 是否非数字
     */
    public void setIsNan(Boolean isNan) {
        this.isNan = isNan;
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