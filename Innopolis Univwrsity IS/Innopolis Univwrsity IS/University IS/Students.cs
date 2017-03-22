using System.Diagnostics.Contracts;

namespace Innopolis_Univwrsity_IS.University_IS
{
    class Students
    {
        private int count;
        private Student[] students = new Student[100];

        public int Count
        {
            get
            {
                return count;
            }

            set
            {
                count = value;
                Contract.Ensures(Count > 0, "Count is less than 0!");
            }
        }

        internal Student[] Students1
        {
            get
            {
                return students;
            }

            set
            {
                students = value;
            }
        }

        public Students()
        {
            Count = 0;
        }
        public Student add(string name)
        {
            Students1[Count] = new Student(name, Count);
            Count++;
            Contract.Ensures(Count > 0, "Count is less than 0!");
            return Students1[Count - 1];
        }
        public Student add(Student stud)
        {
            Students1[Count] = stud;
            Count++;
            Contract.Ensures(Count > 0, "Count is less than 0!");
            return Students1[Count - 1];
        }

        public Student search(string name)
        {
            for (int i = 0; i < Count; i++)
            {
                if (Students1[i].Name == name) return Students1[i];
            }
            return null;
        }
    }
}
