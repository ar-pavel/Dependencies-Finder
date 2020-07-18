#include "bits/stdc++.h"
 
using namespace std;
 

int n;
vector<vector<int>> adj;

set<int>discovered;

queue<char>res;
deque<pair<string,int>>hir;


string toString(int a){
	char c = char('A' + a);

	string x = "Class";
	x.push_back(c);

	return x;
	// return to_string(c);
}


void dfs(int v, int d){

	if(discovered.find(v) != discovered.end()){
		// cout <<char('A' + v)<<"\t"<<"*"<<endl;
		// res.pop();
		auto c = hir.back();
		hir.pop_back();
		hir.push_back({c.first+" *",c.second});
		res.push('*');
		return;
	}

	// cout<<char('A' + v)<<endl;
	res.push(char('A' + v));

	res.push('(');

	hir.push_back({ toString(v) , d});

	discovered.insert(v);

	for(auto u : adj[v])
		dfs(u, d+1);
	
	// if(res.back()=='(')
	// 	res.pop();
	// else
		res.push(')');

	discovered.erase(v);
}




bool isAlpha(char c){

	return c>='A' and c<='Z';
}

void ParenthesizedList(queue<char> res){
	cout<<"( ";
	while(res.size()){
		char c = res.front();
		res.pop();

	
		if(c=='('){
			if(res.front()==')'){
				res.pop();
				continue;
			}else if(res.front()=='*'){
				cout<<res.front()<<" ";
				res.pop();
				res.pop();
				continue;
			}

			// if(res.front=='*')
		}
		cout<<(!isAlpha(c)?"":"Classs")<<c<<" ";


	
	}
	cout<<")"<<endl<<endl;
}

void Hierarchy(){
	while(hir.size()){
		for(int i=0; i<hir.front().second; ++i)
			cout<<"\t";
		cout<<(hir.front().first)<<endl;
		hir.pop_front();

	}
}

int main(){
	#ifndef ONLINE_JUDGE
	    freopen("in.txt","r",stdin);
	    freopen("out.txt","w",stdout);
	#endif
	ios::sync_with_stdio(false);
	cin.tie(0);cout.tie(0);

	n=10;

	adj.resize(n);

	adj[0] = {1,2};
	adj[1] = {2,3};
	adj[2] = {3,1};
	adj[4] = {0,1};

	// dfsUtil(0);
	dfs(0, 0);

	ParenthesizedList(res);

	Hierarchy();
	

    return 0;
}
