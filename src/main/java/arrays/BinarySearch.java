class BinarySearch{
    public static void main(String[] args) {
        int nums[] = {-1,0,3,5,9,12,15};
        int idx = searchBF(nums, 2);
        System.out.println("---test---");
        System.out.println("idx: "+idx);
        int idxBS = searchBinary(nums, 2);
        System.out.println("idxBS: "+idxBS);
    }

    public static int searchBF(int[] nums, int target){
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static int searchBinary(int[] nums, int target){
        int len = nums.length;
        int mid = len/2;
        int left = 0;
        int right = nums.length-1;
        if(nums[mid] == target){
            return mid;
        } 
        while(left<=right){
            mid = left + (right-left)/2;
            if(nums[mid]==target){
                return mid;
            } else if(target<nums[mid]){
                right = mid-1;
            } else{
                left = mid+1;
            }
        }

        
        return -1;
    }

   
}