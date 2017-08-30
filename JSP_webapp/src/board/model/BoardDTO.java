package board.model;

import java.sql.Date;

public class BoardDTO {
	private int board_no;
	private String mem_no;
	//private String cont_type;
	private String title;
	private String contents;
	private String img;
	private Date post_date;
	private int ref;
	private int step;
	private int lev;
	private int read_cnt;
	private int child_cnt;
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getMem_no() {
		return mem_no;
	}
	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}
	/*public String getCont_type() {
		return cont_type;
	}
	public void setCont_type(String cont_type) {
		this.cont_type = cont_type;
	}*/
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	public int getRead_cnt() {
		return read_cnt;
	}
	public void setRead_cnt(int read_cnt) {
		this.read_cnt = read_cnt;
	}
	public int getChild_cnt() {
		return child_cnt;
	}
	public void setChild_cnt(int child_cnt) {
		this.child_cnt = child_cnt;
	}

	
}
