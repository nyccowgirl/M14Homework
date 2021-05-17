package HashingPracticeFiles;

import java.time.*;
import java.util.*;

public class M14PracticeExamples {
	
	public static void main(String[] args) {
		int fibNum = 50; 

		System.out.println("Traditional recursive solution");
		Instant start = Instant.now();
		System.out.println("\tAnswer = " + fibonacciRecusive(fibNum));
		Instant end = Instant.now();
		System.out.println("\tTime = " + Duration.between(start, end).toMillis() + " milliseconds.");
		System.out.println("\tRecursive Calls = " + recursiveMethodCounter);

		System.out.println("Recursive solution with a hash map");
		start = Instant.now();
		System.out.println("\tAnswer = " + fibonacciRecursiveWithMap(fibNum));
		end = Instant.now();
		System.out.println("\tTime = " + Duration.between(start, end).toMillis() + " milliseconds.");
		System.out.println("\tRecursive Calls = " + recursiveMethodMapCounter);


	}

	public static List<Student> findUnpaidStudents(HashMap<String, Student> map) {
		List<Student> unpaidList = new ArrayList<Student>();
		
		Iterator<Student> studentIterator = map.values().iterator();
		while(studentIterator.hasNext()) {
			Student student = studentIterator.next();
			if(!student.isTuitionPaid()) {
				unpaidList.add(student);
			}
		}
		
		return unpaidList;
	}
	
	public static void addToMajorMap(HashMap<String, List<Student>> map, String major, Student student) {
		List<Student> studentsWithMajorList = map.get(major);
		
		if(studentsWithMajorList==null) { // there is no list for this major
			studentsWithMajorList = new ArrayList<Student>();
			studentsWithMajorList.add(student);
			map.put(major, studentsWithMajorList);
		} else { // there is a list for this major
			
			// if the student isn't on that list, add the student
			if(!studentsWithMajorList.contains(student)) {
				studentsWithMajorList.add(student);
			}
		}
	}
	

	private static int recursiveMethodMapCounter = 0;
	
	public static long fibonacciRecursiveWithMap(int n) {
		recursiveMethodMapCounter = 0;
		HashMap<Integer, Long> valueMap = new HashMap<>();
		return fibonacciHelper(valueMap, n);
	}
	private static long fibonacciHelper(HashMap<Integer, Long> valueMap, int n) {
		recursiveMethodMapCounter++;
		if(n < 2) {
			return n;
		} else {
			Long storedValue = valueMap.get(n);
			if(storedValue==null) {
				long newlyCalculatedValue = fibonacciHelper(valueMap, n-1) + fibonacciHelper(valueMap, n-2);
				valueMap.put(n, newlyCalculatedValue);
				return newlyCalculatedValue;
			} else {
				return storedValue;
			}
		}
	}

	private static int recursiveMethodCounter = 0;
	
	public static long fibonacciRecusive(int n) {
		recursiveMethodCounter++;
		if (n < 2) {
			return n;
		} else {
			return fibonacciRecusive(n-1) + fibonacciRecusive(n-2);
		}
	}
}
