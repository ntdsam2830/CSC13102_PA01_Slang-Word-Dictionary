package Main;

import Dictionary.Dictionary;
import Feature.Interface;

public class Main {
	public static void main(String[] args) {
		Dictionary slangDictionary = new Dictionary();
		slangDictionary.getData();
		slangDictionary.getHistory();
		new Interface(slangDictionary);
	}
}
