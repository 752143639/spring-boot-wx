package wx.realware.wx.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * 1、自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。
2、一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替。
3、创建自定义菜单后，菜单的刷新策略是，在用户进入公众号会话页或公众号profile页时，
如果发现上一次拉取菜单的请求在5分钟以前，就会拉取一下菜单，如果菜单有更新，就会刷新客户端的菜单。
测试时可以尝试取消关注公众账号后再次关注，则可以看到创建后的效果。
 * @author joe
 *
 */
public class Menu {
	public  final static String createUrl = "https://api.weixin.qq.com/cgi-bin/menu/create";//?access_token=ACCESS_TOKEN;
	public final static String queryUrl = "https://api.weixin.qq.com/cgi-bin/menu/get";//?access_token=ACCESS_TOKEN";
	public final static String delUrl = "https://api.weixin.qq.com/cgi-bin/menu/delete";//?access_token=ACCESS_TOKEN";
	
	public static String createMenu(String access_token)
	{
		 String url = createUrl + "?access_token="+access_token;
		 //第一个 菜单按钮
		 Map<String, Object> fb1 = new HashMap<String,Object>();
		 fb1.put("name", "公共查询");
		 Map<String,String> fb1_sub1 = new HashMap<String,String>();
		 fb1_sub1.put("type","click");
		 fb1_sub1.put("name","天气查询");
		 fb1_sub1.put("key","tianQi");
		 Map<String,String> fb1_sub2 = new HashMap<String,String>();
		 fb1_sub2.put("type","click");
		 fb1_sub2.put("name","公交查询");
		 fb1_sub2.put("key","gongJiao");
		 Map<String,String> fb1_sub3 = new HashMap<String,String>();
		 fb1_sub3.put("type","click");
		 fb1_sub3.put("name","翻译");
		 fb1_sub3.put("key","fanYi");
		
	     
	     //第二个菜单按钮
	     Map<String, Object> fb2 = new HashMap<String,Object>();
		 fb2.put("name", "扫码");
		 Map<String,String> fb2_sub1 = new HashMap<String,String>();
		 fb2_sub1.put("type","scancode_waitmsg");
		 fb2_sub1.put("name","扫码带提示");
		 fb2_sub1.put("key","rselfmenu_0_0");
		 Map<String,String> fb2_sub2 = new HashMap<String,String>();
		 fb2_sub2.put("type","scancode_push");
		 fb2_sub2.put("name","扫码推事件");
		 fb2_sub2.put("key","rselfmenu_0_1");
		 Map<String,String> fb2_sub3 = new HashMap<String,String>();
		 fb2_sub3.put("type","pic_sysphoto");
		 fb2_sub3.put("name","系统拍照发图");
		 fb2_sub3.put("key","rselfmenu_1_0");
		 Map<String,String> fb2_sub4 = new HashMap<String,String>();
		 fb2_sub4.put("type","pic_photo_or_album");
		 fb2_sub4.put("name","拍照或者相册发图");
		 fb2_sub4.put("key","rselfmenu_1_1");
		 Map<String,String> fb2_sub5 = new HashMap<String,String>();
		 fb2_sub5.put("type","pic_weixin");
		 fb2_sub5.put("name","微信相册发图");
		 fb2_sub5.put("key","rselfmenu_1_2");
		 
		//第三个个 菜单按钮
		 Map<String, Object> fb3 = new HashMap<String,Object>();
		// fb3.put("name", "其他");
		 fb3.put("type","发送位置");
		 fb3.put("name","location_select");
		 fb3.put("key","rselfmenu_2_0");
		 //Map<String,String> fb3_sub1 = new HashMap<String,String>();
		 
		
		 List<Object> fb1_list = new ArrayList<Object>();
		 fb1_list.add(fb1_sub1);
		 fb1_list.add(fb1_sub2);
		 fb1_list.add(fb1_sub3);
		 fb1.put("sub_button", fb1_list);
		 
		 List<Object> fb2_list = new ArrayList<Object>();
		 fb2_list.add(fb2_sub1);
		 fb2_list.add(fb2_sub2);
		 fb2_list.add(fb2_sub3);
		 //fb2_list.add(fb2_sub4);
		// fb2_list.add(fb2_sub5);
		 fb2.put("sub_button", fb2_list);
		 
		 List<Object> list = new ArrayList<Object>();
		 list.add(fb1);
		 list.add(fb2);
		 //list.add(fb3);
		/* JSONObject buttons = new JSONObject();
		 JSONObject but1 = new JSONObject(); 
		 but1.putAll(fb1);
		 JSONObject but2 = new JSONObject(); 
		 but2.putAll(fb2);*/
	     
		 
		 JSONObject buttons = new JSONObject();
		 buttons.put("button", list);
	     //jsonThree.putAll(fb3);
	     System.out.println(buttons.toString());
	     JSONObject result  = HttpClientUtil.doPost(url, buttons);
	     System.out.println(result.toString());
	     return "";
	}
	
	public static void main(String args[])
	{
		createMenu("11_xJyEf95qZBkbJmhep1kFslANBNvIRD9qZTG033XVMt2cMdjhq5_wIp3tLQRXZHX7xnIIR5UL_BciSanqcR446ay7dir9NqfaJX0c45mgjMCmz6xK1jNoZ53Jo2IjDtN8w7fbVBWaiLiGpm1pPGOaADAYPX");
	}
		
}
