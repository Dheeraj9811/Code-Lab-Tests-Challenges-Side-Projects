# include <bits/stdc++.h>
using namespace std;

struct node {
    node* link[26];
    bool end = false;
    int pre_fixcount = 0;
    int total_words_end = 0;

    node() {
        // Initialize all link pointers to nullptr
        for (int i = 0; i < 26; i++) {
            link[i] = nullptr;
        }
    }
    // check contains specified char
    bool conatians(char c){
        return link[c-'a'] != nullptr;
    }
    // put character
    void insert(char c, node* link){
        cout<<"inside insert "<<link;
        this->link[c-'a'] = link;
    }

    node* get(char c){
        return this->link[c-'a'];
    }

    bool isEnd(){
        return this->end;
    }

    void incrementEndCount(){
        this->total_words_end++;
    }

    void incrementpre_fixcount(){
        this->pre_fixcount++;
    };

};

class trie{
    private:
        node* root;
    public:
        trie(){
            this->root = new node();
        }

        void insert(string word){
            node* temp = this->root;
            for(int i =0;i<word.length();i++){
                if(!temp->conatians(word[i])){
                    temp->insert(word[i] , new node());
                }

                temp = temp->get(word[i]);
                temp->incrementpre_fixcount(); // increasing the char count

            }

            // after insert , mark the as done
            temp->end = true;
            temp->incrementEndCount();
        }

        bool search(string word){
            node* temp = root;
            for(int i = 0;i<word.length();i++){
                char c = word[i];
                if( ! temp->conatians(c)) return false;

                // move to next node
                temp = temp->get(c);
            }

            return temp->isEnd();
        }

        int isPrefixCount(string prefix){
            node* temp = root;
            for(int i = 0;i<prefix.length();i++){
                char c = prefix[i];
                if( ! temp->conatians(c)) return 0;

                // move to next node
                temp = temp->get(c);
            }

            return temp->pre_fixcount;
        }

        int count(string word){
            node* temp = root;
            for(int i = 0;i<word.length();i++){
                char c = word[i];
                // cout<<"insdie count  current char is "<<c<<" root value is -> "<<temp->link[c-'a']<<endl;
                if(!temp->conatians(c)) return 0;

                temp = temp->get(c);
            }

            return temp->total_words_end;
        }

        // assumption word alaways exist which are deleting 
        void remove(string word){
            node* temp = root;
            for(int i = 0;i<word.length();i++){
                char c = word[i];
                if(!temp->conatians(c)) return;
                // cout<<" temp is = "<<temp->link[c-'a']<<endl;
                temp = temp->get(c);
                // cout<<"we are looking at "<<c<<" and its precount = "<<temp->pre_fixcount<<endl;
                --temp->pre_fixcount;
                if(temp->pre_fixcount <=0){
                    deleteSubtree(temp->get(c));   // Free memory for the next node
                    temp->insert(c, nullptr); // Set the link to nullptr
                    
                }
            }
            if(temp->isEnd()) temp->total_words_end--;
        }
        void deleteSubtree(node* current) {
            if (!current) return;
            for (int i = 0; i < 26; i++) {
                if (current->link[i]) {
                    deleteSubtree(current->link[i]); // Recursively delete child nodes
                    current->link[i] = nullptr;
                }
            }
            delete current; // Delete the current node
        }


};

// class Solution {
// public:
//     vector<string> stringMatching(vector<string>& words) {

//     }
// };

int main(int argc, char const *argv[])
{
    /* code */
    trie my;
    my.insert("apple"); my.insert("heman"); my.insert("apply"); my.insert("cat"); my.insert("dheeraj"); my.insert("dheeraj"); my.insert("dheeraj");
    cout<<"searching dheeraj "<<my.search("dheeraj")<<endl;
    cout<<"count  "<<my.count("dheeraj")<<endl;
    my.remove("dheeraj");
    cout<<"------------------------"<<endl;
    cout<<"count  "<<my.count("dheeraj")<<endl;
    my.remove("dheeraj");
    cout<<"------------------------"<<endl;
    
    
    
    // cout<<"count  "<<my.count("dheeraj")<<endl;
    // my.remove("dheeraj");
    // cout<<"------------------------"<<endl;
    string val = "abc";
    int size = val.length();
    int *arr = new int[size];
   my.remove("dheeraj");
    cout<<"count  "<<my.count("dheeraj")<<endl;

    
    cout<<"prefix  "<<my.isPrefixCount("dhee")<<endl;

    return 0;
}
