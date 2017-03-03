package ml.littleapp.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cra_ip_verify")
public class CraIpVerify extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pool_id")
    private Long poolId;

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
     * @return pool_id
     */
    public Long getPoolId() {
        return poolId;
    }

    /**
     * @param poolId
     */
    public void setPoolId(Long poolId) {
        this.poolId = poolId;
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