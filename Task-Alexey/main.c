#include <stdio.h>

int findLargestNum(int * array, int size){
  
  int i;
  int largestNum = -1;
  
  for(i = 0; i < size; i++){
    if(array[i] > largestNum)
      largestNum = array[i];
  }
  
  return largestNum;
}

// Radix Sort
void radixSort(int * array, int size){
  
  // printf("\n\nRunning Radix Sort on Unsorted List!\n\n");

  // Base 10 is used
  int i;
  int semiSorted[size];
  int significantDigit = 1;
  int largestNum = findLargestNum(array, size);
  
  // Loop until we reach the largest significant digit
  while (largestNum / significantDigit > 0){
    
 // printf("\tSorting: %d's place ", significantDigit);
 // printArray(array, size);
    
    int bucket[10] = { 0 };
    
    // Counts the number of "keys" or digits that will go into each bucket
    for (i = 0; i < size; i++)
      bucket[(array[i] / significantDigit) % 10]++;
    
    /**
     * Add the count of the previous buckets,
     * Acquires the indexes after the end of each bucket location in the array
		 * Works similar to the count sort algorithm
     **/
    for (i = 1; i < 10; i++)
      bucket[i] += bucket[i - 1];
    
    // Use the bucket to fill a "semiSorted" array
    for (i = size - 1; i >= 0; i--)
      semiSorted[--bucket[(array[i] / significantDigit) % 10]] = array[i];
    
    
    for (i = 0; i < size; i++)
      array[i] = semiSorted[i];
    
    // Move to next significant digit
    significantDigit *= 10;
    
 // printf("\n\tBucket: ");
 // printArray(bucket, 10);
  }
}

int gcd(int m, int n) {
    int tmp;
    while(m) { tmp = m; m = n % m; n = tmp;}
    return n;
}

int lcm(int m, int n) {
    return m / gcd(m, n) * n;
}

// Developer: Raul Flores Miramontes A01224188
// Code for lcm, gcd and radixSort, and findLargestNum are taken from
// revised internet sources with their proper algorithm implementation

int main() {
    printf("Insert the number of test cases\n");
    printf("Insert the number of sensors\n");
    printf("Insert the frequency of measurements on each sensor\n");
    printf("Example input:\n3\n4\n2 4 7 8\n");
    printf("Begin now\n");

    int t, s, r, q, p, o;
    scanf("%d", &t);

    for (int i = 0; i<t; i++) {
        r = 0;
        scanf("%d", &s);
        int list[s];
        for (int j = 0; j<s; j++) {
            scanf("%d", &list[j]);
        }
        radixSort(&list[0], s);
        q = lcm(list[r], list[r+1]);
        for (int k = 2; k<s; k++) {
            if (list[k] <= q) {
                p = lcm(list[r], list[k]);
                // printf("Value of lcm %d\n", p);
                if (p < q) {
                    q = p;
                    r = k;
                    // printf("First path %d %d %d %d\n", p, q, r, k);
                } else if (list[k] == list [k-1]) {
                    if (list[k] < q) {
                        q = list[k];
                        r = k;
                        break;
                        // printf("Second path %d %d %d %d\n", p, q, r, k);
                    }
                } else {
                    for (int l = 0; l<k; l++) {
                       o = lcm(list[l], list[k]);
                       if (o < q) {
                           q = o;
                           r = k;
                           // printf("Third path %d %d %d %d\n", o, q, r, k);
                       } 
                    }
                }
            }
        }
        printf("The first freeze will occur at %d milliseconds\n", q);
    }
}