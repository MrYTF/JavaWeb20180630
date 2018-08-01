package cn.edu.lingnan.dao;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class IHBDaoTest {

	@Test
	public void testFindCostomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindCourse() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindTeacher() {
		IHBDao dao = new IHBDao();
		Vector vector = dao.findTeacher();

	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByCourse() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByType() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByCid() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByCname() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByLecturer() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByCtype() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByTid() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByTname() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertTeacher() {
		IHBDao dao = new IHBDao();
		dao.insertTeacher("t05", "qwe", "nan", 26, "1223456");

	}

	@Test
	public void testInsertCourse() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertCostomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteCostomerById() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteCostomerByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteCourseById() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteCourseByCname() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteTeacherById() {
		IHBDao dao = new IHBDao();
		dao.deleteTeacherById("t05");
	}

	@Test
	public void testDeleteTeacherByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateCostomerById() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateCourseById() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateTeacherById() {
		fail("Not yet implemented");
	}

	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testWait() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalize() {
		fail("Not yet implemented");
	}

}
