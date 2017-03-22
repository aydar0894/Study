
using System.Diagnostics.Contracts;

namespace Innopolis_Univwrsity_IS.University_IS
{
    class Person
    {
        private int id;
        private string name;

        public int Id
        {
            get
            {
                return id;
            }

            set
            {
                id = value;
            }
        }

        public string Name
        {
            get
            {
                return name;
            }

            set
            {
                Contract.Assert(value != null, "Set the correct name");
                name = value;
            }
        }

        public Person()
        {

        }
    }
}
