package day6.class_assignment.three;

public class TravelCard extends PrepaidCard implements Rewardable {
	private int rewardPoints;

	public TravelCard(int cardNo, double availableBalance, double swipeLimit) {
		super(cardNo, availableBalance, swipeLimit);
		this.rewardPoints = 0;
	}

	@Override
	public boolean swipeCard(int amount) {
		// TODO Auto-generated method stub
		double swipeAmount = (amount*60)+(0.05*amount);
		if(swipeAmount<=this.swipeLimit && swipeAmount<this.availableBalance) {
			this.availableBalance -= (amount*60)*0.05;
			System.out.println("Amount deducted: "+swipeAmount);
			System.out.println("Remaining Balance: "+this.availableBalance);
			getRewardPoints(swipeAmount);
			return true;
		}
		else {
			System.out.println("Insufficient Funds");
			return false;
		}
		
	}

	@Override
	public String toString() {
		return ":: TravelCard ::\nrewardPoints=" + rewardPoints + "\nCardNo=" + CardNo + "\navailableBalance="
				+ availableBalance + "\nswipeLimit=" + swipeLimit+"\n" ;
	}

	@Override
	public void getRewardPoints(double amount) {
		// TODO Auto-generated method stub
		this.rewardPoints += (amount/100)*5;
	}

}
