package wx.realware.wx.model;

//扫描带参数二维码事件
public class TicketSubEventMessage extends EventMessage{

	private String EventKey;			
	//当 event==	subscribe时表示：事件KEY值，qrscene_为前缀，后面为二维码的参数值
	//当 event== SCAN 时表示：事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
	private String Ticket;				
	//当 event==subscribe时表示：二维码的ticket，可用来换取二维码图片
	////当 event== SCAN 时表示：二维码的ticket，可用来换取二维码图片
	public String getEventKey() {
		return EventKey;
	}
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
	public String getTicket() {
		return Ticket;
	}
	public void setTicket(String ticket) {
		Ticket = ticket;
	}
}
