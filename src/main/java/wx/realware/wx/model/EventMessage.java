package wx.realware.wx.model;

public class EventMessage extends Message {

	private String Event;			
	//事件类型，subscribe(订阅)、unsubscribe(取消订阅)  SCAN、LOCATION(地理位置)
	//CLICK(点击菜单拉取消息时的事件推送)  VIEW(点击菜单跳转链接时的事件推送)
	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}
}
