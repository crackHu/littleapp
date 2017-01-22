package ml.littleapp.model;

import javax.persistence.*;

@Table(name = "logging_event")
public class LoggingEvent extends BaseEntity {
    /**
     * event_id
     */
    @Id
    @Column(name = "event_id")
    private Long eventId;

    /**
     * timestmp
     */
    private Long timestmp;

    /**
     * logger_name
     */
    @Column(name = "logger_name")
    private String loggerName;

    /**
     * level_string
     */
    @Column(name = "level_string")
    private String levelString;

    /**
     * thread_name
     */
    @Column(name = "thread_name")
    private String threadName;

    /**
     * reference_flag
     */
    @Column(name = "reference_flag")
    private Short referenceFlag;

    /**
     * arg0
     */
    private String arg0;

    /**
     * arg1
     */
    private String arg1;

    /**
     * arg2
     */
    private String arg2;

    /**
     * arg3
     */
    private String arg3;

    /**
     * caller_filename
     */
    @Column(name = "caller_filename")
    private String callerFilename;

    /**
     * caller_class
     */
    @Column(name = "caller_class")
    private String callerClass;

    /**
     * caller_method
     */
    @Column(name = "caller_method")
    private String callerMethod;

    /**
     * caller_line
     */
    @Column(name = "caller_line")
    private String callerLine;

    /**
     * formatted_message
     */
    @Column(name = "formatted_message")
    private String formattedMessage;

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
     * 获取timestmp
     *
     * @return timestmp - timestmp
     */
    public Long getTimestmp() {
        return timestmp;
    }

    /**
     * 设置timestmp
     *
     * @param timestmp timestmp
     */
    public void setTimestmp(Long timestmp) {
        this.timestmp = timestmp;
    }

    /**
     * 获取logger_name
     *
     * @return logger_name - logger_name
     */
    public String getLoggerName() {
        return loggerName;
    }

    /**
     * 设置logger_name
     *
     * @param loggerName logger_name
     */
    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    /**
     * 获取level_string
     *
     * @return level_string - level_string
     */
    public String getLevelString() {
        return levelString;
    }

    /**
     * 设置level_string
     *
     * @param levelString level_string
     */
    public void setLevelString(String levelString) {
        this.levelString = levelString;
    }

    /**
     * 获取thread_name
     *
     * @return thread_name - thread_name
     */
    public String getThreadName() {
        return threadName;
    }

    /**
     * 设置thread_name
     *
     * @param threadName thread_name
     */
    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    /**
     * 获取reference_flag
     *
     * @return reference_flag - reference_flag
     */
    public Short getReferenceFlag() {
        return referenceFlag;
    }

    /**
     * 设置reference_flag
     *
     * @param referenceFlag reference_flag
     */
    public void setReferenceFlag(Short referenceFlag) {
        this.referenceFlag = referenceFlag;
    }

    /**
     * 获取arg0
     *
     * @return arg0 - arg0
     */
    public String getArg0() {
        return arg0;
    }

    /**
     * 设置arg0
     *
     * @param arg0 arg0
     */
    public void setArg0(String arg0) {
        this.arg0 = arg0;
    }

    /**
     * 获取arg1
     *
     * @return arg1 - arg1
     */
    public String getArg1() {
        return arg1;
    }

    /**
     * 设置arg1
     *
     * @param arg1 arg1
     */
    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    /**
     * 获取arg2
     *
     * @return arg2 - arg2
     */
    public String getArg2() {
        return arg2;
    }

    /**
     * 设置arg2
     *
     * @param arg2 arg2
     */
    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    /**
     * 获取arg3
     *
     * @return arg3 - arg3
     */
    public String getArg3() {
        return arg3;
    }

    /**
     * 设置arg3
     *
     * @param arg3 arg3
     */
    public void setArg3(String arg3) {
        this.arg3 = arg3;
    }

    /**
     * 获取caller_filename
     *
     * @return caller_filename - caller_filename
     */
    public String getCallerFilename() {
        return callerFilename;
    }

    /**
     * 设置caller_filename
     *
     * @param callerFilename caller_filename
     */
    public void setCallerFilename(String callerFilename) {
        this.callerFilename = callerFilename;
    }

    /**
     * 获取caller_class
     *
     * @return caller_class - caller_class
     */
    public String getCallerClass() {
        return callerClass;
    }

    /**
     * 设置caller_class
     *
     * @param callerClass caller_class
     */
    public void setCallerClass(String callerClass) {
        this.callerClass = callerClass;
    }

    /**
     * 获取caller_method
     *
     * @return caller_method - caller_method
     */
    public String getCallerMethod() {
        return callerMethod;
    }

    /**
     * 设置caller_method
     *
     * @param callerMethod caller_method
     */
    public void setCallerMethod(String callerMethod) {
        this.callerMethod = callerMethod;
    }

    /**
     * 获取caller_line
     *
     * @return caller_line - caller_line
     */
    public String getCallerLine() {
        return callerLine;
    }

    /**
     * 设置caller_line
     *
     * @param callerLine caller_line
     */
    public void setCallerLine(String callerLine) {
        this.callerLine = callerLine;
    }

    /**
     * 获取formatted_message
     *
     * @return formatted_message - formatted_message
     */
    public String getFormattedMessage() {
        return formattedMessage;
    }

    /**
     * 设置formatted_message
     *
     * @param formattedMessage formatted_message
     */
    public void setFormattedMessage(String formattedMessage) {
        this.formattedMessage = formattedMessage;
    }
}