class Solution {
    String delimeter = "#--deli--$";
    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();
        if (strs.size() == 0) return null;
        for (int i = 0; i < strs.size(); i++) {
            String s = strs.get(i);
            sb.append(s);
            sb.append(delimeter);
            sb.append(s.length());
            sb.append(delimeter);
            // for (int j = 0; j < s.length(); j++) {
            //     sb.append((int)s.charAt(j));
            // }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str == null) return new ArrayList();
        String[] list = str.split(Pattern.quote(delimeter));
        List<String> result = new ArrayList();
        for (int i = 0 ; i < list.length ; i = i + 2) {
            result.add(list[i]);
        }
        return result;
    }
}
