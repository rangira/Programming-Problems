#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int a[26] = { 0 }, need[26] = { 0 };

int main() {
/* Enter your code here. Read input from STDIN. Print output to STDOUT */
string s;
cin >> s;
reverse(s.begin(), s.end());
int sz = s.size();
for (auto c : s)
++a[c - 'a'];
for (int i = 0; i < 26; ++i) {
need[i] = a[i] / 2;
}
int i = 0, pos=-1;
string output;
while (output.size() < sz / 2) {
pos = -1;
while (true) {
char c = s[i];
if ((need[c - 'a'] > 0) && (pos < 0 || c < s[pos]))
pos = i;
--a[c - 'a'];
if (a[c - 'a'] < need[c - 'a'])
break;
++i;
}

for (int j = pos + 1; j < i + 1; ++j)
++a[s[j] - 'a'];

--need[s[pos]-'a'];
output += s[pos];

i = pos + 1;

}
cout << output << endl;
return 0;
}