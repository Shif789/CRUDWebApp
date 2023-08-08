package in.ineuron.service;

import in.ineuron.daofactory.StudentDaoFactory;

import in.ineuron.dto.Student;
import in.ineuron.dao.IStudentDao;

//service layer logic
public class StudentServiceImpl implements IStudentService {
	IStudentDao stdDao;

	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.addStudent(sname, sage, saddress);
	}

	@Override
	public String addStudent2(Student student) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.addStudent2(student);
	}
	
	@Override
	public Student searchStudent(Integer sid) {
		stdDao = StudentDaoFactory.getStudentDao();
		Student student = stdDao.searchStudent(sid);
		return student;
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		stdDao = StudentDaoFactory.getStudentDao();
		String message = stdDao.updateStudent(sid, sname, sage, saddress);
		return message;
	}

	@Override
	public String updateStudent2(Student student) {
		stdDao = StudentDaoFactory.getStudentDao();
		String message = stdDao.updateStudent2(student);
		return message;
	}

	@Override
	public String deleteStudent(Integer sid) {
		stdDao = StudentDaoFactory.getStudentDao();
		String message = stdDao.deleteStudent(sid);
		return message;
	}

	

}
