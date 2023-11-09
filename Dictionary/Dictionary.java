package Dictionary;

import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Dictionary {
	private static final TreeMap<String, List<String>> dictionary = new TreeMap<>();
	private static final List<String> historyList = new ArrayList<>();
	
	public TreeMap<String, List<String>> getDictionary(){
		return dictionary;
	}
	//Get Data
	public void getData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("Data/slang.txt"));
			String data;
			while ((data = br.readLine()) != null) {
				if (data.contains("`")) {
					String[] item = data.split("`");
					List<String> temp = new ArrayList<>(Arrays.asList(item[1].split("\\|")));
					temp.replaceAll(String::stripLeading);
					temp.replaceAll(String::stripTrailing);
					dictionary.put(item[0], temp);
				}
			}
			br.close();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}
	
	// Get History
	public void getHistory() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("Data/history.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				historyList.add(line);
			}
			br.close();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}
	
	// Clear Search History
	public void clearHistory() {
		historyList.clear();
	}
	
	// 1. Find Definition of Slang words
	public List<String> findBySlangWord(String word) {
		LocalDateTime current = LocalDateTime.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    	String formatted = current.format(formatter);
		for (int i = 0; i < historyList.size(); i++) {
			if (Objects.equals(historyList.get(i), word)) {
				word = word.toUpperCase();
				return dictionary.get(word);
			}
		}
		historyList.add(word + " " +formatted);
		word = word.toUpperCase();
		return dictionary.get(word);
	}
	
	public List<String> getDefinition(String word) {
		word = word.toUpperCase();
		return dictionary.get(word);
	}
	
	// 2. Find all Slang words which have same definition
	public List<String> findByDefinition(String word) {
		LocalDateTime current = LocalDateTime.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    	String formatted = current.format(formatter);
		for (int i = 0; i < historyList.size(); i++) {
			if (Objects.equals(historyList.get(i), word)) {
				List<String> slangList = new ArrayList<>();
				for (String s : dictionary.keySet()) {
					List<String> values = dictionary.get(s);
					for (String data : values) {
						if (data.contains(word)) {
							slangList.add(s);
							break;
						}
					}
				}
				return slangList;
			}
		}
		historyList.add(word + " " + formatted);
		List<String> slangList = new ArrayList<>();
		for (String s : dictionary.keySet()) {
			List<String> values = dictionary.get(s);
			for (String data : values) {
				if (data.contains(word)) {
					slangList.add(s);
					break;
				}
			}
		}
		return slangList;
	}
	
	// 3. Get search history
	public List<String> gethistoryList() {
		return historyList;
	}
	
	// 4. Add or overwrite or duplicate a slang
	public void addSlangWord(String slang, List<String> definitions, String option) {
		slang = slang.toUpperCase();
		if (Objects.equals(option, "overwrite")) {
			dictionary.put(slang, definitions);
		} else if (Objects.equals(option, "duplicate")) {
			List<String> data = new ArrayList<>(dictionary.get(slang));
			for (String s : definitions) {
				if (!data.contains(s)) {
					data.add(s);
				}
			}
			dictionary.put(slang, data);
		} else {
			dictionary.put(slang, definitions);
		}
	}
	
	// 5. Edit a slang
	public void editSlang(String slang, String definition, String newDefinition, String option) {
		slang = slang.toUpperCase();
		if (Objects.equals(option, "replace")) {
			if (dictionary.get(slang) == null) {
				return;
			} else {
				List<String> data = dictionary.get(slang);
				dictionary.remove(slang);
				for (int i = 0; i < data.size(); i++) {
					if (Objects.equals(data.get(i), definition)) {
						data.add(newDefinition);
						data.remove(i);
						break;
					}
				}
				dictionary.put(slang, data);
			}
		} else if (Objects.equals(option, "delete")) {
			if (dictionary.get(slang) == null) {
				return;
			} else {
				List<String> data = dictionary.get(slang);
				dictionary.remove(slang);
				for (int i = 0; i < data.size(); i++) {
					if (Objects.equals(data.get(i), definition)) {
						data.remove(i);
						break;
					}
				}
				dictionary.put(slang, data);
			}
		} else {
			if (dictionary.get(slang) == null) {
				return;
			} else {
				List<String> data = dictionary.get(slang);
				dictionary.remove(slang);
				for (int i = 0; i < data.size(); i++) {
					if (Objects.equals(data.get(i), newDefinition)) {
						return;
					}
				}
				data.add(newDefinition);
				dictionary.put(slang, data);
			}
		}
	}
	
	// 6. Delete a slang
	public boolean deleteSlang(String slang) {
		if (dictionary.containsKey(slang)) {
			dictionary.remove(slang);
			return true;
		} else {
			return false;
		}
	}
	
	// 7. Reset a dictionary
	public void resetDictionary() {
		dictionary.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Data/original.txt"));
			String data;
			while ((data = br.readLine()) != null) {
				if (data.contains("`")) {
					String[] item = data.split("`");
					List<String> temp = new ArrayList<>(Arrays.asList(item[1].split("\\|")));
					temp.replaceAll(String::stripLeading);
					temp.replaceAll(String::stripTrailing);
					dictionary.put(item[0], temp);
				}
			}
			br.close();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}
	
	// LocalTime time1 = LocalTime.now();
	// LocalTime time2 = LocalTime.of(24, 0, 0);
	// if (time1.isAfter(time2)) {
		
	// }
	// 8. Random a slang in dictionary
	public String randomSlang() {
		Random rd = new Random();
		int randomNumber = rd.nextInt(dictionary.size());
		int i = 0;
		String a = null;
		for (String s : dictionary.keySet()) {
			if (i == randomNumber) {
				a = s + ": " + dictionary.get(s).toString();
			}
			i++;
		}
		return a;
	}
	
	public String randomWord() {
		Random rd = new Random();
		int randomNumber = rd.nextInt(dictionary.size());
		int i = 0;
		String a = null;
		for (String s : dictionary.keySet()) {
			if (i == randomNumber) {
				a = s;
			}
			i++;
		}
		return a;
	}
	
	// 9. "Choose a correct definition of the slang" Game
	public String slangGameA() {
		Random random = new Random();
		String data;
		String word1 = randomWord();
		data = word1 + "`";
		List<String> def1 = dictionary.get(word1);
		word1 = def1.get(random.nextInt(def1.size()));
		data += word1 + "`";
		data += word1 + "|";
		
		String word2 = randomWord();
		List<String> def2 = dictionary.get(word2);
		word2 = def2.get(random.nextInt(def2.size()));
		data += word2 + "|";
		
		String word3 = randomWord();
		List<String> def3 = dictionary.get(word3);
		word3 = def3.get(random.nextInt(def3.size()));
		data += word3 + "|";
		
		String word4 = randomWord();
		List<String> def4 = dictionary.get(word4);
		word4 = def4.get(random.nextInt(def4.size()));
		data += word4;
		return data;
	}
	
	// 10. "Choose a correct slang of the definition" Game
	public String slangGameB() {
		String data;
		Random random = new Random();
		String word1 = randomWord();
		List<String> def = dictionary.get(word1);
		data = def.get(random.nextInt(def.size())) + "`";
		data += word1 + "`";
		data += word1 + "|";
		
		String word2 = randomWord();
		data += word2 + "|";
		
		String word3 = randomWord();
		data += word3 + "|";
		
		String word4 = randomWord();
		data += word4;
		return data;
	}
	
	// Update Data
	public void updateData() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/Data/slang.txt"));
			for (String s : dictionary.keySet()) {
				bw.write(s + "`");
				List<String> temp = dictionary.get(s);
				for (int i = 0; i < temp.size(); i++) {
					bw.write(temp.get(i));
					if (i + 1 < temp.size()) {
						bw.write("|");
					}
				}
				bw.write("\n");
			}
			bw.close();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}
	
	// Update History
	public void updateHistory() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/Data/history.txt"));
			for (String temp : historyList) {
				bw.write(temp + "\n");
			}
			bw.close();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}
}