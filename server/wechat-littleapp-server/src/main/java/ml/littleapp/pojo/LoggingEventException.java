package ml.littleapp.pojo;

import javax.persistence.*;

@Table(name = "logging_event_exception")
public class LoggingEventException extends BaseEntity {
    @Id
    @Column(name = "event_id")
    private Long eventId;

    @Id
    private Short i;

    @Column(name = "trace_line")
    private String traceLine;

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
     * @return i
     */
    public Short getI() {
        return i;
    }

    /**
     * @param i
     */
    public void setI(Short i) {
        this.i = i;
    }

    /**
     * @return trace_line
     */
    public String getTraceLine() {
        return traceLine;
    }

    /**
     * @param traceLine
     */
    public void setTraceLine(String traceLine) {
        this.traceLine = traceLine;
    }
}