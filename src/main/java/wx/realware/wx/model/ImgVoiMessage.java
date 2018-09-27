package wx.realware.wx.model;

/**
 * 基础多媒体信息类    图片 跟 语音
 * @author joe
 *
 */
public class ImgVoiMessage extends Message {

	private String MediaId;//通过素材管理中的接口上传多媒体文件，得到的id。

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
