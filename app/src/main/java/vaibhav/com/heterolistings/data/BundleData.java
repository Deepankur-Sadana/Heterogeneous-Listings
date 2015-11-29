package vaibhav.com.heterolistings.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Vaibhav on 11/27/15.
 *
 * Data class that represents each bundle of information that comes in JSON response.
 */
public class BundleData {

    String label;
    String image;
    String template;
    ArrayList<BundleItem> items;

    private static class BundleItem {
        String label;
        @SerializedName("image_url")
        String imageUrl;
        @SerializedName("web-url")
        String webUrl;
    }

}
