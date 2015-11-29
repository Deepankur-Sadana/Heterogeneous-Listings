package vaibhav.com.heterolistings.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Vaibhav on 11/27/15.
 *
 * Data class that represents each bundle of information that comes in JSON response.
 */
public class BundleData {

    public String label;
    public String image;
    public String template;
    public ArrayList<BundleItem> items;

    public static class BundleItem {
        public String label;
        @SerializedName("image_url")
        public String imageUrl;
        @SerializedName("web-url")
        public String webUrl;
    }

}
