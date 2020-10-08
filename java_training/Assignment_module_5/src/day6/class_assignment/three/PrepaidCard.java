package day6.class_assignment.three;

public abstract class PrepaidCard {
	int CardNo;
	double availableBalance;
	double swipeLimit;
	public abstract boolean swipeCard(int amount);
	public void rechargeCard(int amount) {
		availableBalance += amount;
	}
	public PrepaidCard(int cardNo, double availableBalance, double swipeLimit) {
		CardNo = cardNo;
		this.availableBalance = availableBalance;
		this.swipeLimit = swipeLimit;
	}


}
