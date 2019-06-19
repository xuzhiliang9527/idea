package Enum;

public enum Enum {
	MON("星期一"),THR("星期二"),WEN("星期三"),THU("星期四"),FRI("星期五"),SAT("星期六"),SUN("星期日");
	String name = null;
	Enum(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static void main(String[] args) {
		Enum[] weeks= Enum.values();
		for(Enum week:weeks) {
			//获取枚举名
			System.out.print(week.name());
			System.out.print("---");
			//获取顺序
			System.out.print(week.ordinal());
			System.out.print("---");
			//返回序号差
			System.out.println(week.compareTo(Enum.SUN));
		}
	}
}
