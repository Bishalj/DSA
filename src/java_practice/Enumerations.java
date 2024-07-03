package java_practice;

enum Resources{
	CPU("cpu"),
	MEMORY("memory"),
	CORES("cores");

	private String text;
	Resources(String text){
		this.text = text;
	}
	public static Resources getByName(String name){
		return Resources.valueOf(name);
	}

	public String getText() {
		return text;
	}
}

public class Enumerations {
	public static void main(String[] args) {
		Resources.CORES.getText();
	}
}
