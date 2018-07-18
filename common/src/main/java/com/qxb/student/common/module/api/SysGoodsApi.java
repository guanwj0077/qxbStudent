package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 系统商品
 * @author
 */
public interface SysGoodsApi {

    /**
     * 获取商品信息
     * @param goodsCode 商品编码
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("goods/getGoodsByCode")
    Observable<ApiModel<String>> getGoodsByCode(@Field("goods_code") String goodsCode);


}
