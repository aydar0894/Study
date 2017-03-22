#include <iostream>
#include <cstdlib>
#include <math.h>

using namespace std;

struct TREE {
	int info, count;
	TREE *left, *right;
};

TREE *root = NULL;
int flag = 0;
int count1 = 0;

TREE *Search(int info)
{
	TREE *current = root;
	flag = 0;
	while (current != NULL && flag == 0)
	{
		if (info<current->info)
			current = current->left;
		else if (info>current->info)
			current = current->right;
		else
			flag = 1;
	}
	return current;
}

void Add(TREE **current, int info)
{
	if (*current != NULL)
	{
		if (info<(*current)->info)
			Add(&(*current)->left, info);
		else if (info>(*current)->info)
			Add(&(*current)->right, info);
		else
			(*current)->count++;
	}
	else
	{
		*current = new TREE;
		(*current)->info = info;
		(*current)->left = NULL;
		(*current)->right = NULL;
		(*current)->count = 1;
		count1++;
	}
}

int treeHeight(TREE *current)
{
	

	if (current != NULL)
	{
		if (current->left == NULL && current->right == NULL) return 1;
		else if(current->left != NULL && current->right == NULL) return treeHeight(current->left)+1;
		else if (current->left == NULL && current->right != NULL) return treeHeight(current->right) + 1;
		else
		{
			return std::fmax(treeHeight(current->left), treeHeight(current->right)) + 1;
		}
		
	}
	
}

void Changer(TREE **current, TREE **tmp)
{
	if ((*current)->right != NULL)
		Changer(&(*current)->right, &(*tmp));
	else
	{
		(*tmp)->info = (*current)->info;
		*tmp = *current;
		*current = (*current)->left;
	}
}

int Delete(TREE **current, int info)
{
	int r = 0;
	if (*current != NULL)
	{
		if (info<(*current)->info)
			r = Delete(&(*current)->left, info);
		else if (info>(*current)->info)
			r = Delete(&(*current)->right, info);
		else
		{
			if ((*current)->count>1)
			{
				(*current)->count--;
				r = 1;
			}
			else
			{
				TREE *tmp = *current;
				if (tmp->right == NULL)
					*current = tmp->left;
				else if (tmp->left == NULL)
					*current = tmp->right;
				else
					Changer(&(*current)->left, &tmp);
				delete tmp;
				count1--;
				r = 1;
			}

		}
	}
	return r;
}



void preorderTraverse(TREE *current)
{
	if (current != NULL)
	{				
		cout << current->info << " ";
		preorderTraverse(current->left);
		preorderTraverse(current->right);
	}
}

void inorderTraverse(TREE *current)
{
	if (current != NULL)
	{
		inorderTraverse(current->left);
		cout << current->info << " ";
		inorderTraverse(current->right);
	}
}

void Clear(TREE **current)
{
	if (*current != NULL)
	{
		Clear(&(*current)->left);
		Clear(&(*current)->right);
		delete *current;
		count1--;
		if (count1 == 0)
			*current = NULL;
	}
}

int main()
{
	int *height = (int*)malloc(4);
	setlocale(LC_ALL, "Russian");
	int n, num;
	char choice;
	while (1)
	{
		cout << endl << "������ �������� � ������� ������" << endl;
		cout << "-------------" << endl;
		cout << "1. �������" << endl;
		cout << "2. ��������" << endl;
		cout << "3. �������" << endl;
		cout << "4. �������-������������ �����" << endl;
		cout << "5. ����� �� ���������" << endl;
		cout << "6. ��������" << endl;
		cout << "7. �����" << endl;
		cout << "8. ������� ������ ������" << endl;
		cout << "9. �����" << endl;
		cout << " = ";
		cin >> choice;
	
		switch (choice)
		{
		case '1':
			cout << endl << "���-�� ��������� = ";
			cin >> n;
			for (int i = 0; i<n; i++)
			{
				num = rand() % 100;
				Add(&root, num);
			}
			cout << endl << "�������� ���������" << endl;
			break;
		case '2':
			cout << endl << "������� ������� = ";
			cin >> num;
			Add(&root, num);
			cout << endl << "������� ��������" << endl;
			break;
		case '3':
			if (root != NULL)
			{
				cout << endl << "��������� ������� = ";
				cin >> num;
				if (Delete(&root, num) == 1)
					cout << endl << "������� ������" << endl;
				else
					cout << endl << "������� �� ������" << endl;
			}
			else
				cout << endl << "������ ������" << endl;
			break;
		case '4':
			if (root != NULL)
			{
				preorderTraverse(root);
			}
			else
				cout << endl << "������ ������" << endl;
			break;
		case '5':
			if (root != NULL)
			{
				inorderTraverse(root);
			}
			else
				cout << endl << "������ ������" << endl;
			break;
		case '6':
			Clear(&root);
			cout << endl << "������ �������" << endl;
			break;
		case '7':
			if (root != NULL)
			{
				cout << endl << "����� ������� ���� ����� = ";
				cin >> num;
				TREE *tmp = Search(num);
				if (tmp != NULL)
					cout << endl << "������� ������: " << tmp->info << endl;
				else
					cout << endl << "������� �� ������" << endl;
			}
			else
				cout << endl << "������ ������" << endl;
			break;
			break;
		case '8':
			
			if (root != NULL)
			{
				*height = treeHeight(root);
			}
			printf_s("%d", *height);
			break;
		case '9':
				exit(1);
			break;
		default:
			cout << endl << "������" << endl;
			break;
		}

	}
	cin.get();

}
