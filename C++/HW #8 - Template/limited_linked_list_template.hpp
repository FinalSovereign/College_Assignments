#ifndef LIMITED_LINKED_LIST_TEMPLATE_HPP_INCLUDED
#define LIMITED_LINKED_LIST_TEMPLATE_HPP_INCLUDED

template<class T>
class List
{
    struct Node
    {
        T data;
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

        void add(T value)
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


#endif // LIMITED_LINKED_LIST_TEMPLATE_HPP_INCLUDED
