package ml.littleapp.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "crawler_verify_ip")
public class CrawlerVerifyIp extends BaseEntity {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * pool_id
     */
    @Column(name = "pool_id")
    private Integer poolId;

    /**
     * country
     */
    private String country;

    /**
     * province
     */
    private String province;

    /**
     * city
     */
    private String city;

    /**
     * district
     */
    private String district;

    /**
     * isp
     */
    private String isp;

    /**
     * lng
     */
    private String lng;

    /**
     * lat
     */
    private String lat;

    /**
     * verify_url
     */
    @Column(name = "verify_url")
    private String verifyUrl;

    /**
     * verify_ret
     */
    @Column(name = "verify_ret")
    private String verifyRet;

    /**
     * is_useful
     */
    @Column(name = "is_useful")
    private Boolean isUseful;

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
     * 获取pool_id
     *
     * @return pool_id - pool_id
     */
    public Integer getPoolId() {
        return poolId;
    }

    /**
     * 设置pool_id
     *
     * @param poolId pool_id
     */
    public void setPoolId(Integer poolId) {
        this.poolId = poolId;
    }

    /**
     * 获取country
     *
     * @return country - country
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置country
     *
     * @param country country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取province
     *
     * @return province - province
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置province
     *
     * @param province province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取city
     *
     * @return city - city
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置city
     *
     * @param city city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取district
     *
     * @return district - district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 设置district
     *
     * @param district district
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * 获取isp
     *
     * @return isp - isp
     */
    public String getIsp() {
        return isp;
    }

    /**
     * 设置isp
     *
     * @param isp isp
     */
    public void setIsp(String isp) {
        this.isp = isp;
    }

    /**
     * 获取lng
     *
     * @return lng - lng
     */
    public String getLng() {
        return lng;
    }

    /**
     * 设置lng
     *
     * @param lng lng
     */
    public void setLng(String lng) {
        this.lng = lng;
    }

    /**
     * 获取lat
     *
     * @return lat - lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * 设置lat
     *
     * @param lat lat
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * 获取verify_url
     *
     * @return verify_url - verify_url
     */
    public String getVerifyUrl() {
        return verifyUrl;
    }

    /**
     * 设置verify_url
     *
     * @param verifyUrl verify_url
     */
    public void setVerifyUrl(String verifyUrl) {
        this.verifyUrl = verifyUrl;
    }

    /**
     * 获取verify_ret
     *
     * @return verify_ret - verify_ret
     */
    public String getVerifyRet() {
        return verifyRet;
    }

    /**
     * 设置verify_ret
     *
     * @param verifyRet verify_ret
     */
    public void setVerifyRet(String verifyRet) {
        this.verifyRet = verifyRet;
    }

    /**
     * 获取is_useful
     *
     * @return is_useful - is_useful
     */
    public Boolean getIsUseful() {
        return isUseful;
    }

    /**
     * 设置is_useful
     *
     * @param isUseful is_useful
     */
    public void setIsUseful(Boolean isUseful) {
        this.isUseful = isUseful;
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