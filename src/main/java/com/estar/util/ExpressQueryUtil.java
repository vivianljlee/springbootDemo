package com.estar.util;
//package com.csr.base.util;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.util.EntityUtils;
//
//import com.csr.mall.order.dao.entity.MallLogistice;
//import com.csr.mall.order.dao.entity.MallWebOrder;
//import com.csr.mall.order.service.MallLogisticeService;
//import com.csr.mall.order.service.MallOrderService;
///**
// * 
// * @author 张立然   查询物流的 共通方法
// *  
// */
//public class ExpressQueryUtil {
//	private static String appcode = "96ce665b6cf14e8e9771124bf793b7d3";
//	
//	@Resource(name="mallOrderService")
//	private MallOrderService mallOrderService;
//	
//	@Resource(name="mallLogisticeService")
//	private MallLogisticeService mallLogisticeService;
//	
//	public static void main(String[] args) {
//	    String host = "http://jisukdcx.market.alicloudapi.com";
//	    String path = "/express/query";
//	    String method = "GET";
//	    Map<String, String> headers = new HashMap<String, String>();
//	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
//	    headers.put("Authorization", "APPCODE " + appcode);
//	    Map<String, String> querys = new HashMap<String, String>();
//	    querys.put("number", "12025167453011");
//	    querys.put("type", "auto");
//	    
//	    try {
//	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
//	    	System.out.println(response.toString());
//	    	
//	    	//获取response的body
//	    	System.out.println(EntityUtils.toString(response.getEntity()));
//	    	
//	    	//EntityUtils.toString(HttpEntity)方法被使用了多次。所以每个方法内只能使用一次。
//	    	
////			Map map = JsonPluginsUtil.jsonToMap(EntityUtils.toString(response.getEntity()));
////			String result = (String) map.get("result");
////			System.out.println(result);
////			Map map1 = JsonPluginsUtil.jsonToMap(result);
////			String list = (String) map1.get("list");
//////			System.out.println(list);
////			List<MallLogistice> mallLogisticeList=JsonPluginsUtil.jsonToBeanList(list, MallLogistice.class);
//////			for(MallLogistice mallLogistice:mallLogisticeList) {
//////				System.out.println(mallLogistice.getStatus());
////////				System.out.println(mallLogistice.getStatus());
//////			}
//	    } catch (Exception e) {
//	    	e.printStackTrace();
//	    }
//	}
//	/**
//	 * 
//	 * @param number 订单号
//	 * @throws ParseException 
//	 */
//	public List<MallLogistice> expressQuery(String number) throws ParseException {
//		/*********************************************第一步 根据物流号查订单-开始*********************************************/
//		List<MallLogistice> mallLogisticeList =new ArrayList<MallLogistice>();
//		MallWebOrder mallWebOrder =new MallWebOrder();
//		
//		if(mallWebOrder==null || "".equals(mallWebOrder)) {
//			return mallLogisticeList;
//		}
//		/*********************************************第一步 根据物流号查订单-结束*********************************************/
//		
//		/*********************************************第二步 判断订单状态 *********************************************/
//		// 10001:待付款 
//		// 10002：待发货 
//		// 10003:待收货 
//		// 10004:待施工
//		// 10005:待评论 
//		// 10006:已完成 
//		// 10007:退款中 
//		// 10008:已退款 
//		// 10009:已取消 
//		// 10010:超时取消
//		// 只有待收货的时候才能查  
//		if(mallWebOrder.getOrderStatus().equals("10003")) {
//		/*********************************************第二步 判断订单状态-结束*********************************************/
//		   
//		   /*********************************************第三步 和订单物流查询时间对比-开始*********************************************/
//		   SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		   Date begin=dfs.parse("2004-03-26 13:30:24");
//		   Date end = new Date();
//		   long between=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒
//		   long min=between/60;
//		   System.out.println(min);
//		   
//		   /*********************************************第三步 和订单物流查询时间对比-结束*********************************************/
//		   if(min<120) {
//				String host = "http://jisukdcx.market.alicloudapi.com";
//			    String path = "/express/query";
//			    String method = "GET";
//			    Map<String, String> headers = new HashMap<String, String>();
//			    
//			    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
//			    headers.put("Authorization", "APPCODE " + appcode);
//			    Map<String, String> querys = new HashMap<String, String>();
//			    querys.put("number", number);
//			    querys.put("type", "auto");
//
//			    try {
//			    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
//			    	System.out.println(response.toString());
//			    	
//			    	
//			    	//获取response的body
////			    	System.out.println(EntityUtils.toString(response.getEntity()));
//			    	
//					Map map = JsonPluginsUtil.jsonToMap(EntityUtils.toString(response.getEntity()));
//					String result = (String) map.get("result");
////					System.out.println(result);
//					Map map1 = JsonPluginsUtil.jsonToMap(result);
//					String list = (String) map1.get("list");
////					System.out.println(list);
//					List<MallLogistice> saveMallLogisticeList=JsonPluginsUtil.jsonToBeanList(list, MallLogistice.class);
//					for(MallLogistice mallLogistice:saveMallLogisticeList) {
//						System.out.println(mallLogistice.getStatus());
////						System.out.println(mallLogistice.getStatus());
//					}
//			    } catch (Exception e) {
//			    	e.printStackTrace();
//			    }
//		   }else {
//			   mallLogisticeList=mallLogisticeService.getMallLogisticeList(mallWebOrder.getOrderId());
//		   }
//		}else {
//			 mallLogisticeList=mallLogisticeService.getMallLogisticeList(mallWebOrder.getOrderId());
//		}
//		return mallLogisticeList;
//	}
//	
//}
