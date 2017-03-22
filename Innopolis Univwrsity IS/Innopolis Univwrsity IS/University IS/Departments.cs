using System.Diagnostics.Contracts;

namespace Innopolis_Univwrsity_IS.University_IS
{
    class Departments
    {
        public Department[] departments = new Department[4];
        private int count;
        public  Departments()
        {
            Contract.Invariant(count >= 0, "Illegal count value");
            Count = 0;
            departments[0] = new Department("Computer scinse",Count);
            Count = 1;
        }

        public int Count
        {
            get
            {
                return count;
            }

            set
            {
                count = value;
            }
        }

        public Department add(string name)
        {
            departments[Count] = new Department(name,Count);
            Count++;
            return departments[Count - 1];
        }
        public Department add(Department dept)
        {
            departments[Count] = dept;
            Count++;
            return departments[Count - 1];
        }
        public void del(string name)
        {
            Contract.Invariant(count >= 0, "Illegal count value");
            departments[Count--] = null;
        }

        public Department search(string name)
        {
            for(int i = 0;i<Count;i++)
            {
                if (departments[i].Name == name) return departments[i];
            }
            return null;
        }
    }
}
