package s11;

import java.io.*;
import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for(String temp : phone_book) {
        	set.add(temp);
        }
        if(dfs(0,set))return false;
        return true;
    }
    private boolean dfs(int depth, Set<String> set) {
    	if(set.size()<=1) {
    		return false;
    	}
    	for(int i = 0;i<=9;i++) {
    		Set<String> temp = new HashSet<>();
    		for(String word : set) {
    			if(word.length()==depth) return true;
    			if(word.charAt(depth)==('0'+i)) {
    				temp.add(word);
    			}
    		}
    		if(dfs(depth+1,temp))return true;
    	}
    	return false;
    }
}
