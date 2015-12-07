package com.hanains.guestbook.dao.test;

import java.util.List;

import com.hanains.guestbook.dao.GuestBookDao;
import com.hanains.guestbook.vo.GuestBookVo;

public class GuestBookDaoTest {

	static GuestBookDao dao =null;
	static GuestBookVo vo = null;
	
	public static void main(String[] args) {
		insertTest();
		System.out.println("-------insert after-------");
		getList();
		deleteTest();
		System.out.println("-------delete after-------");
		
		getList();
	}

	static void getList(){
		dao = new GuestBookDao();
		List<GuestBookVo> list =dao.getlist();
		for(GuestBookVo vo : list){
			System.out.println(vo);
		}
	}

	static void insertTest(){
		dao = new GuestBookDao();
		vo = new GuestBookVo();

		vo.setNo(100);
		vo.setName("나니1?");
		vo.setPassword("1234");
		vo.setMessage("나니꼬래1");
		vo.setReg_date("222222222222221");

		dao.insert(vo);
	}

	static void deleteTest(){
		dao = new GuestBookDao();
		vo.setNo(22);
		vo.setPassword("1234");
		dao.delete(vo);
	}
}
