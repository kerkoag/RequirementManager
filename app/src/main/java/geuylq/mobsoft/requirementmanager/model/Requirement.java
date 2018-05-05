package geuylq.mobsoft.requirementmanager.model;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.util.Date;

@Table
public class Requirement extends SugarRecord {
    private Long id;

    private String title;

    private Integer priority;

    private String status;

    private String state;

    private String assignedTo;

    private Date recordedDate;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Date getRecordedDate() {
        return recordedDate;
    }

    public void setRecordedDate(Date recordedDate) {
        this.recordedDate = recordedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
