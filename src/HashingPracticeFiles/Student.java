package HashingPracticeFiles;

import java.util.*;

public class Student {
	
	private String id;
	private boolean tuitionPaid;
	private String major;
	
	public Student(String id, boolean tuitionPaid, String major) {
		this.id = id;
		this.tuitionPaid = tuitionPaid;
		this.major = major;
	}
	public String getId() {
		return id;
	}
	public boolean isTuitionPaid() {
		return tuitionPaid;
	}
	public String getMajor() {
		return major;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, tuitionPaid, major);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student other = (Student) obj;
			return this.id.equals(other.id) &&
					this.tuitionPaid==other.tuitionPaid &&
					this.major.equals(other.major);
		} else {
			return false;
		}
	}	
	
	

}
