#include <iostream>
#include <unordered_map>
#include <set>

using namespace std;

int main(){
    int n;
    cin >> n;
    
    unordered_map<string, bool> office;
    
    for (int i = 0; i < n; i ++ ) {
        string name, status;
        cin >> name >> status;
        
        if (status == "enter"){
            office[name] = true;
        } else { office.erase(name);}
    }

    set<string, greater<string>> sorted_map;
    for (auto &entry : office){
        sorted_map.insert(entry.first);
    }
    
    for(const string &name : sorted_map){
        cout << name << '\n';
    }
    
    return 0;
}