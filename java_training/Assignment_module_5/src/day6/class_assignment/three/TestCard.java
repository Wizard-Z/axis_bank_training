package day6.class_assignment.three;

public class TestCard {
	public static void main(String[] args) {
		System.out.println("IN MAIN");
		int cardNo=12346;
		double availableBalance=100000.99;//inr
		double swipeLimit = 6000;//inr
		
		TravelCard travelCard = new TravelCard(cardNo, availableBalance, swipeLimit);
		System.out.println("CARD DETAILS");
		System.out.println(travelCard);
		
		System.out.println("Swiping $50");
		travelCard.swipeCard(50);
		System.out.println(travelCard);
		System.out.println("Swiping $59");
		travelCard.swipeCard(59);
		System.out.println(travelCard);
		System.out.println("Swiping $61");
		travelCard.swipeCard(61);
		System.out.println(travelCard);
		System.out.println("Swiping $101");
		travelCard.swipeCard(101);
		System.out.println(travelCard);
	}

}
