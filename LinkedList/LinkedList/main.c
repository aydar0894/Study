#include "LinkedList.h"

int main()
{
	struct listNode *head = (struct listNode*)malloc(sizeof(struct listNode));
	head->inf = INT_MAX;
	int choice = 0;
	int exit = 0;
	
	while (exit != 1)
	{
		//menu
		printf("Choose the action:\n");
		printf("1.Add new element\n");
		printf("2.Delete the last element\n");
		printf("3.Show last element\n");
		printf("4.Exit\n");
		//
		int element = 0;
		scanf("%d", &choice);
		switch (choice)
		{
		case 1:
			printf("Enter an element to add\n");
			scanf("%d", &element);
			add(head, element);
			break;
		case 2:
			del(&head);
			break;
		case 3:
			show(head);
			break;
		case 4: 
			exit = 1;
			break;
		default:
			break;
		}
	}
}