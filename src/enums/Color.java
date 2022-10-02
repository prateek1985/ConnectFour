package enums;

public enum Color {

	RED('R'),
	GREEN('G');
	
	private char label;
	
	private Color(char label) {
		this.label = label;
	}
	
	public char getLabel() {
		return this.label;
	}
}
