import java.util.Scanner;

public class FindParticipantId {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter the number of participants");
		int n = scnr.nextInt();
		scnr.nextLine();
		System.out.println("Enter the IDs");
		String[] IDs = scnr.nextLine().split(" ");//taking space seperated input
		System.out.println("Enter ID to search");
		int sid = scnr.nextInt();
		scnr.close();
		
		int[] ids = new int[n];
		for(int i=0; i<n;i++)
			ids[i] = Integer.parseInt(IDs[i]);
		
		boolean flag = false;
		for(int id:ids) {
			if (sid==id)
				flag = true;
		}
		if (flag)
			System.out.printf("Participant with ID %d exists.",sid);
		else
			System.out.printf("Participant with ID %d does not exist.",sid);
		System.out.println("\nProgram terminated.");
		
	}

}
