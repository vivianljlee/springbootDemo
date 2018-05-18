package com.estar.util;


public class Constant {

	/** 资料类别.文档 */
	public static final String DATA_TYPE_DOC = "0";
	/** 资料类别.音频 */
	public static final String DATA_TYPE_AUD = "1";
	/** 资料类别.视频 */
	public static final String DATA_TYPE_VID = "2";
	/** 资料类别.图片 */
	public static final String DATA_TYPE_IMG = "3";
	
	public static final String EMPTY_STR = "";
	
	/****************** OSS配置  *****************************/
 
    
    /****************** 手机注册用户判定结果*****************************/
    public final static String FRONT_USER_TEL_REGISTER_NOT = "2";
    
    /****************** 专家问答 *****************************/
    
    //在架状态:上架
    public final static String SHELVES_STATUS_ON = "0";
    
    //在架状态:下架
    public final static String SHELVES_STATUS_OFF = "1";
    
	//专家问答
    public final static String BUSI_MODE_E = "E";
	
    //资讯
    public static final String BUSI_MODE_N = "N";
    
    //线上商城
    public static final String BUSI_MODE_L = "L";
    
    //二手车销售
    public static final String BUSI_MODE_S = "S";
    
	//前台历史搜索记录最大数
    public final static int FRONT_SCH_LIMIT = 6;
    
    //文件归属分类：专家头像
    public final static String FILE_CLY_HEAD = "01";
    
    //文件归属分类：封面图片
    public final static String FILE_CLY_NEWS = "02";
    
    //文件归属分类：封面视频
    public final static String FILE_CLY_VIDEO = "03";
    
    //文件归属分类：内容图片
    public final static String FILE_CLY_CONTENTS = "04";
    
    //文件类型：视频
    public final static String FILE_CLY_TYPE_VIDEO = "VIDEO";
    
    //资讯款式:1图1文字
    public final static String NEWS_TEMPLATE_TYPE_11 = "11";
    
    //资讯款式:3图1文字
    public final static String NEWS_TEMPLATE_TYPE_31 = "31";
    
    //资讯款式:1视频1文字
    public final static String NEWS_TEMPLATE_TYPE_1V = "1V";
    
    //资讯文本类型:富文本
    public final static String NEWS_TEXT_TYPE_FU = "0";
    
    //资讯文本类型:非富文本
    public final static String NEWS_TEXT_TYPE_NFU = "1";
    
    
    
    //权限类型为菜单
    public final static String PERMISSION_TYPE_MENU = "01";
    
	
    /****************** 线上上城 *****************************/
    //置顶
    public final static String TOP_STATUS_ON = "0";
    
    //退顶
    public final static String TOP_STATUS_OFF = "1";
    
    //文件归属分类：套餐缩略图
    public final static String FILE_CLY_PKG_THBPIC = "05";
    
    //文件归属分类：套餐滚动图
    public final static String FILE_CLY_PKG_ROLL_PIC = "06";
    
    //文件归属分类：套餐详情介绍图
    public final static String FILE_CLY_PKG_DETAIL_PIC = "07";
    
    //文件归属分类：前端用户上传帖子图片
    public final static String FILE_CLY_HD_USER_UP_PIC = "08";
    
    //文件归属分类：视频缩略图
    public final static String FILE_CLY_VIDEO_THBPIC = "09";
    
    //文件归属分类：深度养护车品图片
    public final static String FILE_CLY_DC_CAR_PIC = "10";
    
    //OSS路径 bucketName：专家问答
    public final static String OSS_FILE_BUCKET_NAME_ZJWD = "zjwd";
    
  //不删除
    public final static String NOT_DEL_FLAG = "0";
    //删除
    public final static String YES_DEL_FLAG = "1";
    
    // 启用(0)
    public final static String YES_ENABLE_STATE = "0";
    // 禁用(1)
    public final static String NOT_ENABLE_STATE = "1";
    // 分页条数
    public final static String PAGE_SIZE = "5";
    //分页页码
    public final static String PAGE_NO = "1";
    //滚动图片长度
    public final static int GDPIC_TYPE = 6;
    //套图图片长度
    public final static int TTPIC_TYPE = 8;
    //成功
    public final static String SUCCESS = "1";
    //失败
    public final static String FAILURE = "0";
    //失败
    public final static String FAILURE_TOKEN = "签名错误";
    
    //品牌编号	
    public final static String BRAND_CODE = "1001";
    //子字典CODE	
    public final static String DIC_DETAIL_CODE = "10001";
    //子字典类型(商品单位码)
    public final static String DIC_DETAIL_DIC_GS_UTTYPE = "GS_UT";
    //子字典类型(门店类别1下架，0不下架)
    public final static String NOT_SHOP_SHELVESTYPE = "0";
    //子字典类型(施工门店)
    public final static String DIC_DETAIL_DIC_EF_SRTYPE = "EF_SR";
    //子字典类型(快递类型)
    public final static String DIC_DETAIL_DIC_EX_CPTYPE = "EX_CP";
    //图片地址是否需要转换 0:不需要转换 1:转换
    public final static String PIC_TYPE = "1";
    //系统ID
    public final static String SYS_ID = "000000000000000000000000000000000000";
    //默认施工服务图片
    public final static String WORK_SERVICE_PIC = "img/sgfw.jpg";
    //证书地址
    public final static String APICLIENT_CERT = "cert/apiclient_cert.p12";
    //车品到家
	public static final String SIX = "99999";
	 //退款中
    public static final String ORDER_STATUS_REFUND = "10007";
    
    //是上架
    public static final String YES_SHELVES_STATUS= "0";
    //是下架
    public static final String NO_SHELVES_STATUS= "1";
    //是优选
    public static final String YES_BATTER_SELECTION_STATUS= "0";
    //是退优
    public static final String NO_BATTER_SELECTION_STATUS= "1";
    //车品商城
    public static final String CAR_PRODUCTS_MALL= "20";
    //车品优选
    public static final String CAR_PRODUCTS_OPTIMIZATION= "21";
    //商品类型
    public final static String PRODUCT_TYPE = "10001";
    //退款类型
    public final static String REFUND_TYPE = "2";
    //物流类型
    public final static String LOGISTICE_TYPE = "1";
    //门店类型
    public final static String SHOP_TYPE = "0";
    
    //待评论
    public final static String COMMENT_TYPE = "10002";
    //已完成
    public final static String FINISH_TYPE = "10003";
    //订单状态
    //待付款
    public final static String WAIT_PAYMENT_TYPE = "10001";
    //待收货
    public final static String WAIT_GOODS_TYPE = "10003";
    //待评论
    public final static String WAIT_COMMENTS_TYPE = "10005";
    //超时取消
    public final static String TIMEOUT_CANCEL_TYPE = "10010";
    //字典系统0可改
    public final static String DIC_YES_SYS="0";
    /******************************报表***********************************/
    public final static String JS_BKUSER_NAME = "会员报表.xlsx";
    public final static String JS_BKUSER_REPORT = "/templease/user/bkuser.xlsx";
    public final static String JS_SHOP_NAME = "门店结算.xlsx";
    public final static String JS_SHOP_REPORT = "/templease/settel/shopsettel.xlsx";
    public final static String JS_SHOP_ORDER_NAME = "门店订单明细.xlsx";
    public final static String JS_SHOP_ORDER_REPORT = "/templease/settel/shopordersettel.xlsx";
    public final static String JS_LOGIS_NAME = "物流结算.xlsx";
    public final static String JS_LOGIS_REPORT = "/templease/settel/logissettel.xlsx";
    public final static String JS_LOGIS_ORDER_NAME = "物流订单明细.xlsx";
    public final static String JS_LOGIS_ORDER_REPORT = "/templease/settel/logisordersettel.xlsx";
    public final static String JS_REFUND_NAME = "退款结算.xlsx";
    public final static String JS_REFUND_REPORT = "/templease/settel/refundsettel.xlsx";
    public final static String JS_SHOP_HIS_NAME = "门店结算履历.xlsx";
    public final static String JS_SHOP_HIS_REPORT = "/templease/shopsetteljs/shopsetteljs.xlsx";
    public final static String JS_REFUND_HIS_NAME = "退款结算履历.xlsx";
    public final static String JS_REFUND_HIS_REPORT = "/templease/shopsetteljs/refundsetteljs.xlsx";
    public final static String JS_LOGIS_HIS_NAME = "物流结算履历.xlsx";
    public final static String JS_LOGIS_HIS_REPORT = "/templease/shopsetteljs/logissetteljs.xlsx";
    public final static String JS_PAYORDER_HIS_NAME = "买单结算履历.xlsx";
    public final static String JS_PAYORDER_HIS_REPORT = "/templease/shopsetteljs/payOrdersetteljs.xlsx";
	public static int CELL=10;
}
