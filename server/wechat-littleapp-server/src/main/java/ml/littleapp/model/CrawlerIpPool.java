package ml.littleapp.model;

import javax.persistence.*;

@Table(name = "crawler_ip_pool")
public class CrawlerIpPool extends BaseEntity {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * crawler_ips_id
     */
    @Column(name = "crawler_ips_id")
    private Integer crawlerIpsId;

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
     * anon_type
     */
    @Column(name = "anon_type")
    private String anonType;

    /**
     * create_by
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * create_date
     */
    @Column(name = "create_date")
    private Long createDate;

    /**
     * modify_by
     */
    @Column(name = "modify_by")
    private String modifyBy;

    /**
     * modify_date
     */
    @Column(name = "modify_date")
    private Long modifyDate;

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
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取crawler_ips_id
     *
     * @return crawler_ips_id - crawler_ips_id
     */
    public Integer getCrawlerIpsId() {
        return crawlerIpsId;
    }

    /**
     * 设置crawler_ips_id
     *
     * @param crawlerIpsId crawler_ips_id
     */
    public void setCrawlerIpsId(Integer crawlerIpsId) {
        this.crawlerIpsId = crawlerIpsId;
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
     * 获取anon_type
     *
     * @return anon_type - anon_type
     */
    public String getAnonType() {
        return anonType;
    }

    /**
     * 设置anon_type
     *
     * @param anonType anon_type
     */
    public void setAnonType(String anonType) {
        this.anonType = anonType;
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
    public Long getCreateDate() {
        return createDate;
    }

    /**
     * 设置create_date
     *
     * @param createDate create_date
     */
    public void setCreateDate(Long createDate) {
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
    public Long getModifyDate() {
        return modifyDate;
    }

    /**
     * 设置modify_date
     *
     * @param modifyDate modify_date
     */
    public void setModifyDate(Long modifyDate) {
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