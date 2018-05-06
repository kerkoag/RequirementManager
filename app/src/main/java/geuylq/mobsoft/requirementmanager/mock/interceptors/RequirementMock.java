package geuylq.mobsoft.requirementmanager.mock.interceptors;

import android.net.Uri;

import org.json.JSONObject;

import geuylq.mobsoft.requirementmanager.network.GsonHelper;
import geuylq.mobsoft.requirementmanager.network.NetworkConfig;
import geuylq.mobsoft.requirementmanager.network.model.Account;
import geuylq.mobsoft.requirementmanager.repository.MemoryRepository;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static geuylq.mobsoft.requirementmanager.mock.interceptors.MockHelper.makeResponse;

public class RequirementMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();

        MemoryRepository memoryRepository = new MemoryRepository();

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "login") && request.method().equals("POST")) {
            memoryRepository.open(null);

            String jsonString = MockHelper.bodyToString(request);

            Account account = GsonHelper.getGson().fromJson(jsonString, Account.class);

            responseString = GsonHelper.getGson().toJson(memoryRepository.login(account.getUserName(), account.getPassword()));

            if(responseString.equals("true")){
                responseCode = 200;
            }
            else
                responseCode = 404;

        }
        else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "requirements") && request.method().equals("GET")) {
            memoryRepository.open(null);
            responseString = GsonHelper.getGson().toJson(memoryRepository.getRequirements());
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 500;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}
