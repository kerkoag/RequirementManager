package geuylq.mobsoft.requirementmanager.network.api;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import geuylq.mobsoft.requirementmanager.network.model.Requirement;
import geuylq.mobsoft.requirementmanager.network.model.Error;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface RequirementsApi {
  
  /**
   * Get all requirements
   * Returns all the requirements available in the system.
   * @return Call<List<Requirement>>
   */
  
  @GET("requirements")
  Call<List<Requirement>> requirementsGet();
    

  
  /**
   * Get one requirement
   * 
   * @param id Id.
   * @return Call<Requirement>
   */
  
  @GET("requirements/{id}")
  Call<Requirement> requirementsIdGet(
    @Path("id") BigDecimal id
  );

  
  /**
   * Create or update requirement
   * 
   * @param id Id.
   * @param requirement The requirement
   * @return Call<Requirement>
   */
  
  @POST("requirements/{id}")
  Call<Requirement> requirementsIdPost(
    @Path("id") BigDecimal id, @Body Requirement requirement
  );

  
  /**
   * Delete requirement
   * 
   * @param id Id.
   * @return Call<Requirement>
   */
  
  @DELETE("requirements/{id}")
  Call<Requirement> requirementsIdDelete(
    @Path("id") BigDecimal id
  );

  
}
