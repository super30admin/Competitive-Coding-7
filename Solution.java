class MagicDictionary {
    List<String> magicList;
    int count;
    public MagicDictionary() {
        magicList = new ArrayList<>();
    }
    
    public void buildDict(String[] dictionary) {
        for(int i = 0; i < dictionary.length; i++){
            magicList.add(dictionary[i]);
        }
    }
    
    public boolean search(String searchWord) {
        for(int i = 0; i < magicList.size(); i++){
            count = 0;
            if(searchWord.length() == magicList.get(i).length()){
                for(int j = 0; j < searchWord.length(); j++){
                    char chSearchWord = searchWord.charAt(j);
                    char chMagicList = magicList.get(i).charAt(j);
                    if(chMagicList != chSearchWord){
                        count++;
                        if(count > 1)
                            break;
                    }
                }
            }
            if(count == 1){
                return true;
            }
                    
        }
        return false;
    }
        
}


/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
