#include <cmath>
#include <cstring>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int t;
    cin>>t;
    while(t--){
    char str[1000000];
    long  i,cnt =0,n;
    cin>>str;
    n = strlen(str);
    for(i=0;i<n-1;i++)
        {
        if(str[i]==str[i+1])
            {
            cnt++;
        }
    }
    cout<<cnt<<endl;
    }
    return 0;
}