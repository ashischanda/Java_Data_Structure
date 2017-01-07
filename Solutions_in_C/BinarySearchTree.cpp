//  ******** From this progrma you will see the tree diagram
//  ******** You can find out a parnent node and also the location of given node
//  ******** Then you can also see it's successor ************


#include<stdio.h>
#include<stdlib.h>

typedef struct d
{
    int root;
    struct d *left;
    struct d *right;
}TREE;

TREE *parent=NULL, *location=NULL;


TREE *create(TREE *t, int num)
{

    if(t==NULL){
        t = (TREE *) malloc(sizeof(TREE) );

        t->root=num;
        t->left=t->right=NULL;
    }
    else if(num<t->root)
        t->left=create(t->left,num);
    else if(num>t->root)
        t->right=create(t->right, num);

    return t;
}

void print(int height, TREE *t)
{
    int i=0;
    if(NULL!=t){
        print(height+1, t->right);
        printf("\n ");

        for(i=0;i<height;i++)
            printf(" ");

        printf(" %d ",t->root);
        print(height+1, t->left);
    }

}

void search(int item,TREE *ptr)
{
     while( item!=ptr->root)
     {
            parent=ptr;
            if(item<ptr->root)
                              ptr=ptr->left;
            else
                ptr=ptr->right;

            location=ptr;      // ptr is changed
     }
}


int sma(TREE *t)
{
    if(t->root==NULL)
        return 0;
    while(t->left!=NULL){
        t=t->left;
    }
    //printf("do\n");

    return t->root;
}

int main()
{
    TREE *tree=NULL, *x, *y;
    int n;

    while(1){

        printf("\ngive value :");
        scanf("%d",&n);
        if(n==999)
            break;
        tree=create(tree, n);
    }
    print(1, tree);               //  ******************      printing the tree
    printf("\nGive value to find location & parent:");
    scanf("%d",&n);
    search(n,tree);                 //    *****************      Parent

    if(location==NULL)
                      printf("It have no Parent\n");
    else
        printf("\nThe parent of node is %d given value %d\n",parent->root, location->root);


// ***************************************************       the part of successor
    x=location;
    y=parent;
    if(x==NULL)
               x=tree;            // if the given number is root

    if(x->right!=NULL){
                      int minimum=sma(x->right);
                      printf("The successor is %d of %d\n",minimum, x->root);
    }
    else{
         while(y!=NULL && y->right!=NULL && (x->root== y->right->root) )
         {
                       x=y;
                       search(y->root, tree);
                                                     // printf("%d y root par %d\n",y->root, parent->root);
                       y=parent;
         }
         printf("The successor is %d\n",y->root);
    }
    free(tree);
    getchar();

    return 0;
}
