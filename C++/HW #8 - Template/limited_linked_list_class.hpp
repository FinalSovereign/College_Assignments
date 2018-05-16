#ifndef LIMITED_LINKED_LIST_CLASS_HPP_INCLUDED
#define LIMITED_LINKED_LIST_CLASS_HPP_INCLUDED

class List
{
    struct Node
    {
        int data;
        Node * next;
    };

    Node * head;

    public:
        List()
        {
            head = NULL;
        }

        ~List() // delete the list
        {
            while(head != NULL)
            {
                Node * n = head->next;
                delete head;
                head = n;
            }
        }

        void add(int value)
        {
            Node * n = new Node;
            n->data = value;
            n->next = head;
            head = n;
        }

        void show()
        {
            while(head !=NULL)
            {
                Node * n = head->next;
                std::cout << head->data << ", ";
                head = n;
            }

            std::cout << std::endl;
        }

};


#endif // LIMITED_LINKED_LIST_CLASS_HPP_INCLUDED
