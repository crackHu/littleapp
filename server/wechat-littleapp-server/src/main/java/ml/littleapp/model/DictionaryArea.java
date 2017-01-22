package ml.littleapp.model;

import javax.persistence.*;

@Table(name = "dictionary_area")
public class DictionaryArea extends BaseEntity {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 栏目名
     */
    private String areaname;

    /**
     * 父栏目
     */
    private Integer parentid;

    /**
     * shortname
     */
    private String shortname;

    /**
     * areacode
     */
    private Integer areacode;

    /**
     * zipcode
     */
    private Integer zipcode;

    /**
     * pinyin
     */
    private String pinyin;

    /**
     * lng
     */
    private String lng;

    /**
     * lat
     */
    private String lat;

    /**
     * level
     */
    private Boolean level;

    /**
     * position
     */
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
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
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
     * 获取shortname
     *
     * @return shortname - shortname
     */
    public String getShortname() {
        return shortname;
    }

    /**
     * 设置shortname
     *
     * @param shortname shortname
     */
    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    /**
     * 获取areacode
     *
     * @return areacode - areacode
     */
    public Integer getAreacode() {
        return areacode;
    }

    /**
     * 设置areacode
     *
     * @param areacode areacode
     */
    public void setAreacode(Integer areacode) {
        this.areacode = areacode;
    }

    /**
     * 获取zipcode
     *
     * @return zipcode - zipcode
     */
    public Integer getZipcode() {
        return zipcode;
    }

    /**
     * 设置zipcode
     *
     * @param zipcode zipcode
     */
    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * 获取pinyin
     *
     * @return pinyin - pinyin
     */
    public String getPinyin() {
        return pinyin;
    }

    /**
     * 设置pinyin
     *
     * @param pinyin pinyin
     */
    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
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
     * 获取level
     *
     * @return level - level
     */
    public Boolean getLevel() {
        return level;
    }

    /**
     * 设置level
     *
     * @param level level
     */
    public void setLevel(Boolean level) {
        this.level = level;
    }

    /**
     * 获取position
     *
     * @return position - position
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置position
     *
     * @param position position
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