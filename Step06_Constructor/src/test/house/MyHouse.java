package test.house;

public class MyHouse {
	public Aircon air=null;
	public Television tv=null;
	public MicroWave mw=null;
	
	//디폴트 생성자 
	public MyHouse() {
		
	}
	//인자로 Aircon, Television, Microwave 객체를 전달 받는 생성자
	public MyHouse(Aircon air, Television tv, MicroWave mw) {
		this.air=air;
		this.tv=tv;
		this.mw=mw;
	}
}









