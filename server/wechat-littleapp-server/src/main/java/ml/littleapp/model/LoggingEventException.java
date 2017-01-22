package ml.littleapp.model;

import javax.persistence.*;

@Table(name = "logging_event_exception")
public class LoggingEventException extends BaseEntity {
    /**
     * event_id
     */
    @Id
    @Column(name = "event_id")
    private Long eventId;

    /**
     * i
     */
    @Id
    private Short i;

    /**
     * trace_line
     */
    @Column(name = "trace_line")
    private String traceLine;

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
     * 获取i
     *
     * @return i - i
     */
    public Short getI() {
        return i;
    }

    /**
     * 设置i
     *
     * @param i i
     */
    public void setI(Short i) {
        this.i = i;
    }

    /**
     * 获取trace_line
     *
     * @return trace_line - trace_line
     */
    public String getTraceLine() {
        return traceLine;
    }

    /**
     * 设置trace_line
     *
     * @param traceLine trace_line
     */
    public void setTraceLine(String traceLine) {
        this.traceLine = traceLine;
    }
}