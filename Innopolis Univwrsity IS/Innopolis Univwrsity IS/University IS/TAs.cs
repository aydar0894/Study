using System.Diagnostics.Contracts;

namespace Innopolis_Univwrsity_IS.University_IS
{
    class TAs
    {
        private TA[] tas = new TA[10];
        private int count;

        public int Count
        {
            get
            {
                return count;
            }

            set
            {
               // Contract.Assert(value > 0, "Set the correct Professor");
                count = value;
                
            }
        }

        internal TA[] Tas
        {
            get
            {
                return tas;
            }

            set
            {
                tas = value;
            }
        }

        public TAs()
        {
            Count = 0;
        }

        public int getCount()
        {
            return Count;
        }
        public void setCount(int count)
        {
            this.Count = count;
        }
         
        public TA add(string name)
        {
            Tas[Count] = new TA(name,Count);
            Count++;
            Contract.Ensures(Count > 0, "Count is less than 0!");
            return Tas[Count - 1];
        }
        public TA add(TA ta)
        {
            Tas[Count] = ta;
            Count++;
            Contract.Ensures(Count > 0, "Count is less than 0!");
            return Tas[Count - 1];
        }

        public TA search(string name)
        {
            for (int i = 0; i < Count; i++)
            {
                if (Tas[i].Name == name) return Tas[i];
            }
            return null;
        }


    }
}
