package c04ex07;

public enum Colors {
BLACK("Black"), RED("Red"), BLUE("Blue"), GREEN("Green"), CYAN("Cyan"), MAGENTA("Magenta"), YELLOW("Yellow"), WHITE("White");
	
	private String colorName;
	
	private Colors(String colorNmae) {
		this.colorName = colorNmae;
	}

	public String getColorName() {
		return colorName;
	}
	
	public String getRed() {
		return RED.toString().toLowerCase();
	}
	
	public String getGreen() {
		return GREEN.toString().toLowerCase();
	}
}
