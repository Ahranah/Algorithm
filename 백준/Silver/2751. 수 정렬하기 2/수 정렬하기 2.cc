#include <iostream>
using namespace std;


void showArr(int* arr, int length) {
    for (int i = 0; i < length; i++) cout << arr[i] << " ";
    cout << endl;
}

void mergeSort(int* arr, int* sortedArr, int begin, int end){
    int middle;
    //분할
    if(begin<end){
        middle = (begin+end)/2;
        mergeSort(arr,sortedArr,begin,middle);
        mergeSort(arr,sortedArr,middle+1,end);
        //병합
        int left = begin; int right = middle+1; int arrIndex = begin;
        while (left <= middle && right <= end) {
            if (arr[left] < arr[right]) sortedArr[arrIndex] = arr[left++];
            else sortedArr[arrIndex] = arr[right++];
            arrIndex++;
        }
        if (left > middle) while(right <= end) sortedArr[arrIndex++] = arr[right++];
        if(right > end) while(left <= middle) sortedArr[arrIndex++] = arr[left++]; 
        for (int k = begin; k <= end; k++) arr[k] = sortedArr[k];

    }
}

int main(){
    int N;
    cin >> N;
    int arr[N];
    int sortedArr[N];
    for(int i=0;i<N;i++) cin >> arr[i];
    
    mergeSort(arr, sortedArr, 0, N-1);
    showArr(arr, N);

    return 0;
}