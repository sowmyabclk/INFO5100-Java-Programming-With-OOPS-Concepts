package AED.Assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Course {

	public static void main(String[] args) throws Exception {
	//	Course c1 = new Course(1);
	//	c1.setMaxCapacity(3);
	//	c1.registerStudent(10);
	//	c1.registerStudent(20);

	//	Course c2 = new Course(2);
	//	c2.setMaxCapacity(3);
	//.registerStudent(30);
	//	c2.registerStudent(40);
	//	c2.registerStudent(40);
//		c3.setMaxCapacity(3);
	//	c3.registerStudent(60);
	//	Course c4 = new Course(4);
		//c4.registerStudent(70);

		Course c1 = new Course(1);
		c1.setMaxCapacity(11);
		c1.registerStudent(1);
		c1.registerStudent(6);
		c1.registerStudent(2);
		c1.registerStudent(3);
		c1.registerStudent(2);
		c1.registerStudent(4);
		c1.registerStudent(5);
		c1.registerStudent(6);
		c1.registerStudent(9);
		Course c2 = new Course(1);
	//	c2.setMaxCapacity(8);
	//	c2.registerStudent(1);
		

	//	for(int i=0;i<val.length;i++) {
			// System.out.println(val[i]);
			// }
	// [] array2 = {};
	//	c1.groupsOfStudents(array2);
		
		// c1.setCourseId(1);
		// System.out.println(c1.getCourseId());
		// Course c2 = new Course(2);
		// Course c3 = new Course(3,12345789,4);
		// Course c4 = new Course(6,7);
		// c4.setCredits(-1);
		// System.out.println(c4.getCredits());
		// System.out.println(c4);
		// System.out.println(c3.getProfessorId());
		// c3.setProfessorId(123456789);
		// System.out.println("object "+c3);
		// c1.registerStudent(1);
		// c2.registerStudent(4);
		// c3.registerStudent(5);
		// int[] arr=c3.getStudentIds();
		// for(int i=0;i<arr.length;i++) {
		// System.out.println(arr[i]);
		// }
	}

	int courseId;
	String courseName;
	int maxCapacity;
	int professorId;
	int credits;
	int[] studentIds;

	Course(int courseId) {
	//	this.studentIds = new int[this.maxCapacity];
		if (courseId <= 0)
			throw new IllegalArgumentException("Not a right CourseId -> " + courseId);
		this.courseId = courseId;
	}

	Course(int courseId, int professorId) {
		this(courseId);
		int length = String.valueOf(professorId).length();
		if (length > 6)
			throw new IllegalArgumentException("professor id is greater than 6 digit " + professorId);
		this.professorId = professorId;
	}

	Course(int courseId, int professorId, int credits) {
		this(courseId, professorId);
		if (String.valueOf(credits).length() > 1 || credits <= 0)
			throw new IllegalArgumentException(
					"credit length is either greater than 1 or the value is greater than 0 -> " + courseId);
		this.credits = credits;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		if (courseId <= 0)
			throw new IllegalArgumentException("Not a right CourseId -> " + courseId);
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		if (courseName.length() < 10 || courseName.length() > 60)
			throw new IllegalArgumentException("Course name length is not in range " + courseName);
		this.courseName = courseName;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		if (maxCapacity < 10 || maxCapacity > 100)
			throw new IllegalArgumentException("maximum capacity is not in a range " + maxCapacity);
		this.maxCapacity = maxCapacity;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		int length = String.valueOf(professorId).length();
		if (length > 6)
			throw new IllegalArgumentException("professor id is greater than 6 digit " + professorId);
		this.professorId = professorId;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		if (String.valueOf(credits).length() > 1 || credits <= 0)
			throw new IllegalArgumentException(
					"credit length is either greater than 1 or the value is greater than 0 -> " + courseId);
		this.credits = credits;
	}

	public int[] getStudentIds() {
		return studentIds;
	}

	public void setStudentIds(int[] studentIds) {
		this.studentIds = studentIds;
	}
	int i;
	List<Integer> list = new ArrayList<Integer>();
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	public void registerStudent(int studentId) throws Exception {
		this.studentIds = new int[this.getMaxCapacity()];
		if(studentIds.length == 0)
			throw new Exception("set the maximum capacity");
		if(i<studentIds.length) {
	while(i<studentIds.length) {
				
						//map.put(studentId, 1);
		studentIds[i] = studentId;
		list.add(studentId);

		System.out.println(studentIds[i]);

						break;
						
	}
	i++;
	
		}
	
		else {
			System.out.println("reached the maximum capacity");
			System.out.println("removing the duplicates");

		for(int i=0;i<list.size();i++) {
			studentIds[i] = list.get(i);
		//	System.out.println(studentIds[i]);
		}
		int [] arr1 =removeDuplicates(studentIds);
		for(int i=0;i<arr1.length;i++) {
			System.out.println(arr1[i]);
		}
		}
	

	
	// for (Map.Entry keyElements : map.entrySet()) { 
      //   int key =(int) keyElements.getKey(); 
       //  studentIds[i] = key;
}
		
		
		
		
	//	for(int i=0;i<this.studentIds.length;i++) {
			
		//	studentIds[i]=studentId;
			
		//}
		//for(int j=0;j<studentIds.length;j++) {
		//System.out.println(studentIds[j]);
		//}
	

	@SuppressWarnings("rawtypes")
	public int[] removeDuplicates(int[] studentIds) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	//	if (studentIds.length < this.maxCapacity) {
			for (int i = 0; i < studentIds.length; i++) {
				if (!map.containsKey(studentIds[i])) {
					map.put(studentIds[i], 1);
				}
			}
			
		
      int [] output = new int[map.size()];
      int count=0;
    	  for (Map.Entry keyElements : map.entrySet()) { 
              int key =(int) keyElements.getKey(); 
           //   System.out.println("keys are "+key);
              output[count] = key;
              count++;
              
            
      }

	
	return output;
		//}
	//	else
			//return studentIds;
	}
	
	public int groupsOfStudents(int[] studentIds) {
	int count=0;
	if(studentIds.length ==0)
		return 0;
	for(int i=0;i<studentIds.length;i++) {
		for(int j=i+1;j<studentIds.length;j++) {
			int k = studentIds[i] + studentIds[j];
			if(k %2==0)
				count++;
			
		}
	}
System.out.println(count);
	return count;

	}

}
