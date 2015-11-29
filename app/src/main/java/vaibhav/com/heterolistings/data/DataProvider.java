package vaibhav.com.heterolistings.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vaibhav on 11/27/15.
 *
 * This class is used to deserialize network response to Data class object.
 * It acts as a interface between data source (JSON/network) and data consumer (internal app components)
 * Internal app classes should always use this class to get the data.
 */
public class DataProvider {

    static public ArrayList<BundleData> getData() {

        String jsonString = "[\n" +
                "    {\n" +
                "        \"label\": \"20 % off on any product\",\n" +
                "        \"image\": \"http://media.askmebazaar.com/media/catalog/product/a/n/ankita-30-april-50.jpeg\",\n" +
                "        \"template\": \"product-template-1\",\n" +
                "        \"items\": [\n" +
                "            {\n" +
                "                \"label\": \"My awesome ad\",\n" +
                "                \"image_url\": \"http://stocks.img.askme.com/campaings/appimages/July/Casually-Cool-Look.jpg\",\n" +
                "                \"web-url\": \"http://www.askmebazaar.com/product.php?product_id=818256&utm_source=web&utm_medium=homepage&utm_campaign=Campaign\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"label\": \"Dealoftheday\",\n" +
                "        \"image\": \"http://media.askmebazaar.com/media/catalog/product/a/n/ankita-30-april-50.jpeg\",\n" +
                "        \"template\": \"product-template-2\",\n" +
                "        \"items\": [\n" +
                "            {\n" +
                "                \"label\": \"Myawesomedeal\",\n" +
                "                \"image_url\": \"http: //media.askmebazaar.com/media/catalog/product/thumbnails/150x150/6/c/6curtain.jpeg\",\n" +
                "                \"web-url\": \"http: //www.askmebazaar.com/product.php?product_id=818256&utm_source=web&utm_medium=homepage&utm_campaign=Campaign\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"label\": \"Myawesomedeal1\",\n" +
                "                \"image_url\": \"http: //stocks.img.askme.com/campaings/appimages/July/Casually-Cool-Look.jpg\",\n" +
                "                \"web-url\": \"http: //www.askmebazaar.com/product.php?product_id=818256&utm_source=web&utm_medium=homepage&utm_campaign=Campaign\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"label\": \"Myawesomedeal2\",\n" +
                "                \"image_url\": \"http: //media.askmebazaar.com/media/catalog/product/thumbnails/150x150/i/m/img_9145dh.jpeg\",\n" +
                "                \"web-url\": \"http: //www.askmebazaar.com/product.php?product_id=818256&utm_source=web&utm_medium=homepage&utm_campaign=Campaign\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"label\": \"Recentlyviewed\",\n" +
                "        \"image\": \"http: //media.askmebazaar.com/media/catalog/product/thumbnails/150x150/6/c/6curtain.jpeg\",\n" +
                "        \"template\": \"product-template-1\",\n" +
                "        \"items\": [\n" +
                "            {\n" +
                "                \"label\": \"Myawesomedeal\",\n" +
                "                \"image_url\": \"http: //media.askmebazaar.com/media/catalog/product/thumbnails/150x150/r/i/richa-1-aprl-15-41.jpeg\",\n" +
                "                \"web-url\": \"http: //www.askmebazaar.com/product.php?product_id=818256&utm_source=web&utm_medium=homepage&utm_campaign=Campaign\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"label\": \"Myawesomedeal\",\n" +
                "                \"image_url\": \"http: //media.askmebazaar.com/media/catalog/product/thumbnails/150x150/a/n/ankit-3-april-2015-41.jpg\",\n" +
                "                \"web-url\": \"http: //www.askmebazaar.com/product.php?product_id=818256&utm_source=web&utm_medium=homepage&utm_campaign=Campaign\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"label\": “Boxoffice\",\n" +
                "        \"image\": \"http: //media.askmebazaar.com/media/catalog/product/thumbnails/150x150/6/c/6curtain.jpeg\",\n" +
                "        \"template\": \"product-template-3\",\n" +
                "        \"items\": [\n" +
                "            {\n" +
                "                \"label\": \"Myawesomedeal\",\n" +
                "                \"image_url\": \"http: //media.askmebazaar.com/media/catalog/product/thumbnails/150x150/r/i/richa-1-aprl-15-41.jpeg\",\n" +
                "                \"web-url\": \"http: //www.askmebazaar.com/product.php?product_id=818256&utm_source=web&utm_medium=homepage&utm_campaign=Campaign\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"label\": \"Myawesomedeal\",\n" +
                "                \"image_url\": \"http: //media.askmebazaar.com/media/catalog/product/thumbnails/150x150/a/n/ankit-3-april-2015-41.jpg\",\n" +
                "                \"web-url\": \"http: //www.askmebazaar.com/product.php?product_id=818256&utm_source=web&utm_medium=homepage&utm_campaign=Campaign\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"label\": \"Myawesomedeal\",\n" +
                "                \"image_url\": \"http: //media.askmebazaar.com/media/catalog/product/thumbnails/150x150/a/n/ankit-3-april-2015-41.jpg\",\n" +
                "                \"web-url\": \"http: //www.askmebazaar.com/product.php?product_id=818256&utm_source=web&utm_medium=homepage&utm_campaign=Campaign\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"label\": \"Myawesomedeal\",\n" +
                "                \"image_url\": \"http: //media.askmebazaar.com/media/catalog/product/thumbnails/150x150/a/n/ankit-3-april-2015-41.jpg\",\n" +
                "                \"web-url\": \"http: //www.askmebazaar.com/product.php?product_id=818256&utm_source=web&utm_medium=homepage&utm_campaign=Campaign\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"label\": \"Myawesomedeal\",\n" +
                "                \"image_url\": \"http: //media.askmebazaar.com/media/catalog/product/thumbnails/150x150/a/n/ankit-3-april-2015-41.jpg\",\n" +
                "                \"web-url\": \"http: //www.askmebazaar.com/product.php?product_id=818256&utm_source=web&utm_medium=homepage&utm_campaign=Campaign\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"label\": \"Myawesomedeal\",\n" +
                "                \"image_url\": \"http: //media.askmebazaar.com/media/catalog/product/thumbnails/150x150/a/n/ankit-3-april-2015-41.jpg\",\n" +
                "                \"web-url\": \"http: //www.askmebazaar.com/product.php?product_id=818256&utm_source=web&utm_medium=homepage&utm_campaign=Campaign\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }, \n" +
                "        {\n" +
                "        \"label\": “FoodFriday\",\n" +
                "        \"image\": \"http: //media.askmebazaar.com/media/catalog/product/thumbnails/150x150/6/c/6curtain.jpeg\",\n" +
                "        \"template\": \"product-template-3\",\n" +
                "        \"items\": [\n" +
                "            {\n" +
                "                \"label\": \"Myawesomedeal\",\n" +
                "                \"image_url\": \"http: //media.askmebazaar.com/media/catalog/product/thumbnails/150x150/r/i/richa-1-aprl-15-41.jpeg\",\n" +
                "                \"web-url\": \"http: //www.askmebazaar.com/product.php?product_id=818256&utm_source=web&utm_medium=homepage&utm_campaign=Campaign\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"label\": \"Myawesomedeal\",\n" +
                "                \"image_url\": \"http: //media.askmebazaar.com/media/catalog/product/thumbnails/150x150/a/n/ankit-3-april-2015-41.jpg\",\n" +
                "                \"web-url\": \"http: //www.askmebazaar.com/product.php?product_id=818256&utm_source=web&utm_medium=homepage&utm_campaign=Campaign\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "]";

        jsonString = jsonString.replace(" ", "");
        jsonString = jsonString.replace("“", "\"");
        jsonString = jsonString.replace("”", "\"");


        Type type =  new TypeToken<List<BundleData>>(){}.getType();
        ArrayList<BundleData> bundleFeed = new Gson().fromJson(jsonString, type);

        return bundleFeed;
    }
}
