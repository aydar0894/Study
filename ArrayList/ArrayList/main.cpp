#include "stdio.h"
#include <iostream>
#include "Stack.h"
#include <string>
#include <cstdlib>


using namespace std;

int main()
{
	setlocale(LC_ALL, "Russian");
	int *in = (int*)malloc(4);

	MyStack<string> *stack = new MyStack<string>();

	string element;
	while (*in != 4)
	{
		printf("\n1.�������� �������\n");
		printf("2.������� �������\n");
		printf("3.������� �������\n");
		printf("4. �����\n");
		void *v;
		string *s;
		scanf_s("%d", in);
		switch (*in)
		{
		case 1:
			printf("������� �������:\n");
			cin >> element;
			stack->push(element);
			break;
		case 2:
			stack->pop();
			break;
		case 3:
			stack->peek();
			break;
		case 4:			
			return 0;
			break;

		}
	}

	return 0;
}


