package cn.edu.lingnan.test;

import java.util.Vector;

import cn.edu.lingnan.dao.UserDao;
import cn.edu.lingnan.dto.UserDto;

public class JDBCTest {
	public static void main(String[] args) {
		Vector<UserDto> v=new Vector<UserDto>();
		UserDao s=new UserDao();
		//findAllTest
//		
		v=s.findAllStudentInfo();
//		System.out.println("ԭʼ����Ϊ��");
//		for(StudentDto sd:v) 
//		System.out.println(sd.getSid()+" "+sd.getSname()+" "+sd.getPassword()+" "+sd.getSuperuser());
//		System.out.println();
		
		//findTest
//		StudentDto std1=s.findStudentById("s01");
//		StudentDto std2=s.findStudentById("s02");
//		if(std1 == null && std2==null)
//		{
//			System.out.println("����ʧ��");
//		}else
//		{
//		System.out.println("���ҳɹ������ҵ�����Ϊ��");
//		System.out.println();
//		System.out.println(std1.getSid()+" "+std1.getSname()+" "+std1.getPassword()+" "+std1.getSuperuser()+" ");
//		System.out.println(std2.getSid()+" "+std2.getSname()+" "+std2.getPassword()+" "+std2.getSuperuser()+" ");
//		System.out.println();
//		}
		
		//findStudentByElseTest
		System.out.println("���ҳɹ�,���ҽ��Ϊ��"+s.findStudentByElse("s03","ccc","ccc",1));
		System.out.println("--------------------------------");
		System.out.println("���ҳɹ�,���ҽ��Ϊ��"+s.findStudentByNameAndPassword("ccc","ccc"));
		
//		//inserTest
//		boolean insertflag=false;
//		insertflag=s.insertStudentById("s04","yt","zhaoqing",2);
//		insertflag=s.insertStudentById("s05", "mc", "123", 1);
//		insertflag=s.insertStudentById("s06", "cmc", "321", 2);
//		insertflag=s.insertStudentById("s07", "yy", "124", 3);
//		if(insertflag) {
//			System.out.println("����ɹ�,���������ݣ�");
//			v=s.findAllStudentInfo();
//			System.out.println();
//			for(StudentDto sd:v) 
//				System.out.println(sd.getSid()+" "+sd.getSname()+" "+sd.getPassword()+" "+sd.getSuperuser());		
//		}
//		else 
//			System.out.println("����ʧ��");
//		System.out.println();
//		
//		//deleteTest
//		boolean deleteflag=false;
//		deleteflag =s.deleteStudentById("s03");
//		deleteflag =s.deleteStudentById("s04");
//		deleteflag =s.deleteStudentById("s05");
//		if(deleteflag) {
//			System.out.println("ɾ���ɹ�,ɾ��������ݣ�");
//			v=s.findAllStudentInfo();
//			System.out.println();
//			for(StudentDto sd:v) 
//				System.out.println(sd.getSid()+" "+sd.getSname()+" "+sd.getPassword()+" "+sd.getSuperuser());		
//		}
//		else 
//			System.out.println("ɾ��ʧ��");
//		System.out.println();
//		
//		
//		//updateTest
//		boolean updateflag=false;
//		updateflag=s.updateStudentById("s01","Mr","zhanjian",2);
//		updateflag=s.updateStudentById("s02","ry","zhaoqing",2);
//		updateflag=s.updateStudentById("s06","ct","yunfu",2);
//		if(updateflag) {
//			System.out.println("���³ɹ�,���º�����ݣ�");
//			v=s.findAllStudentInfo();
//			System.out.println();
//			for(StudentDto sd:v) 
//				System.out.println(sd.getSid()+" "+sd.getSname()+" "+sd.getPassword()+" "+sd.getSuperuser());		
//		}
//		else 
//			System.out.println("����ʧ��");	
	}
}
