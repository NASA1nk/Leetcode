class Solution {
  public String findLongestWord(String s, List<String> dictionary) {
      // Collections工具类
      // String自带的排序 return s1.compareTo(s2);
      Collections.sort(dictionary,new Comparator<String>(){
          @Override
          public int compare(String s1,String s2){
              if(s1.length() == s2.length()){
                  int i = 0;
                  while(i < s1.length()){
                      if(s1.charAt(i) != s2.charAt(i)){
                          return s1.charAt(i) - s2.charAt(i);
                      }
                      i++;
                  }
              }   
              else{
                  return -(s1.length()-s2.length());
              }
              return 1;
          }
      });
      Iterator<String> it = dictionary.iterator();
      char[] t = s.toCharArray();
      while(it.hasNext()){     
          char[] st = it.next().toCharArray();
          // 字符串匹配
          if(isVaild(t,st)){
              return new String(st);
          }
      }
      return "";
  }
  public boolean isVaild(char[] t, char[] st){
      int i = 0;
      int l = 0;
      while(i < st.length){
          while(l < t.length && st[i] != t[l]){
              l++;
          }
          if(l == t.length && i != st.length){
              return false;
          }
          i++;
          l++;
      }
      return true;
  }
}