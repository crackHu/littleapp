package ml.littleapp.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "crawler_ip_src_paging")
public class CrawlerIpSrcPaging extends BaseEntity {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * src_id
     */
    @Column(name = "src_id")
    private Integer srcId;

    /**
     * url
     */
    private String url;

    /**
     * title
     */
    private String title;

    /**
     * page_no
     */
    @Column(name = "page_no")
    private Integer pageNo;

    /**
     * create_by
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * create_date
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * modify_by
     */
    @Column(name = "modify_by")
    private String modifyBy;

    /**
     * modify_date
     */
    @Column(name = "modify_date")
    private Date modifyDate;

    /**
     * remarks
     */
    private String remarks;

    /**
     * deleted
     */
    private Boolean deleted;

    /**
     * content
     */
    private String content;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取src_id
     *
     * @return src_id - src_id
     */
    public Integer getSrcId() {
        return srcId;
    }

    /**
     * 设置src_id
     *
     * @param srcId src_id
     */
    public void setSrcId(Integer srcId) {
        this.srcId = srcId;
    }

    /**
     * 获取url
     *
     * @return url - url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置url
     *
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取title
     *
     * @return title - title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置title
     *
     * @param title title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取page_no
     *
     * @return page_no - page_no
     */
    public Integer getPageNo() {
        return pageNo;
    }

    /**
     * 设置page_no
     *
     * @param pageNo page_no
     */
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 获取create_by
     *
     * @return create_by - create_by
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置create_by
     *
     * @param createBy create_by
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取create_date
     *
     * @return create_date - create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置create_date
     *
     * @param createDate create_date
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取modify_by
     *
     * @return modify_by - modify_by
     */
    public String getModifyBy() {
        return modifyBy;
    }

    /**
     * 设置modify_by
     *
     * @param modifyBy modify_by
     */
    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    /**
     * 获取modify_date
     *
     * @return modify_date - modify_date
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * 设置modify_date
     *
     * @param modifyDate modify_date
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * 获取remarks
     *
     * @return remarks - remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置remarks
     *
     * @param remarks remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取deleted
     *
     * @return deleted - deleted
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * 设置deleted
     *
     * @param deleted deleted
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取content
     *
     * @return content - content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置content
     *
     * @param content content
     */
    public void setContent(String content) {
        this.content = content;
    }
}