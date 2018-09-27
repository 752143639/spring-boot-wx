package wx.realware.wx.model;


/**
 * 多媒体视频信息类
 * @author joe
 *
 */
public class VideoMessage extends ImgVoiMessage {

	private String Title;//视频消息的标题   非必输
	private String Description;//视频消息的描述 非必输
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
}
