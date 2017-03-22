using System.Diagnostics.Contracts;

namespace Innopolis_Univwrsity_IS.University_IS
{
    class Student : Person
    {

        private Group studentGroup;
        private Department studentDepartment;

        internal Group StudentGroup
        {
            get
            {
                return studentGroup;
            }

            set
            {
                Contract.Assert(value != null, "Set the correct Group");
                studentGroup = value;
            }
        }

        internal Department StudentDepartment
        {
            get
            {
                return studentDepartment;
            }

            set
            {
                Contract.Assert(value != null, "Set the correct Department");
                studentDepartment = value;
            }
        }

        public Student(string name,int count)
        {
            Contract.Assert(name != null, "Enter the correct name");
            this.Id = count;
            this.Name = name;
            StudentDepartment = new Department();
            StudentGroup = new Group();
        }
    }
}
