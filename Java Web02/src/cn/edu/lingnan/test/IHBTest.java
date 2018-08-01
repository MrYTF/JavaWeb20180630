package cn.edu.lingnan.test;

import java.util.Scanner;
import java.util.Vector;
import cn.edu.lingnan.dto.CourseDto;
import cn.edu.lingnan.dto.CostomerDto;
import cn.edu.lingnan.dto.TeacherDto;
import cn.edu.lingnan.dao.IHBDao;

public class IHBTest {

	public static void main(String[] args) {
		Vector<CourseDto> v=new Vector<CourseDto>();
		Vector<CostomerDto> v1=new Vector<CostomerDto>();
		Vector<TeacherDto> v2=new Vector<TeacherDto>();
		IHBDao s=new IHBDao();
		CourseDto std=null;
		CostomerDto cd=null;
		TeacherDto td=null;
		Scanner put = new Scanner(System.in);
		int choose = -1;
		while(choose != 0)
		{
			System.out.println("	1.总览信息");
			System.out.println("	2.查询信息");
			System.out.println("	3.插入信息");
			System.out.println("	4.删除信息");
			System.out.println("	5.更新信息");
			System.out.println("	0.退出");
			System.out.print("请选择：");
			choose = put.nextInt();
			put.nextLine();//接收put.nextInt()输入的回车，避免影响下面的输入
			switch(choose)
			{
				//退出功能，输入0时，直接跳出循环
				case 0:
						System.out.println("系统已成功退出！");
						break;
				//查询学生信息
				case 1:
					int select = -1;
					while(select != 0)
					{
						System.out.println("	1.总览客户表");
						System.out.println("	2.总览课程表");
						System.out.println("	3.总览教师表");
						System.out.println("	0.返回上一层");
						System.out.print("请选择：");
						select = put.nextInt();
						put.nextLine();
						switch(select)
						{
							case 0:
								break;
									
							case 1:
	
								v1=s.findCostomer();
								for(CostomerDto id:v1)
									System.out.println(id.getId()+" "+id.getName()+" "+id.getSex()+" "+id.getAge()+" "+id.getTelephone()+" "+id.getCourse()+" "+id.getRegister()+" "+id.getType());
									break;
									
							case 2:
								v=s.findCourse();
								for(CourseDto id:v)
									System.out.println(id.getCid()+" "+id.getCname()+" "+id.getTime()+" "+id.getSite()+" "+id.getPrice()+" "+id.getLecturer()+" "+id.getCtype());
								break;
							case 3:	
								v2=s.findTeacher();
								for(TeacherDto id:v2)
									System.out.println(id.getTid()+" "+id.getTname()+" "+id.getTsex()+" "+id.getTage()+" "+id.getCelphone());
								break;
							default:
								System.out.println("输入有错，请重新选择!!");
								break;
						}
					}
						break;
				case 2:	
					int select1 = -1;
					while(select1 != 0)
					{
						System.out.println("	1.查找客户表");
						System.out.println("	2.查找课程表");
						System.out.println("	3.查找教师表");
						System.out.println("	0.返回上一层");
						System.out.print("请选择：");
						select1 = put.nextInt();
						put.nextLine();
						switch(select1)
						{
							case 0:
								break;
									
							case 1:
								int aa = -1;						//一个方法，用来获取文件的信息，并把信息存进容器中
								while(aa != 0)
								{
									System.out.println("	1.按客户编号查询");
									System.out.println("	2.按客户姓名查询");
									System.out.println("	3.按客户所在班级查询");
									System.out.println("	4.按客户类型查询");
									System.out.println("	0.返回上一层");
									System.out.print("请选择：");
									aa = put.nextInt();
									put.nextLine();
									
									switch(aa)
									{
										case 0:
											 	break;
											 	
										case 1:
												System.out.print("请输入所要查询客户的编号：");
												String id = put.nextLine();
												cd=s.findById(id);
												if(cd == null)
												{
													System.out.println("查找失败，没有此编号的客户");
												}else
												{
												System.out.println("查找成功，查找的客户的信息为：");
												System.out.println();
												System.out.println(cd.getId()+" "+cd.getName()+" "+cd.getSex()+" "+cd.getAge()+" "+cd.getTelephone()+" "+cd.getCourse()+" "+cd.getRegister()+" "+cd.getType());
												System.out.println();
												}
												break;
												
										case 2: 
												System.out.print("请输入所要查询客户的姓名：");
												String name = put.nextLine();
												cd=s.findByName(name);
												if(cd == null)
												{
													System.out.println("查找失败，没有此姓名的客户");
												}else
												{
												System.out.println("查找成功，查找的客户的信息为：");
												System.out.println();
												System.out.println(cd.getId()+" "+cd.getName()+" "+cd.getSex()+" "+cd.getAge()+" "+cd.getTelephone()+" "+cd.getCourse()+" "+cd.getRegister()+" "+cd.getType());
												System.out.println();
												}
												break;
												
										case 3:
												System.out.print("请输入所要查询班级的编号：");
												String course = put.nextLine();
												v1=s.findByCourse(course);
												if(v1.isEmpty())
												{
													System.out.println("查找失败，没有此班级的客户");
												}else
												{
												System.out.println("查找成功，查找的数据为：");
												System.out.println();
												for(CostomerDto c : v1) {
													System.out.println(c);
												}
												
												System.out.println();
												}
												break;
											
										case 4:
											System.out.print("请输入所要查询的客户类型：");
											String type = put.nextLine();
											v1=s.findByType(type);
											if(v1.isEmpty())
											{
												System.out.println("查找失败，没有此类型的客户");
											}else
											{
											System.out.println("查找成功，查找的客户的信息为：");
											System.out.println();
											for(CostomerDto c: v1) {
												System.out.println(c);
											}
											System.out.println();
											}
											break;
										default:
												System.out.println("输入错误，请重新输入正确查询方式!!");
												System.out.println("\n");
												break;
												
									}
								}
								break;
							case 2:
									int bb = -1;						//一个方法，用来获取文件的信息，并把信息存进容器中
									while(bb != 0)
									{
										System.out.println("	1.按课程编号查询");
										System.out.println("	2.按课程名称查询");
										System.out.println("	3.按授课老师查询");
										System.out.println("	4.按课程类型查询");
										System.out.println("	0.返回上一层");
										System.out.print("请选择：");
										bb = put.nextInt();
										put.nextLine();
										
										switch(bb)
										{
											case 0:
												 	break;
												 	
											case 1:
													System.out.print("请输入所要查询的课程编号：");
													String cid = put.nextLine();
													std=s.findByCid(cid);
													if(std == null)
													{
														System.out.println("查找失败，没有此编号的课程");
													}else
													{
													System.out.println("查找成功，查找的课程信息为：");
													System.out.println();
													System.out.println(std.getCid()+" "+std.getCname()+" "+std.getTime()+" "+std.getSite()+" "+std.getPrice()+" "+std.getLecturer()+" "+std.getCtype());
													System.out.println();
													}
													break;
													
											case 2: 
													System.out.print("请输入所要查询的课程名称：");
													String cname = put.nextLine();
													std=s.findByCname(cname);
													if(std == null)
													{
														System.out.println("查找失败，没有此名称的课程");
													}else
													{
													System.out.println("查找成功，查找的课程信息为：");
													System.out.println();
													System.out.println(std.getCid()+" "+std.getCname()+" "+std.getTime()+" "+std.getSite()+" "+std.getPrice()+" "+std.getLecturer()+" "+std.getCtype());
													System.out.println();
													}
													break;
													
											case 3:
													System.out.print("请输入所要查询的授课老师姓名：");
													String lecturer = put.nextLine();
													std=s.findByLecturer(lecturer);
													if(std == null)
													{
														System.out.println("查找失败，没有此名称的课程");
													}else
													{
													System.out.println("查找成功，查找的课程信息为：");
													System.out.println();
													System.out.println(std.getCid()+" "+std.getCname()+" "+std.getTime()+" "+std.getSite()+" "+std.getPrice()+" "+std.getLecturer()+" "+std.getCtype());
													System.out.println();
													}
													break;
											case 4:
												System.out.print("请输入所要查询的课程类型：");
												String ctype = put.nextLine();
												std=s.findByCtype(ctype);
												if(std == null)
												{
													System.out.println("查找失败，没有此名称的课程");
												}else
												{
												System.out.println("查找成功，查找的课程信息为：");
												System.out.println();
												System.out.println(std.getCid()+" "+std.getCname()+" "+std.getTime()+" "+std.getSite()+" "+std.getPrice()+" "+std.getLecturer()+" "+std.getCtype());
												System.out.println();
												}
												break;
											default:
													System.out.println("输入错误，请重新输入正确查询方式!!");
													System.out.println("\n");
													break;
													
										}
									}
									break;
							case 3:
								int cc = -1;						//一个方法，用来获取文件的信息，并把信息存进容器中
								while(cc != 0)
								{
									System.out.println("	1.按教师编号查询");
									System.out.println("	2.按教师姓名查询");
									System.out.println("	0.返回上一层");
									System.out.print("请选择：");
									cc = put.nextInt();
									put.nextLine();
									
									switch(cc)
									{
										case 0:
											 	break;
											 	
										case 1:
												System.out.print("请输入所要查询的教师编号：");
												String tid = put.nextLine();
												td=s.findByTid(tid);
												if(std == null)
												{
													System.out.println("查找失败，没有此编号的教师");
												}else
												{
												System.out.println("查找成功，查找的教师信息为：");
												System.out.println();
												System.out.println(td.getTid()+" "+td.getTname()+" "+td.getTsex()+" "+td.getTage()+" "+td.getCelphone());
												System.out.println();
												}
												break;
												
										case 2: 
												System.out.print("请输入所要查询的教师姓名：");
												String tname = put.nextLine();
												td=s.findByTname(tname);
												if(std == null)
												{
													System.out.println("查找失败，没有此姓名的教师");
												}else
												{
												System.out.println("查找成功，查找的教师信息为：");
												System.out.println();
												System.out.println(td.getTid()+" "+td.getTname()+" "+td.getTsex()+" "+td.getTage()+" "+td.getCelphone());
												System.out.println();
												}
												break;
													
										default:
												System.out.println("输入错误，请重新输入正确查询方式!!");
												System.out.println("\n");
												break;
												
											}
										}
										break;	
									default:
										System.out.println("输入有错，请重新选择!!");
										break;
									}
								}
								break;
							
				case 3:
					int select2 = -1;
					while(select2 != 0)
					{
						System.out.println("	1.插入客户表");
						System.out.println("	2.插入课程表");
						System.out.println("	3.插入教师表");
						System.out.println("	0.返回上一层");
						System.out.print("请选择：");
						select2 = put.nextInt();
						put.nextLine();
						switch(select2)
						{
							case 0:
								break;
									
							case 1:
								String id=null,name=null,sex=null,telephone=null,course=null,register=null,type=null;
								int age=0;
										System.out.println("请输入所要插入客户的编号：");
										id=put.nextLine();
										
										System.out.println("请输入所要插入客户的姓名：");
										name=put.nextLine();
										
										System.out.println("请输入所要插入客户的性别：");
										sex=put.nextLine();
									
										System.out.println("请输入所要插入客户的年龄：");
										age=put.nextInt();
										put.nextLine();
										System.out.println("请输入所要插入客户的联系方式：");
										telephone=put.nextLine();
										
										System.out.println("请输入所要插入客户的选课记录：");
										course=put.nextLine();
										
										System.out.println("请输入所要插入客户的注册登录信息：");
										register=put.nextLine();
										
										System.out.println("请输入所要插入客户的类型：");
										type=put.nextLine();
										
										boolean insertflag2=false;
										insertflag2=s.insertCostomer(id, name, sex, age, telephone,course,register, type);
										if(insertflag2) {
											
											System.out.println("插入成功,插入后的数据：");
											v1=s.findCostomer();
											System.out.println();
											for(CostomerDto sd:v1) 
												System.out.println(sd.getId()+" "+sd.getName()+" "+sd.getSex()+" "+sd.getAge()+" "+sd.getTelephone()+" "+sd.getCourse()+" "+sd.getRegister()+" "+sd.getType());	
										}
										else 
											System.out.println("插入失败");
										System.out.println();
										break;
								
							case 2:
								String cid=null,cname=null,time=null,site=null,price=null,lecturer=null,ctype=null;
								
								
										System.out.println("请输入所要插入课程的编号：");
										cid=put.nextLine();
										
										System.out.println("请输入所要插入课程的名称：");
										cname=put.nextLine();
										
										System.out.println("请输入所要插入上课的时间：");
										time=put.nextLine();
										
										System.out.println("请输入所要插入上课的地点：");
										site=put.nextLine();
									
										System.out.println("请输入所要插入课程的价格：");
										price=put.nextLine();
										
										System.out.println("请输入所要插入课程的授课老师：");
										lecturer=put.nextLine();
										
										System.out.println("请输入所要插入课程的类型：");
										ctype=put.nextLine();
									
										boolean insertflag1 = false;
										insertflag1=s.insertCourse(cid, cname, time, site, price,lecturer,ctype);
										if(insertflag1) {
											System.out.println("插入成功,插入后的数据：");
											v=s.findCourse();
											System.out.println();
											for(CourseDto sd:v) 
												System.out.println(sd.getCid()+" "+sd.getCname()+" "+sd.getTime()+" "+sd.getSite()+" "+sd.getPrice()+" "+sd.getLecturer());
										}
										else 
											System.out.println("插入失败");
										System.out.println();
										break;
							case 3:
								String tid=null,tname=null,tsex=null,celphone=null;
								int tage=0;
										System.out.println("请输入所要插入教师的编号：");
										tid=put.nextLine();
										
										System.out.println("请输入所要插入教师的姓名：");
										tname=put.nextLine();
										
										System.out.println("请输入所要插入教师的性别：");
										tsex=put.nextLine();
									
										System.out.println("请输入所要插入教师的年龄：");
										tage=put.nextInt();
										put.nextLine();
										System.out.println("请输入所要插入教师的联系方式：");
										celphone=put.nextLine();
										
										boolean insertflag=false;
										insertflag=s.insertTeacher(tid, tname, tsex, tage, celphone);
										if(insertflag) {
											System.out.println("插入成功,插入后的数据：");
											v2=s.findTeacher();
											System.out.println();
											for(TeacherDto sd:v2) 
												System.out.println(sd.getTid()+" "+sd.getTname()+" "+sd.getTsex()+" "+sd.getTage()+" "+sd.getCelphone());
										}
										else 
											System.out.println("插入失败");
										System.out.println();
										break;
							default:
								System.out.println("输入错误，请重新输入!!");
								System.out.println("\n");
								break;
						}
					
					}
					break;
				case 4:
					int select3 = -1;
					while(select3 != 0)
					{
						System.out.println("	1.删除客户表");
						System.out.println("	2.删除课程表");
						System.out.println("	3.删除教师表");
						System.out.println("	0.返回上一层");
						System.out.print("请选择：");
						select3 = put.nextInt();
						put.nextLine();
						switch(select3)
						{
							case 0:
								break;
									
							case 1:
								int dd = -1;						//一个方法，用来获取文件的信息，并把信息存进容器中
								while(dd != 0)
								{
									System.out.println("	1.按客户编号删除");
									System.out.println("	2.按客户姓名删除");
									System.out.println("	0.返回上一层");
									System.out.print("请选择：");
									dd = put.nextInt();
									put.nextLine();
									
									switch(dd)
									{
										case 0:
											 	break;
											 	
										case 1:
												System.out.print("请输入要删除的客户编号：");
												String id = put.nextLine();
												boolean deleteflag=false;
												deleteflag =s.deleteCostomerById(id);
												if(deleteflag) {
													System.out.println("删除成功,删除后的数据：");
													v1=s.findCostomer();
													System.out.println();
													for(CostomerDto sd:v1) 
														System.out.println(sd.getId()+" "+sd.getName()+" "+sd.getSex()+" "+sd.getAge()+" "+sd.getTelephone()+" "+sd.getCourse()+" "+sd.getRegister()+" "+sd.getType());	
												}
												else 
													System.out.println("删除失败");
												System.out.println();
												break;
										case 2:
											System.out.print("请输入要删除的客户姓名：");
											String name = put.nextLine();
											boolean deleteflag1=false;
											deleteflag1 =s.deleteCostomerByName(name);
											if(deleteflag1) {
												System.out.println("删除成功,删除后的数据：");
												v1=s.findCostomer();
												System.out.println();
												for(CostomerDto sd:v1) 
													System.out.println(sd.getId()+" "+sd.getName()+" "+sd.getSex()+" "+sd.getAge()+" "+sd.getTelephone()+" "+sd.getCourse()+" "+sd.getRegister()+" "+sd.getType());	
											}
											else 
												System.out.println("删除失败");
											System.out.println();
											break;
									
									}
								}
								break;
							case 2:
								int ee = -1;						//一个方法，用来获取文件的信息，并把信息存进容器中
								while(ee != 0)
								{
									System.out.println("	1.按课程编号删除");
									System.out.println("	2.按课程名称删除");
									System.out.println("	0.返回上一层");
									System.out.print("请选择：");
									ee = put.nextInt();
									put.nextLine();
									
									switch(ee)
									{
										case 0:
											 	break;
											 	
										case 1:
												System.out.print("请输入要删除的课程编号：");
												String cid = put.nextLine();
												boolean deleteflag=false;
												deleteflag =s.deleteCourseById(cid);
												if(deleteflag) {
													System.out.println("删除成功,删除后的数据：");
													v=s.findCourse();
													System.out.println();
													for(CourseDto sd:v) 
														System.out.println(sd.getCid()+" "+sd.getCname()+" "+sd.getTime()+" "+sd.getSite()+" "+sd.getPrice()+" "+sd.getLecturer()+" "+sd.getCtype());
												}
												else 
													System.out.println("删除失败");
												System.out.println();
												break;
										case 2:
											System.out.print("请输入要删除的课程名称：");
											String cname = put.nextLine();
											boolean deleteflag1=false;
											deleteflag1 =s.deleteCourseByCname(cname);
											if(deleteflag1) {
												System.out.println("删除成功,删除后的数据：");
												v=s.findCourse();
												System.out.println();
												for(CourseDto sd:v) 
													System.out.println(sd.getCid()+" "+sd.getCname()+" "+sd.getTime()+" "+sd.getSite()+" "+sd.getPrice()+" "+sd.getLecturer()+" "+sd.getCtype());
											}
											else 
												System.out.println("删除失败");
											System.out.println();
											break;
									}
								}
								break;
							case 3:
								int ff = -1;						//一个方法，用来获取文件的信息，并把信息存进容器中
								while(ff != 0)
								{
									System.out.println("	1.按教师编号删除");
									System.out.println("	2.按教师姓名删除");
									System.out.println("	0.返回上一层");
									System.out.print("请选择：");
									ff = put.nextInt();
									put.nextLine();
									
									switch(ff)
									{
										case 0:
											 	break;
											 	
										case 1:
												System.out.print("请输入要删除的教师编号：");
												String tid = put.nextLine();
												boolean deleteflag=false;
												deleteflag =s.deleteTeacherById(tid);
												if(deleteflag) {
													System.out.println("删除成功,删除后的数据：");
													v2=s.findTeacher();
													System.out.println();
													for(TeacherDto sd:v2) 
														System.out.println(sd.getTid()+" "+sd.getTname()+" "+sd.getTsex()+" "+sd.getTage()+" "+sd.getCelphone());
												}
												else 
													System.out.println("删除失败");
												System.out.println();
												break;
										case 2:
											System.out.print("请输入要删除的教师姓名：");
											String tname = put.nextLine();
											boolean deleteflag1=false;
											deleteflag1 =s.deleteTeacherByName(tname);
											if(deleteflag1) {
												System.out.println("删除成功,删除后的数据：");
												v2=s.findTeacher();
												System.out.println();
												for(TeacherDto sd:v2) 
													System.out.println(sd.getTid()+" "+sd.getTname()+" "+sd.getTsex()+" "+sd.getTage()+" "+sd.getCelphone());
											}
											else 
												System.out.println("删除失败");
											System.out.println();
											break;
									}
								}
								break;
					
							}
						}
							break;
				case 5:
					int select4 = -1;
					while(select4 != 0)
					{
						System.out.println("	1.更新客户表");
						System.out.println("	2.更新课程表");
						System.out.println("	3.更新教师表");
						System.out.println("	0.返回上一层");
						System.out.print("请选择：");
						select4 = put.nextInt();
						put.nextLine();
						switch(select4)
						{
							case 0:
								break;
									
							case 1:
								System.out.print("请输入需要更新的客户编号：");
								String id = put.nextLine();
								System.out.print("请输入更新后客户的姓名：");
								String name = put.nextLine();
								System.out.print("请输入更新后客户的性别：");
								String sex = put.nextLine();
								System.out.print("请输入更新后客户的年龄：");
								int age = put.nextInt();
								System.out.print("请输入更新后客户的联系方式：");
								String telephone = put.nextLine();
								System.out.print("请输入更新后客户的选课记录：");
								String course = put.nextLine();
								System.out.print("请输入更新后客户的注册登记：");
								String record = put.nextLine();
								System.out.print("请输入更新后客户的类型：");
								String type = put.nextLine();
								boolean updateflag=false;
								updateflag=s.updateCostomerById(id,name,sex,age,telephone,course,record,type);
								if(updateflag) {
									System.out.println("更新成功,更新后的数据：");
									v1=s.findCostomer();
									System.out.println();
									for(CostomerDto sd:v1) 
										System.out.println(sd.getId()+" "+sd.getName()+" "+sd.getSex()+" "+sd.getAge()+" "+sd.getTelephone()+" "+sd.getCourse()+" "+sd.getRegister()+" "+sd.getType());	
								}
								else 
									System.out.println("更新失败");	
								break;
							case 2:
								System.out.print("请输入需要更新的课程编号：");
								String cid = put.nextLine();
								System.out.print("请输入更新后的课程名称：");
								String cname = put.nextLine();
								System.out.print("请输入更新后的课程上课时间：");
								String time = put.nextLine();
								System.out.print("请输入更新后的课程上课地点：");
								String site = put.nextLine();
								boolean updateflag1=false;
								updateflag1=s.updateCourseById(cid,cname,time,site);
								if(updateflag1) {
									System.out.println("更新成功,更新后的数据：");
									v=s.findCourse();
									System.out.println();
									for(CourseDto sd:v) 
										System.out.println(sd.getCid()+" "+sd.getCname()+" "+sd.getTime()+" "+sd.getSite()+" "+sd.getPrice()+" "+sd.getLecturer()+" "+sd.getCtype());
								}
								else 
									System.out.println("更新失败");	
								break;
							case 3:
								System.out.print("请输入需要更新的教师编号：");
								String tid = put.nextLine();
								System.out.print("请输入更新后的教师姓名：");
								String tname = put.nextLine();
								System.out.print("请输入更新后的教师性别：");
								String tsex = put.nextLine();
								System.out.print("请输入更新后的教师年龄：");
								String tage = put.nextLine();
								System.out.print("请输入更新后的教师的联系方式：");
								String celphone = put.nextLine();
								boolean updateflag2=false;
								updateflag2=s.updateTeacherById(tid,tname,tsex,tage,celphone);
								if(updateflag2) {
									System.out.println("更新成功,更新后的数据：");
									v2=s.findTeacher();
									System.out.println();
									for(TeacherDto sd:v2) 
										System.out.println(sd.getTid()+" "+sd.getTname()+" "+sd.getTsex()+" "+sd.getTage()+" "+sd.getCelphone());
								}
								else 
									System.out.println("更新失败");	
								break;
							}
						}
					break;
				default:
					System.out.println("输入错误，请重新输入!!");
					System.out.println("\n");
					break;
			}
		}
		put.close();
	}
}


				
	
