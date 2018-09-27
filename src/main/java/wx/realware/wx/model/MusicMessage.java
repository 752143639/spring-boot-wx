package wx.realware.wx.model;

public class MusicMessage extends Message {

	private String Title;			//音乐标题   非必输
	private String Description;		//音乐描述  非必输
	private String MusicURL;		//音乐链接  非必输
	private String HQMusicUrl;		//高质量音乐链接，WIFI环境优先使用该链接播放音乐  非必输 
	private String ThumbMediaId;    //缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id 必输
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
	public String getMusicURL() {
		return MusicURL;
	}
	public void setMusicURL(String musicURL) {
		MusicURL = musicURL;
	}
	public String getHQMusicUrl() {
		return HQMusicUrl;
	}
	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

}
