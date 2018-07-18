package com.qxb.student.common.module.api;

import com.qxb.student.common.Config;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.ExpertLabel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 订单
 */
public interface SysOrderApi {

    /**
     * 留学订单详情
     *
     * @param orderId   订单id
     * @param accountId 账户id
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("abroad/order/orderDetail")
    Observable<ApiModel<String>> abroadOrderDetail(@Field("orderId") String orderId, @Field("accountId") String accountId);

    /**
     * 问专家-删除订单
     *
     * @param orderId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("expert/deleteOrder")
    Observable<ApiModel<String>> expertDeleteOrder(@Field("order_id") String orderId);

    /**
     * 评价订单（用于留学订单）
     *
     * @param orderId
     * @param accountId
     * @param content
     * @param labels
     * @param score
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("order/evaluate")
    Observable<ApiModel<String>> evaluateOrder(@Field("orderId") String orderId, @Field("accountId") String accountId, @Field("content") String content, @Field("labels") String labels, @Field("score") String score);

    /**
     * 评价标签列表
     *
     * @param accountId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("abroad/order/labelList")
    Observable<ApiModel<List<ExpertLabel>>> abroadOrderLabelList(@Field("accountId") String accountId);

    /**
     * 创建订单
     *
     * @param accountId
     * @param channel
     * @param goodsCode
     * @param payWay
     * @param integral
     * @param orderId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("pay/createOrder")
    Observable<ApiModel<String>> payCreateOrder(@Field("account_id") String accountId, @Field("channel") String channel, @Field("goods_code") String goodsCode, @Field("pay_way") String payWay, @Field("integral") String integral, @Field("order_id") String orderId);

    /**
     * 查询学生用户激活卡信息
     *
     * @param accountId
     * @return
     */
    @Headers(Config.AUTH_CUSTOM)
    @FormUrlEncoded
    @POST("getUserCard")
    Observable<ApiModel<String>> getUserCard(@Field("account_id") String accountId);


}
