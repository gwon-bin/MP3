package Login;

import java.util.ArrayList;
import java.util.Scanner;

public class login {

	Scanner in = new Scanner(System.in);
	ArrayList<MemberDTO> members = new ArrayList<>();

	public login() {
		members.add(new MemberDTO("AA", "1234", "김"));
		members.add(new MemberDTO("BB", "1234", "이"));
		members.add(new MemberDTO("CC", "1234", "최"));
	}
	
	public void run() {

		int num = 0;
		while ((num = menu()) != 0) {
			switch (num) {
			case 1:
				Login();
				break;
			case 2:
				MemberJoin();
				break;
			case 3:
				SelectMember();
			}
		}
	}

	private void SelectMember() {
		for (MemberDTO A : members) {
			System.out.println(A);
		}
	}

	private void MemberJoin() {
		in.nextLine();
		String id = getStrInput("               ID : ");
		String pw = getStrInput("         PassWord : ");
		String pw2 = getStrInput("Password Confirm : ");
		String name = getStrInput("           Name : ");

		if (idCheck(id)) {
			System.out.println("중복된 ID입니다.");
		} else if (pw.equals(pw2)) {
			members.add(new MemberDTO(id, pw, name));
			System.out.println(id + "로 가입되었습니다");
		} else {
			System.out.println("비밀번호를 확인해주세요.");
		}

	}

	private boolean idCheck(String id) {
		boolean check = true;
		MemberDTO member = FindById(id);
		if (member == null)
			check = false;
		return check;
	}

	private void Login() {
		in.nextLine();
		String id = getStrInput("      ID : ");
		String pw = getStrInput("PassWord : ");

		MemberDTO member = FindById(id);
		if (member == null) {
			System.out.println("등록되지 않은 ID입니다.");
		} else if (member.getPW().equals(pw)) {
			System.out.println("[" + member.getID() + "]님께서 로그인 하셨습니다.");
		} else {
			System.out.println("비밀번호가 틀렸습니다.");
		}
	}

	private MemberDTO FindById(String id) {
		for (MemberDTO memberDTO : members) {
			if (memberDTO.getID().equals(id)) {
				return memberDTO;
			}
		}
		return null;
	}

	private String getStrInput(String msg) {
		System.out.println(msg);
		return in.nextLine();
	}

	private int menu() {
		return getNumInput("1.로그인 2.회원가입 3.전체 회원 보기  0.종료");
	}

	private int getNumInput(String msg) {
		System.out.println(msg);
		return in.nextInt();
	}

}