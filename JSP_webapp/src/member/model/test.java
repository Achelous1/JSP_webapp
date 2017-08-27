package member.model;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberDTO data = new MemberDTO();
		data.setMem_id("aaa");
		data.setMem_pw("aaa");
		data.setMem_name("aaa");
		data.setMem_gender("aaa");
		data.setBirthdate(null);
		data.setAge(28);
		data.setPhoneno(000);
		data.setEmail("aaa");
		data.setAddr("aaa");
		
		MemberDAO dao = new MemberDAO();
		dao.signUp(data);
	}

}
