package in.ineuron.dao;

import in.ineuron.dto.Student;

public interface IStudentDao {

	// operations to be implemented
	public String addStudent(String sname, Integer sage, String saddress);
	public String addStudent2(Student student);

	public Student searchStudent(Integer sid);

	public String updateStudent(Integer sid, String sname, Integer sage, String saddress);

	public String updateStudent2(Student student);

	public String deleteStudent(Integer sid);

}
