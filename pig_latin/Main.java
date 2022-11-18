import java.util.Scanner;
// import java.util.regex.Pattern;

public class Main {
  static String pigLatin(String sentence) {

    String sentence_lower = sentence;
//  String sentence_lower = (sentence.replaceAll("\\p{Punct}", "")).toLowerCase();

    for(int k = 0; k < sentence.length(); k++) {
      if (sentence_lower.charAt(0) == 'e' || sentence_lower.charAt(0) == 'a' || sentence_lower.charAt(0) == 'o' || sentence_lower.charAt(0) == 'i' || sentence_lower.charAt(0) == 'u') {
        if (sentence_lower.contains("[\\p{Punct}")) {
          return(sentence_lower.substring(1, sentence_lower.length() - 1) + sentence_lower.substring(0, 1) + "ay" + sentence_lower.substring(sentence_lower.length()-1, sentence_lower.length())).toLowerCase();
        }
        if (k == 0) {
          return (sentence_lower + "way");
        }
      }
      else if (sentence_lower.contains("[\\p{Punct}")) {
        return(sentence_lower.substring(1, sentence_lower.length() - 1) + sentence_lower.substring(0, 1) + "ay" + sentence_lower.substring(sentence_lower.length()-1, sentence_lower.length())).toLowerCase();
      }
      else {
        if (sentence_lower.charAt(1) == 'a' || sentence_lower.charAt(1) == 'e' || sentence_lower.charAt(1) == 'i' || sentence_lower.charAt(1) == 'o' || sentence_lower.charAt(1) == 'u') {
          return(sentence_lower.substring(1, sentence_lower.length()) + sentence_lower.substring(0, 1) + "ay").toLowerCase();
      }
        else {
          return (sentence_lower.substring(2, sentence_lower.length()) + sentence_lower.substring(0, 2) + "ay").toLowerCase();
        }
      }
      
    }

    return "";
  }

  public static void main(String[] args) {
    try (Scanner testcase = new Scanner(System.in)) {
      System.out.println("Enter the sentence you want to Piglatinafy:");
      String pigLatinator = testcase.nextLine();
      String[] parts = pigLatinator.split(" ");
      String piglatinated = "";

      for (String part : parts) {
        String pig_latinated = pigLatin(part);
        piglatinated += pig_latinated + " ";
      }
      System.out.println(piglatinated);
    }
    }
}