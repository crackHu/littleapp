package ml.littleapp.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "crawler_ip_pool")
public class CrawlerIpPool extends BaseEntity {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * src_paging_id
     */
    @Column(name = "src_paging_id")
    private Integer srcPagingId;

    /**
     * ip
     */
    private Integer ip;

    /**
     * port
     */
    private Integer port;

    /**
     * address
     */
    private String address;

    /**
     * type
     */
    private String type;

    /**
     * protocol
     */
    private String protocol;

    /**
     * verify_date
     */
    @Column(name = "verify_date")
    private String verifyDate;

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
     * 获取src_paging_id
     *
     * @return src_paging_id - src_paging_id
     */
    public Integer getSrcPagingId() {
        return srcPagingId;
    }

    /**
     * 设置src_paging_id
     *
     * @param srcPagingId src_paging_id
     */
    public void setSrcPagingId(Integer srcPagingId) {
        this.srcPagingId = srcPagingId;
    }

    /**
     * 获取ip
     *
     * @return ip - ip
     */
    public Integer getIp() {
        return ip;
    }

    /**
     * 设置ip
     *
     * @param ip ip
     */
    public void setIp(Integer ip) {
        this.ip = ip;
    }

    /**
     * 获取port
     *
     * @return port - port
     */
    public Integer getPort() {
        return port;
    }

    /**
     * 设置port
     *
     * @param port port
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * 获取address
     *
     * @return address - address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置address
     *
     * @param address address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取type
     *
     * @return type - type
     */
    public String getType() {
        return type;
    }

    /**
     * 设置type
     *
     * @param type type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取protocol
     *
     * @return protocol - protocol
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * 设置protocol
     *
     * @param protocol protocol
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * 获取verify_date
     *
     * @return verify_date - verify_date
     */
    public String getVerifyDate() {
        return verifyDate;
    }

    /**
     * 设置verify_date
     *
     * @param verifyDate verify_date
     */
    public void setVerifyDate(String verifyDate) {
        this.verifyDate = verifyDate;
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
}