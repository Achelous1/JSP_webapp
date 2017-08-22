package chat.model;

public class ChatDTO {
	private int chat_no;
	private String my_log;
	private String oppo_log;
	private String send_date;
	public int getChat_no() {
		return chat_no;
	}
	public void setChat_no(int chat_no) {
		this.chat_no = chat_no;
	}
	public String getMy_log() {
		return my_log;
	}
	public void setMy_log(String my_log) {
		this.my_log = my_log;
	}
	public String getOppo_log() {
		return oppo_log;
	}
	public void setOppo_log(String oppo_log) {
		this.oppo_log = oppo_log;
	}
	public String getSend_date() {
		return send_date;
	}
	public void setSend_date(String send_date) {
		this.send_date = send_date;
	}
	
	
}
