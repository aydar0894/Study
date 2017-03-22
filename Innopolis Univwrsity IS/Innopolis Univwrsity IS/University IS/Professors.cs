using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Innopolis_Univwrsity_IS.University_IS
{
    unsafe class Professors
    {
        private int count;
        private Professor[] professors = new Professor[10];

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

        internal Professor[] Professors1
        {
            get
            {
                return professors;
            }

            set
            {
                professors = value;
            }
        }

        public Professors()
        {
            Count = 0;
        }

        public Professor add(string name, string degree)
        {
            Professors1[Count] = new Professor(name, degree, Count);
            Count++;
            return Professors1[Count - 1];
        }
        public Professor add(Professor prof)
        {
            Professors1[Count] = prof;
            Count++;
            return prof;
        }
        public Professor search(string name)
        {
            for (int i = 0; i < Count; i++)
            {
                if (Professors1[i].Name == name) return Professors1[i];
            }
            return null;
        }
    }
}
