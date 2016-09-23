public class Solution {
Map<Character, String> store; // store bijections
Set<String> values; // make sure values in the map are unique
public boolean wordPatternMatch(String pattern, String str) {
    store = new HashMap<>();
    values = new HashSet<>();
    return dfs(pattern, str);
}

private boolean dfs(String pattern, String str) {
    if (pattern.length() == 0 || str.length() == 0) { // base case
        return pattern.length() == 0 && str.length() == 0;
    }
    char c = pattern.charAt(0);
    if (store.get(c) != null) { // bijection exists
        if (str.startsWith(store.get(c))) {
            return dfs(pattern.substring(1), str.substring(store.get(c).length()));
        } else {
            return false;
        }
    } else { // bijection not exists
        for (int i = 1; i <= str.length() - pattern.length() + 1; i++) {
            String s = str.substring(0, i);
            if (values.contains(s)) continue;
            store.put(c, s);
            values.add(s);
            if (dfs(pattern.substring(1), str.substring(i))) return true;
            values.remove(s); // backtrack
        }
        store.remove(c); // backtrack
    }
    return false;
}
}
