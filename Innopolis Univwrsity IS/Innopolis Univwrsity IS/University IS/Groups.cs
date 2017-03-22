using System.Diagnostics.Contracts;

namespace Innopolis_Univwrsity_IS.University_IS
{
    class Groups
    {
        private int count;
        public Group[] groups = new Group[10];

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

       

        public Groups()
        {
            Contract.Invariant(count >= 0, "Illegal count value");
            Count = 0;
        }

       
        public Group add(Group g)
        {
            groups[Count] = g;
            Count++;
            return groups[Count - 1];
        }

        public Group add(string name)
        {
            groups[Count] = new Group(name,Count);
            Count++;
            return groups[Count - 1];
        }
        public Group search(string name)
        {
           
            for (int i = 0; i < Count; i++)
            {
                if (groups[i].Name == name) return groups[i];
            }
            return null;
        }
    }
    
  
}
