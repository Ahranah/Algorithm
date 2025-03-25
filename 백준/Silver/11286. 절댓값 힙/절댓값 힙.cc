#include <bits/stdc++.h>

using namespace std;

struct Compare
{
    bool operator()(int a, int b){
        if (abs(a) == abs(b)) return a>b; 
        // priority_queue 크다고 판단되는 값이 우선순위가 낮다: 작은 수 우선
        return abs(a) > abs(b);
    }
};

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr); 
    // 기본적으로 cin은 cout과 묶여 있어서, cin 하기 전에 cout을 flush(강제 출력) 되는 상황 방지

    priority_queue<int, vector<int>, Compare> pq;

    int n; cin >> n;
    while (n--){
        int x;
        cin >> x;

        if (x==0){
            if(pq.empty()) cout << "0\n";
            else {
                cout << pq.top() << endl;
                pq.pop();
            }
        } else {
            pq.push(x);
        }
    }

    return 0;
}