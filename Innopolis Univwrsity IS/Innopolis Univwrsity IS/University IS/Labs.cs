using System.Diagnostics.Contracts;

namespace Innopolis_Univwrsity_IS.University_IS
{
    class Labs
    {
        private int count;
        private Lab[] labs = new Lab[10];

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

        internal Lab[] Labs1
        {
            get
            {
                return labs;
            }

            set
            {
                labs = value;
            }
        }

        public Labs()
        {
            Contract.Invariant(count >= 0, "Illegal count value");
            Count = 0;
        }
        public Lab search(string name)
        {
            for (int i = 0; i < Count; i++)
            {
                if (Labs1[i].Name == name) return Labs1[i];
            }
            return null;
        }

        public Lab add(string name)
        {
            Labs1[Count] = new Lab(name,Count);
            Count++;
            return Labs1[Count - 1];
            
        }
        public Lab add(Lab lab)
        {
            Labs1[Count] = lab;
            Count++;
            return Labs1[Count - 1];

        }
    }
}
