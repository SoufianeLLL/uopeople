/**
 * a Text Analysis Tool
 * 
 * By Soufiane Loudaini
 * University of The People
 * 2024
 * 
 */
import java.util.*;

public class TextAnalysisTool {

	// Method to count total characters
	public static int getCharacterCount(String text) {
		return text.length();
	}

	// Method to count total words
	public static int getWordCount(String text) {
		String[] words = text.trim().split("\\s+"); // Split by spaces
		return words.length;
	}

	// Method to find the most common character
	public static char getMostCommonCharacter(String text) {
		Map<Character, Integer> charFrequency = new HashMap<>();
		text = text.toLowerCase();

		for (char c : text.toCharArray()) {
			if (Character.isLetterOrDigit(c)) { // Count only letters and digits
				charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
			}
		}

		char mostCommon = ' ';
		int maxFrequency = 0;

		for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
			if (entry.getValue() > maxFrequency) {
				mostCommon = entry.getKey();
				maxFrequency = entry.getValue();
			}
		}
		return mostCommon;
	}

	// Method to count character frequency
	public static int getCharacterFrequency(String text, char target) {
		text = text.toLowerCase();
		target = Character.toLowerCase(target);
		int count = 0;

		for (char c : text.toCharArray()) {
			if (c == target) {
				count++;
			}
		}
		return count;
	}

	// Method to count word frequency
	public static int getWordFrequency(String text, String word) {
		text = text.toLowerCase();
		word = word.toLowerCase();
		String[] words = text.trim().split("\\s+");
		int count = 0;

		for (String w : words) {
			if (w.equals(word)) {
				count++;
			}
		}
		return count;
	}

	// Method to count unique words
	public static int getUniqueWordCount(String text) {
		Set<String> uniqueWords = new HashSet<>();
		String[] words = text.trim().split("\\s+");

		for (String word : words) {
			uniqueWords.add(word.toLowerCase());
		}

		return uniqueWords.size();
	}


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			// User Input
			System.out.println("Please enter a paragraph or lengthy text:");
			String text = scanner.nextLine();

			// Character Count
			int charCount = getCharacterCount(text);
			System.out.println("\nTotal number of characters: " + charCount);

			// Word Count
			int wordCount = getWordCount(text);
			System.out.println("Total number of words: " + wordCount);

			// Most Common Character
			char mostCommonChar = getMostCommonCharacter(text);
			System.out.println("Most common character: " + mostCommonChar);

			// Character Frequency
			System.out.println("\nEnter a character to check its frequency:");
			char targetChar = scanner.next().charAt(0);
			int charFreq = getCharacterFrequency(text, targetChar);
			System.out.println("\nFrequency of character '" + targetChar + "': " + charFreq);

			// Word Frequency
			scanner.nextLine(); // Consume the newline
			System.out.println("\nEnter a word to check its frequency:");
			String targetWord = scanner.nextLine();
			int wordFreq = getWordFrequency(text, targetWord);
			System.out.println("\nFrequency of word \"" + targetWord + "\": " + wordFreq);

			// Unique Words
			int uniqueWordCount = getUniqueWordCount(text);
			System.out.println("\nNumber of unique words: " + uniqueWordCount);

		}
		catch (Exception e) {
			System.out.println("\nAn error occurred: " + e.getMessage());
		}
		finally {
			scanner.close();
		}
	}
}
