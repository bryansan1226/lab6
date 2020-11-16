package lab6;

import java.util.Scanner;


public class Lab6 {

	public static void main(String[] args) throws Exception{
		LinkedList practiceProblems= new LinkedList();
		LinkedList labs= new LinkedList();
		double midterm1, midterm2, finalExam;
		double totalScore;
		Scanner scanner= new Scanner(System.in);
		//loop to create a linked list of the scores received on the practice problem assignments
				for(int i=1;i<=8;i++) {
			System.out.println("What was your score for practice problems #"+i+"?: ");
			int score=scanner.nextInt();
			practiceProblems=practiceProblems.insert(practiceProblems, score);
		}
		//loop to create a linked listt of the scores received on the labs 
		for(int i=1;i<=7;i++) {
			System.out.println("What was your score for Lab#"+i+"?: ");
			labs=labs.insert(labs, scanner.nextInt());
		}
		//The program asks for the grades received on the 3 tests 
		System.out.println("What was your score on midterm 1?");
		midterm1=scanner.nextInt();
		System.out.println("What was your score on midterm 2?");
		midterm2=scanner.nextInt();
		System.out.println("What was your score on the final?");
		finalExam=scanner.nextInt();
		scanner.close();
		//a function is called on both linked lists to calculate their respective weighted scores
		double problemsScore=practiceProblems.getProblemsScore(practiceProblems);
		double labsScore=labs.getLabsScore(labs);
		totalScore=problemsScore+labsScore+midterm1+midterm2+finalExam;
		//the weighted scores are then added to the test scores to get a result out of 100, which is then passed to a function that converts it to a letter grade
		System.out.println("You have "+totalScore+" out of 100 possible points for a letter grade of "+ getLetterGrade(totalScore));

	}
	//This function will receive a double as an argument and will return a letter based on the range the argument falls in. 
	public static char getLetterGrade(double score) {
		if(score>=100&&score>=90) return 'A';
		else if(score<90&&score>=80) return 'B';
		else if(score<80&&score>=70) return 'C';
		else if(score<70&&score>=60) return 'D';
		else return 'F';
	}

}
//Standard linked list class definition
class LinkedList{
	Node head;
	static class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data=d;
			next=null;
		}
	}
	public static LinkedList insert(LinkedList list, int data) 
	{
		Node newNode= new Node(data);
		newNode.next=null;
		if (list.head==null)
			list.head=newNode;
		else
		{
			Node last=list.head;
			while (last.next!=null)
				last=last.next;
			last.next=newNode;
		}
		return list;
	}
	//getProblemsScore and getLabsScore visit every node in the list and adds it to a running total, then multiplies by a specific factor to get the weighted score
	public static double getProblemsScore(LinkedList list)
	{
		Node currNode=list.head;
		int total=0;
		double score;
		while (currNode !=null) 
		{
			total+=currNode.data;
			currNode=currNode.next;			
		}
		score=total/48;
		score*=44;
		return score;
	}
	public static double getLabsScore(LinkedList list) {
		Node currNode=list.head;
		int total=0;
		double score;
		while(currNode!=null) {
			total+=currNode.data;
			currNode=currNode.next;
		}
		score=total/14;
		score*=16;
		return score;
	}
}