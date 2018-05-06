package geuylq.mobsoft.requirementmanager.network.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class Account   {
  
  @SerializedName("userName")
  private String userName = null;
  
  @SerializedName("password")
  private String password = null;

  public Account() {

  }

  public Account(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }
  

  
  /**
   * Username.
   **/
  @ApiModelProperty(value = "Username.")
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }

  
  /**
   * Email.
   **/
  @ApiModelProperty(value = "Password.")
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Account account = (Account) o;
    return Objects.equals(userName, account.userName) &&
        Objects.equals(password, account.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Account {\n");
    
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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
