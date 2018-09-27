package wx.realware.wx.model;

/**
 * 自定义菜单事件
 * @author joe
 * 
 */
public class ClickEventMessage extends EventMessage {

	private String EventKey;		
	//当event==CLICK   事件KEY值，与自定义菜单接口中KEY值对应
	//当event==VIEW    事件KEY值，设置的跳转URL	      
	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
}
