package geuylq.mobsoft.requirementmanager.mock.interceptors;

import android.net.Uri;

import geuylq.mobsoft.requirementmanager.network.GsonHelper;
import geuylq.mobsoft.requirementmanager.network.NetworkConfig;
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

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "requirements") && request.method().equals("GET")) {
            memoryRepository.open(null);
            responseString = GsonHelper.getGson().toJson(memoryRepository.getRequirements());
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}
