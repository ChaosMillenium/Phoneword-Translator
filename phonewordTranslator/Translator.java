package phonewordTranslator;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Translator {

	private Map<Character, String> textToPhoneMap;
	private Map<String, Character> phoneToTextMap;

	public Translator() {
		textToPhoneMap = new HashMap<>(55);
		textToPhoneMap.put('A', "2");
		textToPhoneMap.put('B', "22");
		textToPhoneMap.put('C', "222");
		textToPhoneMap.put('D', "3");
		textToPhoneMap.put('E', "33");
		textToPhoneMap.put('F', "333");
		textToPhoneMap.put('G', "4");
		textToPhoneMap.put('H', "44");
		textToPhoneMap.put('I', "444");
		textToPhoneMap.put('J', "5");
		textToPhoneMap.put('K', "55");
		textToPhoneMap.put('L', "555");
		textToPhoneMap.put('M', "6");
		textToPhoneMap.put('N', "66");
		textToPhoneMap.put('O', "666");
		textToPhoneMap.put('Ñ', "6666");
		textToPhoneMap.put('P', "7");
		textToPhoneMap.put('Q', "77");
		textToPhoneMap.put('R', "777");
		textToPhoneMap.put('S', "7777");
		textToPhoneMap.put('T', "8");
		textToPhoneMap.put('U', "88");
		textToPhoneMap.put('V', "888");
		textToPhoneMap.put('W', "9");
		textToPhoneMap.put('X', "99");
		textToPhoneMap.put('Y', "999");
		textToPhoneMap.put('Z', "9999");
		textToPhoneMap.put(' ', "0");
		inverseMap();
		textToPhoneMap.put('a', "2");
		textToPhoneMap.put('b', "22");
		textToPhoneMap.put('c', "222");
		textToPhoneMap.put('d', "3");
		textToPhoneMap.put('e', "33");
		textToPhoneMap.put('f', "333");
		textToPhoneMap.put('g', "4");
		textToPhoneMap.put('h', "44");
		textToPhoneMap.put('i', "444");
		textToPhoneMap.put('j', "5");
		textToPhoneMap.put('k', "55");
		textToPhoneMap.put('l', "555");
		textToPhoneMap.put('m', "6");
		textToPhoneMap.put('n', "66");
		textToPhoneMap.put('o', "666");
		textToPhoneMap.put('ñ', "6666");
		textToPhoneMap.put('p', "7");
		textToPhoneMap.put('q', "77");
		textToPhoneMap.put('r', "777");
		textToPhoneMap.put('s', "7777");
		textToPhoneMap.put('t', "8");
		textToPhoneMap.put('u', "88");
		textToPhoneMap.put('v', "888");
		textToPhoneMap.put('w', "9");
		textToPhoneMap.put('x', "99");
		textToPhoneMap.put('y', "999");
		textToPhoneMap.put('z', "9999");
	}

	private void inverseMap() {
		phoneToTextMap = textToPhoneMap.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
	}

	public String translateTextToPhone(String toTranslate) {
		StringBuilder sb = new StringBuilder();
		for (Character ch : toTranslate.toCharArray()) {
			if (ch.equals('\n'))
				sb.append('\n');
			else if (textToPhoneMap.containsKey(ch)) {
				sb.append(textToPhoneMap.get(ch));
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	public String translatePhoneToText(String toTranslate) {
		StringBuilder tt = new StringBuilder(toTranslate);
		tt.append(' ');
		StringBuilder sb = new StringBuilder();
		StringBuilder phoneword = new StringBuilder();
		boolean lastIsBlank = false;
		for (Character ch : tt.toString().toCharArray()) {
			if (ch.equals('\n')) {
				if (phoneToTextMap.containsKey(phoneword.toString()))
					sb.append(phoneToTextMap.get(phoneword.toString()));
				sb.append('\n');
				phoneword.setLength(0);
				lastIsBlank = true;
			}
			else if (ch.equals(' ') && !lastIsBlank) {
				if (phoneToTextMap.containsKey(phoneword.toString()))
					sb.append(phoneToTextMap.get(phoneword.toString()));
				phoneword.setLength(0);
				lastIsBlank = true;
			} else {
				phoneword.append(ch);
				lastIsBlank = false;
			}
		}
		return sb.toString();
	}
}
