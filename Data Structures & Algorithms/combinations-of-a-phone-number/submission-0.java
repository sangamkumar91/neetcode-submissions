class Solution {
    Map<Integer, List<Character>> dial = Map.of(
        2, List.of('a','b','c'),
        3, List.of('d','e','f'),
        4, List.of('g','h','i'),
        5, List.of('j','k','l'),
        6, List.of('m','n','o'),
        7, List.of('p','q','r','s'),
        8, List.of('t','u','v'),
        9, List.of('w','x','y', 'z')
    );
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList();
        return helper(digits, 0);
    }
    public List<String> helper(String digits, int index) {
        if (index == digits.length() - 1)
            return dial.get(digits.charAt(index) - '0')
            .stream()
            .map(c -> Character.toString(c)).collect(Collectors.toList());
        
        List<String> children = helper(digits, index + 1);
        List<String> result = new ArrayList();

        for (char c : dial.get(digits.charAt(index) - '0')) {
            for (String s : children)
                result.add(c + s);
        }
        return result;
    }

}
