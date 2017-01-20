package ml.littleapp.model;

import javax.persistence.*;

@Table(name = "logging_event_property")
public class LoggingEventProperty {
    @Id
    @Column(name = "event_id")
    private Long eventId;

    @Id
    @Column(name = "mapped_key")
    private String mappedKey;

    @Column(name = "mapped_value")
    private String mappedValue;

    /**
     * @return event_id
     */
    public Long getEventId() {
        return eventId;
    }

    /**
     * @param eventId
     */
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    /**
     * @return mapped_key
     */
    public String getMappedKey() {
        return mappedKey;
    }

    /**
     * @param mappedKey
     */
    public void setMappedKey(String mappedKey) {
        this.mappedKey = mappedKey;
    }

    /**
     * @return mapped_value
     */
    public String getMappedValue() {
        return mappedValue;
    }

    /**
     * @param mappedValue
     */
    public void setMappedValue(String mappedValue) {
        this.mappedValue = mappedValue;
    }
}