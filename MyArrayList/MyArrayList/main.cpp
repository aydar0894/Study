#include "stdio.h"
#include <iostream>
#include "MyArrayList.h"
#include <string>
#include <cstdlib>


using namespace std;

int main()
{
	setlocale(LC_ALL, "Russian");
	int *in = (int*)malloc(4);

	MyArrayList<string> *arrayList = new MyArrayList<string>();	
	int index;
	string element;
	while (*in != 4)
	{
		printf("\n1.�������� �������\n");
		printf("2.������� �������\n");
		printf("3.������� i-��� �������\n");
		printf("4. �����\n");		
		
		scanf_s("%d", in);
		switch (*in)
		{
		case 1:
			printf("������� �������:\n");
			cin >> element;
			arrayList->add(element);			
			break;
		case 2:
			arrayList->remove();			
			break;
		case 3:	
			printf("������� ������� i:\n");
			cin >> index;
			cout << (*arrayList)[index];			
			break;
		case 4:
			return 0;
			break;
		}
	}

	return 0;
}


