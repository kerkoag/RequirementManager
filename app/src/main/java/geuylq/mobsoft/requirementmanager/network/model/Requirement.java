package geuylq.mobsoft.requirementmanager.network.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class Requirement   {
  
  @SerializedName("id")
  private BigDecimal id = null;
  
  @SerializedName("title")
  private String title = null;
  
  @SerializedName("priority")
  private Integer priority = null;
  
  @SerializedName("status")
  private String status = null;
  
  @SerializedName("state")
  private String state = null;
  
  @SerializedName("assignedTo")
  private String assignedTo = null;
  
  @SerializedName("recordedDate")
  private Object recordedDate = null;
  
  @SerializedName("description")
  private String description = null;
  

  
  /**
   * Id.
   **/
  @ApiModelProperty(value = "Id.")
  public BigDecimal getId() {
    return id;
  }
  public void setId(BigDecimal id) {
    this.id = id;
  }

  
  /**
   * Name of the plant.
   **/
  @ApiModelProperty(value = "Name of the plant.")
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getPriority() {
    return priority;
  }
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  
  /**
   * Status.
   **/
  @ApiModelProperty(value = "Status.")
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  
  /**
   * State.
   **/
  @ApiModelProperty(value = "State.")
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }

  
  /**
   * Assigned To.
   **/
  @ApiModelProperty(value = "Assigned To.")
  public String getAssignedTo() {
    return assignedTo;
  }
  public void setAssignedTo(String assignedTo) {
    this.assignedTo = assignedTo;
  }

  
  /**
   * Recorded date.
   **/
  @ApiModelProperty(value = "Recorded date.")
  public Object getRecordedDate() {
    return recordedDate;
  }
  public void setRecordedDate(Object recordedDate) {
    this.recordedDate = recordedDate;
  }

  
  /**
   * Description.
   **/
  @ApiModelProperty(value = "Description.")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Requirement requirement = (Requirement) o;
    return Objects.equals(id, requirement.id) &&
        Objects.equals(title, requirement.title) &&
        Objects.equals(priority, requirement.priority) &&
        Objects.equals(status, requirement.status) &&
        Objects.equals(state, requirement.state) &&
        Objects.equals(assignedTo, requirement.assignedTo) &&
        Objects.equals(recordedDate, requirement.recordedDate) &&
        Objects.equals(description, requirement.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, priority, status, state, assignedTo, recordedDate, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Requirement {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    assignedTo: ").append(toIndentedString(assignedTo)).append("\n");
    sb.append("    recordedDate: ").append(toIndentedString(recordedDate)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
