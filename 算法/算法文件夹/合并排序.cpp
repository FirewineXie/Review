#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int b[99];
template<class Type>
void MergeSort(Type a[], int left , int right){
	if(left < right){
		int i = (left + right) /2;
		MergeSort(a,left ,i);
		MergeSort(a,i+1,right);
		merge(a,b,left,i,right);
		copy(a,b,left,right);
	}
}

int main(){

int a[] = {4, 7,8,2,3,6,9,5,1};

MergeSort(a,3,6);



    return 0;
}
