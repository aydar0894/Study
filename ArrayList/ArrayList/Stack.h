#pragma once
#include "stdio.h"
#include "MyArrayList.h"
template<typename T>
class MyStack
{
public:
	MyStack();
	~MyStack();

	void push(T element)
	{			
		arrayList->add(element);
		
	}

	T pop()
	{
		T ret;
		if (arrayList->getCount() > 0)
		{
		    ret = arrayList->getSP();
			arrayList->remove();

		}
		
		return ret;
	}
	T peek()
	{
		T ret;
		if (arrayList->getCount() > 0)
		{
			ret = arrayList->getSP();
			cout << ret;
			return ret;
		}
		else cout << "Стек пуст";
		return ret;
		
	}
private:
	MyArrayList<T> *arrayList = new MyArrayList<T>();
	
};

template <typename T>
MyStack<T>::MyStack()
{
	
}

template <typename T>
MyStack<T>::~MyStack()
{
	delete arrayList;
}

#pragma once
