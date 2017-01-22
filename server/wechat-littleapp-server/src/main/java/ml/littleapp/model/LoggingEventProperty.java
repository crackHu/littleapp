package ml.littleapp.model;

import javax.persistence.*;

@Table(name = "logging_event_property")
public class LoggingEventProperty extends BaseEntity {
    /**
     * event_id
     */
    @Id
    @Column(name = "event_id")
    private Long eventId;

    /**
     * mapped_key
     */
    @Id
    @Column(name = "mapped_key")
    private String mappedKey;

    /**
     * mapped_value
     */
    @Column(name = "mapped_value")
    private String mappedValue;

    /**
     * 获取event_id
     *
     * @return event_id - event_id
     */
    public Long getEventId() {
        return eventId;
    }

    /**
     * 设置event_id
     *
     * @param eventId event_id
     */
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    /**
     * 获取mapped_key
     *
     * @return mapped_key - mapped_key
     */
    public String getMappedKey() {
        return mappedKey;
    }

    /**
     * 设置mapped_key
     *
     * @param mappedKey mapped_key
     */
    public void setMappedKey(String mappedKey) {
        this.mappedKey = mappedKey;
    }

    /**
     * 获取mapped_value
     *
     * @return mapped_value - mapped_value
     */
    public String getMappedValue() {
        return mappedValue;
    }

    /**
     * 设置mapped_value
     *
     * @param mappedValue mapped_value
     */
    public void setMappedValue(String mappedValue) {
        this.mappedValue = mappedValue;
    }
}