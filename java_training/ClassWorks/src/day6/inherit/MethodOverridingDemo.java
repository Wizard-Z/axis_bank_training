package day6.inherit;
class Vehicle{
	private String model;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	public static void showDetails() {
		System.out.println("IN SUPER");
		//System.out.println("MODEL IS: "+model);
	}
}
class FourWheeler extends Vehicle{
	private String transmissionType;
	public FourWheeler() {
		
	}
	public FourWheeler(String transmissionType) {
		this.transmissionType = transmissionType;
	}

	public String getTransmissionType() {
		return transmissionType;
	}

	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}

	//@Override
	public static void showDetails() {
		//super.showDetails();
		System.out.println("IN fourW");
		//System.out.println("Transmission type: "+this.transmissionType);
	}
	
	
}
public class MethodOverridingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setModel("F101");
		fourWheeler.setTransmissionType("AUTOMATIC");
		//fourWheeler.showDetails();
		
		Vehicle v1 = new Vehicle();
		//v1.showDetails(); // to its method only..
		
		Vehicle v = new FourWheeler("Automatic");
		v.setModel("F2012");
		v.showDetails(); // it calls the overriden method..?
		}

}
