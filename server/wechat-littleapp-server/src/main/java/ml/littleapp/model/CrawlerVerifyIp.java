package ml.littleapp.model;

import javax.persistence.*;

@Table(name = "crawler_verify_ip")
public class CrawlerVerifyIp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte[] id;

    @Column(name = "crawler_cip_id")
    private byte[] crawlerCipId;

    private String country;

    private String province;

    private String city;

    private String district;

    private String isp;

    private String lng;

    private String lat;

    @Column(name = "verify_url")
    private String verifyUrl;

    @Column(name = "verify_ret")
    private String verifyRet;

    @Column(name = "is_useful")
    private Boolean isUseful;

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
    public byte[] getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(byte[] id) {
        this.id = id;
    }

    /**
     * @return crawler_cip_id
     */
    public byte[] getCrawlerCipId() {
        return crawlerCipId;
    }

    /**
     * @param crawlerCipId
     */
    public void setCrawlerCipId(byte[] crawlerCipId) {
        this.crawlerCipId = crawlerCipId;
    }

    /**
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * @return isp
     */
    public String getIsp() {
        return isp;
    }

    /**
     * @param isp
     */
    public void setIsp(String isp) {
        this.isp = isp;
    }

    /**
     * @return lng
     */
    public String getLng() {
        return lng;
    }

    /**
     * @param lng
     */
    public void setLng(String lng) {
        this.lng = lng;
    }

    /**
     * @return lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * @param lat
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * @return verify_url
     */
    public String getVerifyUrl() {
        return verifyUrl;
    }

    /**
     * @param verifyUrl
     */
    public void setVerifyUrl(String verifyUrl) {
        this.verifyUrl = verifyUrl;
    }

    /**
     * @return verify_ret
     */
    public String getVerifyRet() {
        return verifyRet;
    }

    /**
     * @param verifyRet
     */
    public void setVerifyRet(String verifyRet) {
        this.verifyRet = verifyRet;
    }

    /**
     * @return is_useful
     */
    public Boolean getIsUseful() {
        return isUseful;
    }

    /**
     * @param isUseful
     */
    public void setIsUseful(Boolean isUseful) {
        this.isUseful = isUseful;
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