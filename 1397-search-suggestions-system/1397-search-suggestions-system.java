import java.util.*;

public class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        
        // Sort the products lexicographically
        Arrays.sort(products);
        
        // Iterate through each character of searchWord
        StringBuilder prefix = new StringBuilder();
        for (char c : searchWord.toCharArray()) {
            prefix.append(c);
            List<String> suggestions = new ArrayList<>();
            
            // Find all products that start with the current prefix
            for (String product : products) {
                if (product.startsWith(prefix.toString())) {
                    suggestions.add(product);
                }
                if (suggestions.size() == 3) break;
            }
            
            // Add the suggestions to the result list
            result.add(suggestions);
        }
        
        return result;
    }
}
