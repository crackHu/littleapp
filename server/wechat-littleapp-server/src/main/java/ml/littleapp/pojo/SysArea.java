package ml.littleapp.pojo;

import javax.persistence.*;

@Table(name = "sys_area")
public class SysArea extends BaseEntity {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 栏目名
     */
    private String areaname;

    /**
     * 父栏目
     */
    private Integer parentid;

    private String shortname;

    private Integer areacode;

    private Integer zipcode;

    private String pinyin;

    private String lng;

    private String lat;

    private Boolean level;

    private String position;

    /**
     * 排序
     */
    private Byte sort;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取栏目名
     *
     * @return areaname - 栏目名
     */
    public String getAreaname() {
        return areaname;
    }

    /**
     * 设置栏目名
     *
     * @param areaname 栏目名
     */
    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    /**
     * 获取父栏目
     *
     * @return parentid - 父栏目
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * 设置父栏目
     *
     * @param parentid 父栏目
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    /**
     * @return shortname
     */
    public String getShortname() {
        return shortname;
    }

    /**
     * @param shortname
     */
    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    /**
     * @return areacode
     */
    public Integer getAreacode() {
        return areacode;
    }

    /**
     * @param areacode
     */
    public void setAreacode(Integer areacode) {
        this.areacode = areacode;
    }

    /**
     * @return zipcode
     */
    public Integer getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode
     */
    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * @return pinyin
     */
    public String getPinyin() {
        return pinyin;
    }

    /**
     * @param pinyin
     */
    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
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
     * @return level
     */
    public Boolean getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(Boolean level) {
        this.level = level;
    }

    /**
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Byte getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Byte sort) {
        this.sort = sort;
    }
}