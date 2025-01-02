// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
// frequency
//  of at least one of the chosen numbers is different.

// The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
class Solution {

    public void helper(int idx,int[] candidates,int target,List<List<Integer>> ans,List<Integer> inner){
        
            if(target == 0){   //if the number is target is found then combination sum is found.
                ans.add(new ArrayList<>(inner));
                return;
            }
            
        
        if(target<0||idx == candidates.length){  //if sum exceeds or if reached end return
            return; 
        }
        inner.add(candidates[idx]);
        helper(idx,candidates,target-candidates[idx],ans,inner);  //since an element can be picked many times pick the same until the base cond. are met.
        inner.remove(inner.size()-1);
        helper(idx+1,candidates,target,ans,inner);// moving for the next index element.
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();

        //calling the function to find combination sums;
        helper(0,candidates,target,ans,inner);

        return ans;
    }
}
