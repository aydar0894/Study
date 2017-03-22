#pragma once
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <stdio.h>
#include <limits.h>

typedef struct listNode
{
	int inf;
	struct listNode *next;
};



void add(struct listNode *head, int elem)
{
	if (head->inf == INT_MAX)
	{
		head->next = (struct listNode*)malloc(sizeof(struct listNode));
		head->next->inf = INT_MAX;
		head->inf = elem;
	}
	else
	{
		struct listNode *temp = head;
		while (temp->inf != INT_MAX) temp = temp->next;
		temp->next = (struct listNode*)malloc(sizeof(struct listNode));
		temp->next->inf = INT_MAX;
		temp->inf = elem;
	}
}
void del(struct listNode **head)
{
	
	if ((*head)->inf == INT_MAX)
	{
		printf("There is nothing to delete!!\n");
		return;
	}
	if ((*head)->next->inf == INT_MAX)
	{
		*head = (*head)->next;
		return;
	}
	struct listNode *temp = *head;
	while (temp->next->next->inf != INT_MAX) temp = temp->next;
	temp->next = temp->next->next;
}

void show(struct listNode *head)
{

	if (head->inf == INT_MAX)
	{
		printf("No elements in list\n");
		return;
	}
	struct listNode *temp = head;
	while (temp->next->inf != INT_MAX) temp = temp->next;
	
	printf("%d\n", temp->inf);
}