package io.btrshop.data.source.api;

import java.util.List;

import io.btrshop.detailsproduct.domain.model.Product;
import io.btrshop.products.domain.model.BeaconJson;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by charlie on 28/10/16.
 *
 * Interface : all the apis for the products.
 *
 */
public interface ProductsService {

    /**
     * Function that retrieve the call for the product with EAN and a list of beacon.
     *
     * @param ean
     * @param listBeacon {@link BeaconJson}
     * @return a product {@link Product}
     */
    @POST("products/{ean}")
    Observable<Product> postProduct(@Path("ean") String ean,
                                    @Body List<BeaconJson> listBeacon);

    @POST("products/recommendation")
    Observable<Product> postRecommendation(@Query("ean") String ean,
                                           @Body List<String> eansList);

    @GET("products/recommendation")
    Observable<List<Product>> getAssociated(@Query("eans[]") List<String> eanList);

    @GET("products/nearby")
    Observable<List<Product>> getNearby(@Query("uuids[]") List<String> uuidList);

}
