package ml.littleapp.model;

import javax.persistence.*;

@Table(name = "crawler_crawl_ip")
public class CrawlerCrawlIp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer ip;

    private Integer port;

    private String address;

    @Column(name = "anon_type")
    private String anonType;

    @Column(name = "crawl_src")
    private String crawlSrc;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_date")
    private Long createDate;

    @Column(name = "modify_by")
    private String modifyBy;

    @Column(name = "modify_date")
    private Long modifyDate;

    private String remarks;

    private Boolean deleted;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return ip
     */
    public Integer getIp() {
        return ip;
    }

    /**
     * @param ip
     */
    public void setIp(Integer ip) {
        this.ip = ip;
    }

    /**
     * @return port
     */
    public Integer getPort() {
        return port;
    }

    /**
     * @param port
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return anon_type
     */
    public String getAnonType() {
        return anonType;
    }

    /**
     * @param anonType
     */
    public void setAnonType(String anonType) {
        this.anonType = anonType;
    }

    /**
     * @return crawl_src
     */
    public String getCrawlSrc() {
        return crawlSrc;
    }

    /**
     * @param crawlSrc
     */
    public void setCrawlSrc(String crawlSrc) {
        this.crawlSrc = crawlSrc;
    }

    /**
     * @return create_by
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * @return create_date
     */
    public Long getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    /**
     * @return modify_by
     */
    public String getModifyBy() {
        return modifyBy;
    }

    /**
     * @param modifyBy
     */
    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    /**
     * @return modify_date
     */
    public Long getModifyDate() {
        return modifyDate;
    }

    /**
     * @param modifyDate
     */
    public void setModifyDate(Long modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * @return remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * @return deleted
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * @param deleted
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}