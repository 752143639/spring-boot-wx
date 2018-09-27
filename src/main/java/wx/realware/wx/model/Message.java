package wx.realware.wx.model;

/**
 * 信息实体类，对应普通文本信息
 * @author joe
 *
 */
public class Message {

	//以下均必输
	private String ToUserName;      //接收信息微信
	private String FromUserName;	//发送信息微信
	private long CreateTime;		//消息创建时间
	private String MsgType;			//类型 text/image/voice/video/music/news
	//event 
	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
}
