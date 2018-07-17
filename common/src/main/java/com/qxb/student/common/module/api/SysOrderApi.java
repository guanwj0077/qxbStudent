package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.AppVersion;
import com.qxb.student.common.module.bean.ExpertLabel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 订单
 */
public interface SysOrderApi {

     /**
     * 留学订单详情
     * @param orderId 订单id
     * @param accountId 账户id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("abroad/order/orderDetail")
    Observable<ApiModel<String>> abroadOrderDetail(@Query("orderId") String orderId, @Query("accountId") String accountId);

    /**
     * 问专家-删除订单
     * @param orderId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("expert/deleteOrder")
    Observable<ApiModel<String>> expertDeleteOrder(@Query("order_id") String orderId);

    /**
     * 评价订单（用于留学订单）
     * @param orderId
     * @param accountId
     * @param content
     * @param labels
     * @param score
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("order/evaluate")
    Observable<ApiModel<String>> evaluateOrder(@Query("orderId") String orderId, @Query("accountId") String accountId,@Query("content") String content, @Query("labels") String labels,@Query("score") String score);

    /**
     * 评价标签列表
     * @param accountId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @POST("abroad/order/labelList")
    Observable<ApiModel<List<ExpertLabel>>> abroadOrderLabelList(@Query("accountId") String accountId);

}
