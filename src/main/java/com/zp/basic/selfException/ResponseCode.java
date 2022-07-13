package com.zp.basic.selfException;

/**
 * @author junyuan.huang
 * @create 2020/3/9 15:32
 */
public enum ResponseCode {

    SUCCESS(1, "成功"),

    INVALID_USER_ID(-2001, "无效的用户"),

    SYSTEM_WRONG(-200, "系统繁忙，请稍后重试"),
    OBJECT_NOT_FOUND(-201, "未找到请求的数据"),
    BAD_REQUEST(-203, "无效的请求"),
    BAD_TIME_PARAM(-299, "卸货时间不能早于装货时间"),
    UPLOAD_FILE_ERROR(-204, "文件上传错误"),
    @Deprecated
    //无使用
            OPERATION_ERROR(-300, "操作失败，请稍后重试"),
    USER_NOT_LOGIN(-1000, "用户未登录"),
    FORBIDDEN(403, "权限不足"),
    @Deprecated
    //无使用
            SERVICE_QUERRY_ERROR(-1, "服务错误"),
    @Deprecated
    //无使用
            RESPONSE_USE_ERROR_MSG(-9999, ""),
    PARAMS_ERROR(9001, "参数错误"),
    @Deprecated
    //识别到后 提示错误信息 然后返回小黑板 使用中
            NUMBER_FORMAT_ERROR(9002, "数据格式转换异常"),
    ALREADY_DEL(-9998, "该货源已经被删除"),
    PERMISSION_DENIED(-13, "用户权限不足(-13)"),
    PERMISSION_DENIED_APP_TYPE(-14, "用户权限不足(-14)"),
    PERMISSION_DENIED_ACCOUNT_TYPE(-15, "用户权限不足(-15)"),
    PERMISSION_DENIED_HCB_AUTH(-16, "用户权限不足(-16)"),
    ALREADY_ORDER(-9997, "该货源已经被订走"),
    WRONG_CITY(-9996, "城市code异常"),
    NOT_EXIST(-9995, "货源不存在"),
    PER_DAY_COUNT_USE_UP(-9994, "今日发货量已超过上限，请明日再来！如有疑问，请联系客服。"),
    SENSITIVE_WORD_NOT_PASS(-10002, "货源敏感词校验不通过"),
    NOT_EXIST_YMM_USER(-10001, "hcb用户Id未关联ymm用户Id"),
    SIGN_FAIL(-10000, "验签失败"),
    INCORRECT_INSURANCE_INFO(-10003, "投保信息不一致，请校验后重新发布"),
    COMPANY_NO_AURHORITY_ERROR(-10004, "您暂时无法发布满运宝货源，如有疑问请联系销售人员"),
    EXTRA_ADD_PRICE_ERROR(-10005, "每次加价不得超过9999元"),
    NO_ESIGN_AUTHORIZATION_ERROR(-10006, "E签宝授权失败"),
    EMPTY_CITY(-10009, "请选择具体城市"),
    CANT_PUBLISH_DANGERROUS_GOODS(-10007, "货物名称不能为危险品"),
    PUBLISH_SAME_CARGO_ERROR(-10008, "您已经发货成功，请勿重复发货"),
    NOT_SUPPORT_CARGO_TYPE_ERROR(-10009, "不支持当前货源类型"),
    CHECK_GOODS_NAME_ERROR(-10010, "货名不合规，请重新输入货名信息"),

    LOW_VERSION(-10012, "当前版本过低，请尽快升级"),
    LOAD_DETAIL_ADDRESS_ACQUIRED(-10013, "请输入装货详细地址"),
    UNLOAD_DETAIL_ADDRESS_ACQUIRED(-10014, "请输入卸货详细地址"),
    BIZ_CHECK_FAIL(9002, "业务校验未通过"),
    CARGO_HAS_EXPIRE(-10015, "该货源已下架"),

    //专线
    SPECIALLINE_NOT_SUPPORT_ADD_COMMON_CARGO(-10015, "暂不支持添加常发货源"),
    CONSIGNEE_NAME_ERROE(-10016, "非法的收货人姓名"),
    CARGO_NAME_ERROE(-10018, "非法的货物名称"),
    CONSIGNEE_TEL_ERROE(-10017, "非法的收货人联系方式"),
    DIRECT_CONSIGNOR_PERMISSION_ERROR(-10019, "您非直客货主，请联系客服开通"),
    LONG_TIME_NO_OPERATE(-10020, "因为长时间未操作，请您重新发货"),
    //低频货源
    LOW_FEED_BACK_ENTRUST_ERROR(-10018, "委托失败"),

    LOAD_STRICT_ADDRESS_ACQUIRED(-10019, "装货城市请精确至区/县"),
    MIDDLE_STRICT_ADDRESS_ACQUIRED(-10020, "途径城市请精确至区/县"),
    UNLOAD_STRICT_ADDRESS_ACQUIRED(-10021, "卸货城市请精确至区/县"),
    LOAD_CITY_ADDRESS_ACQUIRED(-10022, "装货城市请精确至市/区/县"),
    UNLOAD_CITY_ADDRESS_ACQUIRED(-10023, "卸货城市请精确至市/区/县"),
    NO_ENTERPRISE_AUTH_EXCEPTION(-10026, "您当前已不是企业调度，无法发布此类型货源"),
    DUPLICATE_CLICK_ON_LOADING_ERROR(-10029, "加载中，请稍后再试吧"),
    HAVE_NO_CARGO_COUNT_ERROR(-10030, "您当前发货次数已用光，不能发布非指派货源。仅能免费发布满运宝指派订单"),
    LOAD_DETAIL_ADDRESS_OVERLENGTH(-10031, "装货地址长度不能大于250个字"),
    UNLOAD_DETAIL_ADDRESS_OVERLENGTH(-10032, "卸货地址长度不能大于250个字"),
    RESEND_ERROR(10016, "该货源不支持快速重发"),
    // 审核相关
    NOT_AUTHORIZED(-11001, "资料审核未通过，请重新提交审核"),
    // 报价2.0版本
    QUOTE_LOW_VERSION(-11002, "请升级到最新版本"),
    //用户未命中
    CUSTOMER_NOT_IDENTITY(-11003, "用户未实名"),

    JUMP_TO_ORDER(-11004, "命中订车"),
    LOCK_TIPS(-10005, "锁定提示"),
    LOCK_ERROR(-10006, "锁定失败"),


    STASH_DATA_CHECK_FAIL(-11028, "您输入的最多可加金额需要大于0"),
    PLATFORM_PRICE_RESULT_CHECK_FAIL(-11029, "获取价格失败，请稍后重试"),
    PLATFORM_PRICE_RESULT_CHECK_ERROR(-11030, "正在获取价格，请稍后再试"),
    EXPECT_FREIGHT_TOO_LOW_EXCEPTION(-11032, "期望运费不得低于%s元"),
    EXPECT_FREIGHT_TOO_HIGH_EXCEPTION(-11033, "期望运费不得高于%s元"),
    EXPECT_FREIGHT_ADD_BASE_EXCEPTION(-11034, "请输入%s的整数倍"),
    EXPECT_FREIGHT_ADD_LOWEST_EXCEPTION(-11035, "最少可加%s元"),
    EXPECT_FREIGHT_ADD_HIGHEST_EXCEPTION(-11036, "请合理填写运费金额"),
    STARTING_PRICE_REQUIRED_EXCEPTION(-11037, "起拍价必填"),

    RISK_SENSITIVE_WORD_EXCEPTION(-11037, "风控敏感词服务异常"),


    QUERY_PLATFORM_PRICE_ERROR(-20002, "查询报价异常，请重试"),
    MARKUP_PRICE_EXCEPTION_GREATER_THAN_EQUALS_ZERO(-10026, "您输入的最多可加金额不能小于0"),
    EXPECT_FREIGHT_EXCEPTION(-10025, "您输入的运费需要大于0"),
    EXPECT_FREIGHT_EXCEPTION_V2(-10025, "请输入运费"),
    GENERAL_INVOICE_CONFLICT(-10031, "当前线路暂不支持开具普通发票，已默认为您选中不开票，给您带来不便请谅解。"),
    PAY_METHOD_EXCEPTION(-10023, "请选择支付方式"),

    //限制出价 --> 阻断标识 (配置文案提示)
    NO_PLATFORM_PRICE(-20001, "暂无报价"),
    BID_LIMIT(-20002, "限制出价"),
    // 短途超时，强制刷新渲染流程
    FORCE_REFRESH(-20003, "强制刷新"),
    BAD_CASE_CARGO_NAME(20001, "输入内容不能作为货物名称"),
    // 短途独立小程序用
    JUMP_PLATFORM_APPLETS(-20004, "短途出价失败，点击发货将跳转至普通发货"),
    //需要告警的异常code
    SYSTEM_ERROR_EXCEPTION(-30000, "系统异常错误"),
    GET_WECAHT_TOKEN_FAIL(40001, "获取微信小程序Token失败"),
    GET_WECAHT_QRCODE_FAIL(40002, "获取微信小程序二维码失败"),

    INVALID_ADDRESS_FOR_STATION(-10038, "地址输入不合法，请补充归属地"),
    LOADADDRESS_EMPTY(-10039, "请输入装货地址"),
    MEMBER_CHECK_ERROR(-10040, "会员信息校验失败"),
    ;

    private int code;

    private String msg;

    private ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String formatMsg(Object... args) {
        try {
            return String.format(msg, args);
        } catch (Throwable e) {
            return msg;
        }
    }
}
