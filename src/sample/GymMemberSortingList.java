package sample;

public class GymMemberSortingList {
    public static void bubbleSort(DefaultMember[] arr, boolean asc){
        for(int a =0 ; a < arr.length - 1;  a++ ){
            for(int b =0 ; b< arr.length - (a+1); b++){
                if(asc){
                    if (arr[b].getGymMemberName().compareTo(arr[b+1].getGymMemberName()) > 0){
                        DefaultMember temp = arr[b];
                        arr[b] = arr[b+1];
                        arr[b+1] = temp;
                    }
                }
            }
        }
    }
}